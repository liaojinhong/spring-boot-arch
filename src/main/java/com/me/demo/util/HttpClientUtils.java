package com.me.demo.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;

/**
 * 类功能说明：httpclient工具类,基于httpclient 4.x
 * 
 * @author ljh
 *
 */
public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * post请求
     * @param url
     * @return
     */
    public static String doPost(String url) {
        try {
            return RestClient.getClient().postForObject(url, HttpEntity.EMPTY, String.class);
        } catch (Exception e) {
            LOGGER.error("POST请求出错：{}", url, e);
        }

        return null;
    }

    /**
     * get请求
     * @param url
     * @return
     */
    public static String doGet(String url) {
        try {
            return RestClient.getClient().getForObject(url, String.class);
        } catch (Exception e) {
            LOGGER.error("GET请求出错：{}", url, e);
        }

        return null;
    }

}