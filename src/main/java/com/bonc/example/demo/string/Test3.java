package com.bonc.example.demo.string;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author luoaojin
 * @Date 2020/8/18 15:22
 * @Description
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
//        List<String> a = new ArrayList<>();
//        a.add("111");
//        a.add("12");
//        a.add("13");
//        a.add("14,234");
//        System.out.println(String.join(",", a));
//        System.out.println("SIMPLE".trim().toUpperCase());
//        __getServerUrl(request, casServerLoginUrl, serviceUrl);

    }
    private static String __getServerUrl(HttpServletRequest request, String casUrl, String serviceUrl) {
        if (null != serviceUrl && !"".equals(serviceUrl)) {
            if (!serviceUrl.startsWith("http")) {
                if (!serviceUrl.startsWith("/")) {
                    serviceUrl = "/" + serviceUrl;
                }

                serviceUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + serviceUrl;
            }

            return casUrl.indexOf(63) != -1 ? casUrl + "&service=" + encodeURL(serviceUrl) : casUrl + "?service=" + encodeURL(serviceUrl);
        } else {
            return casUrl;
        }
    }
    private static String encodeURL(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException var4) {
            try {
                return URLEncoder.encode(value, "GBK");
            } catch (UnsupportedEncodingException var3) {
                throw new RuntimeException(var4);
            }
        }
    }

}
