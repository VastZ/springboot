package com.boot.service;

import com.boot.db.dao.CalimMapper;
import com.boot.db.entity.OldLost;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhang.wenhan
 * @description OldLostServiceImpl
 * @date 2019/7/18 17:15
 */
@Service
public class OldLostServiceImpl implements OldLostService{

    @Autowired
    CalimMapper mapper;

    public static final  String  URL = "https://ssl.700du.cn/erpwebservice.shtml";

    @Override
    @Transactional(timeout = 30, rollbackFor = Exception.class)
    public void sendRequest(OldLost oldLost, int i, int all) {
        try {
            this.doPost(URL, oldLost.getRequest());
            mapper.updateOldLostData(oldLost.getId(), 1);
        } catch (Exception e) {
            mapper.updateOldLostData(oldLost.getId(), 2);
            e.printStackTrace();
        }
        System.out.println("当前执行第" + i + "个, 当前时间戳: " + System.currentTimeMillis());
    }

    private  String doPost(String url, String json) {
        String res = null;
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(url);
        try {
            CloseableHttpClient client = HttpClientBuilder.create().setConnectionTimeToLive(30, TimeUnit.SECONDS)
                    .build();
            // 构造消息头 // 发送Json格式的数据请求
            // post.setHeader("Content-type", APPLICATION_JSON_UTF8_VALUE);
            StringEntity entity = new StringEntity(json, "GBK");
            entity.setContentType(MediaType.TEXT_XML_VALUE);
            post.setEntity(entity);
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                res = EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
