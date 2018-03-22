package com.hello.services;


import org.springframework.http.HttpMethod;

import java.util.Map;

/**
 *
 * @author admin
 * @date 2017/6/6
 */
public interface HttpService {

    public String doRequest(String url, Map<String, String> map, HttpMethod httpMethod);

    public String doRequest(String url, String json, HttpMethod httpMethod) throws Exception;

    public String postFormRequest(String url, Map<String, String> map);

    String httpRequest(String url, Map<String, String> map, HttpMethod httpMethod);

    String httpRequest(String url, String json, HttpMethod httpMethod);
}
