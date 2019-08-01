package com.boot.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TestA {

    public static void main(String[] args) {
        String str = "{\"message\":\"captcha\",\"result\":\"succeed\",\"dataGrid\":{\"queryAllowed\":true,\"rows\":[{\"assessmentcano\":\"\",\"brokercano\":\"\",\"business_level\":\"1\",\"cardno\":\"4344\",\"expaire_time\":null,\"gender\":\"女\",\"grant_time\":null,\"name\":\"文丰霞\",\"personid\":\"PE_FIN131681\",\"ualificano\":\"20040511000090000323\",\"ualificatype\":\"销\n" +
                "售\"}],\"total\":1}}";
        JSONObject obj = JSON.parseObject(str);
        JSONObject dataGridSec = obj.getJSONObject("dataGrid");
        System.out.println(dataGridSec.getInteger("total"));

    }

    /**
     * 取北京时间
     * 
     * @return
     */
    public static String getBeijingTime() {
        return getFormatedDateString(8);
    }

    /**
     * 此函数非原创，从网上搜索而来，timeZoneOffset原为int类型，为班加罗尔调整成float类型
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     * 
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }

        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

}
