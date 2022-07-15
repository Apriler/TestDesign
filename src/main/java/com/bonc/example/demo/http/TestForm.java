package com.bonc.example.demo.http;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author luoaojin
 * @Date 2022/7/15 10:30
 * @Description
 * @Version 1.0
 */
public class TestForm {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("userid","11233");
        headers.put("sign","1BE5413EE3894EE4E2EAF5BE7F47DA94");
//        postFormUrlEncoded("http://cz.zt10010.com/yrapi.php/index/typecate",headers,"aaa");
        postWithParamsForString("http://cz.zt10010.com/yrapi.php/index/typecate","aaa","aaa");
    }
    public  static  String postFormUrlEncoded(String path, HashMap<String, String> headers, String requestBody) {
        String result = " ";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Connection", "Keep-Alive");
            // 不使用缓存
            connection.setUseCaches(false);
            if (headers != null) {
                if (headers.size() > 0) {
                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        connection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
            }
            connection.connect();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8));
            out.print(requestBody);
            out.flush();

            int resultCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                StringBuffer stringBuffer = new StringBuffer();
                String readLine;
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                while ((readLine = responseReader.readLine()) != null) {
                    stringBuffer.append(readLine).append("\n");
                }
                responseReader.close();
                result = stringBuffer.toString();
            } else {
                result = "{\"code\":\"" + resultCode + "\"}";
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"code\":500,\"result\":\"x-www-form-urlencoded请求 " + path + " 时出现异常\"}";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    public static String postWithParamsForString(String url, String param1,String param2) throws ClientProtocolException, IOException {
        String jsonStr = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String requestBody = createRequestBody(param1, param2);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        StringEntity entity = new StringEntity(requestBody);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        jsonStr = EntityUtils.toString(response.getEntity());
        return jsonStr;
    }
    private static String createRequestBody(String param1, String param2) {
//        return MessageFormat.format("userid=11233&sign=1BE5413EE3894EE4E2EAF5BE7F47DA94");
        return "userid=11233&sign=1BE5413EE3894EE4E2EAF5BE7F47DA94";
    }



}
