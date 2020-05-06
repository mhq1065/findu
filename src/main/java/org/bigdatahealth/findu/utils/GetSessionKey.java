package org.bigdatahealth.findu.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetSessionKey {

    public static JSONObject getSessionKeyOrOpenId(String code) throws IOException {
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String> requestUrlParam = new HashMap<String, String>(  );
        requestUrlParam.put( "appid","wxa7781ee77ff96c6b" );//小程序appId
        requestUrlParam.put( "secret","855ef3dbbe080e5044c08ecc965b4dd7" );
        requestUrlParam.put( "js_code",wxCode );//小程序端返回的code
        requestUrlParam.put( "grant_type","authorization_code" );//默认参数
        //发送post请求读取调用微信接口获取openid用户唯一标识
        String s = postHttp(requestUrl, requestUrlParam);
        JSONObject jsonObject = JSON.parseObject(s);
        return jsonObject;
    }
    public static String postHttp(String url, Map<String, String> propsMap) {
        String responseMsg = "";

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);// POST请求
        // 参数设置
        Set<String> keySet = propsMap.keySet();
        NameValuePair[] postData = new NameValuePair[keySet.size()];
        int index = 0;
        for (String key : keySet) {
            postData[index++] = new NameValuePair(key, propsMap.get(key).toString());
        }
        postMethod.addParameters(postData);
        try {
            httpClient.executeMethod(postMethod);// 发送请求
            // 读取内容
            byte[] responseBody = postMethod.getResponseBody();
            // 处理返回的内容
            responseMsg = new String(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            postMethod.releaseConnection();// 关闭连接
        }
        return responseMsg;
    }

}
