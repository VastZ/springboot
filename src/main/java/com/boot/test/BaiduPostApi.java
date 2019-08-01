package com.boot.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class BaiduPostApi{

	/**
	 * 调用百度API识别二维码数字， 返回数字。 成功率约70%
	 * 
	 * @param fileStream
	 * @return
	 * @throws JSONException 
	 */
	
	public static String getAPI(byte[] fileStream) throws JSONException {
		// 初始化一个AipOcr
		/*String APP_ID = "11540605";
		String API_KEY = "mzfCMYE6jfwDGUbaYYnjKIRu";
		String SECRET_KEY = "IIuip0dsPDO5h5YcgVORRwBAIqebAIHG";*/
/*
		String APP_ID = "11555830";
		String API_KEY = "WZjZdx6k4kDupMlOFNgoNzHV";
		String SECRET_KEY = "5OBbMnZNq8EcfIRG8kcdTVWhOeGxYWCU";
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);*/
		// 可选：设置网络连接参数
		AipOcr client = SingletenBaiduAPI.getInstance();
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		System.out.println("调用百度图片识别API.");
		// 调用接口 传入图片流
		JSONObject res = client.basicGeneral(fileStream, new HashMap<String, String>());
		return res.toString(2);

	}

	/**
	 * 传入图片位置， 返回图片流
	 * 
	 * @param imgSrc
	 * @return
	 * @throws Exception
	 */
	public static byte[] image2Bytes(String imgSrc) throws Exception {
		FileInputStream fin = new FileInputStream(new File(imgSrc));
		// 可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
		byte[] bytes = new byte[fin.available()];
		// 将文件内容写入字节数组，提供测试的case
		fin.read(bytes);

		fin.close();
		return bytes;
	}

	/**
	 * 获取百度返回报文的结果
	 * 
	 * @param fileStream
	 * @return
	 */
	public static String getCodeFromPic(byte[] fileStream) {
		try {
			JSONObject apiRes = new JSONObject(getAPI(fileStream));
			JSONArray resJSONArray = (JSONArray) apiRes.get("words_result");
			return (String) resJSONArray.getJSONObject(0).get("words");
		} catch (Exception e) {
			return "Get_Pic_Response_Fail";
		}
	}

	/**
	 * 获取身份证性别信息
	 */
	public static String getCardSexInfo(String idCode){
		String sex;
		if (Integer.parseInt(idCode.substring(16).substring(0, 1)) % 2 != 0) {// 判断性别
			sex = "F";
		} else {
			sex = "M";
		}
		return sex;
	}

}
