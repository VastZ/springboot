package com.boot.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class InsuranceCheck {
    
    final static String URL_FIRST = "http://iir.circ.gov.cn/ipq/insurance.do?checkcaptch";   //首次请求混合证件接口
    final static String URL_SECOND = "http://iir.circ.gov.cn/web/baoxyx!searchInfo.html";    //二次请求资格证接口
    
    public static void main(String[] args) throws Exception {
        System.out.println(sendPostToGov("李嘉雯", "13012519910925452X", URL_FIRST ));
        
    }
    
    
    public static String sendPostToGov(String name, String IDcode ,String URL) throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        GetMethod getMethod  = null;
        try{
          getMethod = new GetMethod("http://iir.circ.gov.cn/ipq/captchacn.svl?time=123");
        }catch(Exception e){
            return "Get_Pic_Connection_Fail";
        }
        System.err.println("--------------开始获取图片验证码-------------");
        int statusCode = httpClient.executeMethod(getMethod);
        if (statusCode != HttpStatus.SC_OK) {
            System.err.println("获取图片验证码失败！请检查保监会验证码接口.");
            System.err.println("Method failed: " + getMethod.getStatusLine());
            return "Get_Pic_Connection_Fail";
        }
        getMethod.getResponseHeader("Cookie");
        /*
         * InputStream fin = getMethod.getResponseBodyAsStream(); byte[] bytes =
         * new byte[fin.available()]; //将文件内容写入字节数组，提供测试的case fin.read(bytes);
         * fin.close();
         * 
         * //调用百度图片识别api
         */
//        JSONObject apiRes = new JSONObject(BaiduPostApi.getAPI(getMethod.getResponseBody()));
//        JSONArray resJSONArray = (JSONArray) apiRes.get("words_result");
        
        String resPicCode = BaiduPostApi.getCodeFromPic(getMethod.getResponseBody());
        System.out.println("baidu识图返回报文,返回内容为: " + resPicCode);
        if ("Get_Pic_Response_Fail".equals(resPicCode) || "Get_Pic_Response_Fail" == resPicCode) {
            // 百度识图返回报文解析错误。
            System.out.println("baidu识图返回报文解读失败,返回内容为: " + resPicCode);
            return "Get_Pic_Response_Fail";
        }

        // 资质校验：post请求
        PostMethod postMethod = new PostMethod(URL);
        NameValuePair[] pairs = new NameValuePair[5];
        // 身份证后四位
//      pairs[0] = new NameValuePair("id_card", IDcode.substring(14, IDcode.length()));
        pairs[0] = new NameValuePair("cardno", IDcode.substring(14, IDcode.length()));
        // 资格证书号码
//      pairs[1] = new NameValuePair("certificate_code", "");
        pairs[1] = new NameValuePair("ualificano", "");
        // 执业证编号
//      pairs[2] = new NameValuePair("evelop_code", "");
        pairs[2] = new NameValuePair("practicecode", "");
        // 姓名
        pairs[3] = new NameValuePair("name", name);
        // 验证码
//      pairs[4] = new NameValuePair("valCode", (String) resJSONArray.getJSONObject(0).get("words"));
        pairs[4] = new NameValuePair("captcha", resPicCode.replaceAll(" ", ""));
        

        postMethod.setRequestBody(pairs);
        System.out.println("发送资质校验请求！ 请求信息：name = " + name + " id_card = " + IDcode);
        int statusCode1 = httpClient.executeMethod(postMethod);
        String strResp = "";
        if (statusCode1 != HttpStatus.SC_OK) {
            // 读取内容
            byte[] responseBody = postMethod.getResponseBody();
            // 处理内容
            strResp = new String(responseBody, "utf-8");
             System.out.println("资质校验失败，返回报文为：" + strResp);
            System.out.println("资质校验获取失败信息");
            return "Get_Validate_Response_Fail";
        } else {
            // 读取内容
            byte[] responseBody = postMethod.getResponseBody();
//            strResp = new String(responseBody, "GBK");
            strResp = new String(responseBody, "UTF-8");
            if (!strResp.contains("<title>保险中介监管信息系统</title>")) {
                strResp = new String(responseBody, "utf-8");
            }
            System.out.println("资质校验返回报文获取成功");
            System.out.println(strResp);
            return strResp;
        }
    }
    
    
}
