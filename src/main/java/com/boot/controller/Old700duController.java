package com.boot.controller;

import com.boot.db.dao.CalimMapper;
import com.boot.db.entity.OldLost;
import com.boot.service.OldLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhang.wenhan
 * @description Old700duController
 * @date 2019/7/18 13:23
 */
@RestController
@RequestMapping("/old")
public class Old700duController {

    @Autowired
    OldLostService oldLostService;

    @Autowired
    CalimMapper mapper;

    public static final ThreadPoolExecutor es = new ThreadPoolExecutor(100, 100,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    @GetMapping("/send")
    public String send() {
        long now = System.currentTimeMillis();
        doSend();
        long end = System.currentTimeMillis();
        return "success, 用时" + (end - now) / 1000;
    }

//    @Scheduled(cron = "0 0/20 * * * ?")
    public void sendTask() {

        doSend();
    }

    private void doSend(){
        List<OldLost> list = mapper.getOldLostData();
        int i = 0;
        int all = list.size();
        System.out.println(new Date() + " 开始执行条数： " + all);
        for (OldLost oldLost : list) {
            i++;
            final int j = i;
            es.execute(new Thread(() -> oldLostService.sendRequest(oldLost, j, all)));
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><Type>CHECKPAYVOUCHER</Type><ERPPolicyKey>PL160301000000000010</ERPPolicyKey><PayVoucherKey>PP171216000000000220</PayVoucherKey><BizType>1</BizType><CompKey>CO070703000000000001</CompKey><CSUM>2.72</CSUM><prePolicyCode>000001900955169</prePolicyCode><policyCode>110022335973008</policyCode><policyYear>3</policyYear><timeperYear>1</timeperYear><prodName>人保寿险附加精心优选提前给付全残疾病保险</prodName><prodKey>PR120905000000000001</prodKey><holder>郭丽</holder><insurant>郭丽</insurant><fee>34.0</fee><stype>4</stype><ackDate>2016-03-22</ackDate><payDate>2018-05-05</payDate></root>";
        String url = "https://ssl.700du.cn/erpwebservice.shtml";
        System.out.println();
        System.out.println(new Date() + "开始执行条数：");
    }


}
