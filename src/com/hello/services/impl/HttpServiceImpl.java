package com.hello.services.impl;

import com.hello.config.AppConfig;
import com.hello.services.HttpService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 *
 * @author admin
 * @date 2017/6/6
 */

@SuppressWarnings("ALL")
@Service
public class HttpServiceImpl implements HttpService {
    private static Logger log = Logger.getLogger(HttpServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
    public String doRequest(String url, Map<String, String> map,HttpMethod httpMethod) {
        RequestEntity<String> requestEntity = enrichRequestEntity(url,map,httpMethod);
        ResponseEntity<String> responseEntity = doRequest(requestEntity);
        return responseEntity.getBody();
    }
    public String doRequest(String url, String json,HttpMethod httpMethod) throws Exception {
        RequestEntity<String> requestEntity = enrichRequestEntity(url,json,httpMethod);
        ResponseEntity<String> responseEntity = doRequest(requestEntity);
        return responseEntity.getBody();
    }

    public String postFormRequest(String url, Map<String, String> map) {
        MultiValueMap headers = new LinkedMultiValueMap();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        HttpEntity requestEntity = new HttpEntity(toMultiValueMap(map), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,requestEntity,String.class);
        String responseBody = responseEntity.getBody();
        return responseBody;
    }

    public ResponseEntity<String> doRequest(RequestEntity<String> requestEntity) {
        log.info("do request:" + requestEntity.toString());

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        log.info("response body:" + responseEntity.getBody());
        return responseEntity;
    }

    public RequestEntity enrichRequestEntity(String url, Map<String, String> map, HttpMethod httpMethod) {
        StringBuffer sb = new StringBuffer("");
        for (String key:map.keySet()) {
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        String query = sb.substring(0,sb.length()-1);
        URI uri = UriComponentsBuilder.fromHttpUrl(url).query(query).build().encode().toUri();

        return new RequestEntity(httpMethod,uri);

    }
    public RequestEntity enrichRequestEntity(String url, String json, HttpMethod httpMethod) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().encode().toUri();
        MultiValueMap headers = new LinkedMultiValueMap();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
        return new RequestEntity<String>(json,headers,httpMethod,uri);

    }
    public RequestEntity enrichRequestEntity(String url, String json, HttpMethod httpMethod, MultiValueMap headers) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().encode().toUri();
        return new RequestEntity<String>(json,headers,httpMethod,uri);

    }

    private MultiValueMap toMultiValueMap(Map<String, String> map) {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        for (String key : map.keySet()) {
            multiValueMap.add(key, map.get(key));
        }
        return multiValueMap;
    }
    public String httpRequest(String url, Map<String, String> map, HttpMethod httpMethod) {
        MultiValueMap headers = new LinkedMultiValueMap();

        headers.set("Accept", "application/json");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        ResponseEntity<String> responseEntity = null;
        String responseBody = null;
        log.info("request url:" + url);
        if(httpMethod.ordinal() == HttpMethod.GET.ordinal()) {
            RequestEntity requestEntity = enrichRequestEntity(url, map, HttpMethod.GET,headers);
            log.info("do request:" +  requestEntity.toString());
            responseEntity = doRequest(requestEntity);
        }else{
            HttpEntity requestEntity = new HttpEntity(toMultiValueMap(map), headers);
            log.info("do request:{}" + requestEntity);
            responseEntity = restTemplate.postForEntity(url,requestEntity,String.class);
        }
        responseBody = responseEntity.getBody();
        log.info("response Body: " + responseBody);
        return responseBody;
    }
    public String httpRequest(String url, String json, HttpMethod httpMethod) {
        MultiValueMap headers = new LinkedMultiValueMap();
        headers.set("Accept", "application/json");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE.toString());
        ResponseEntity<String> responseEntity = null;
        String responseBody = null;
        log.info("request url:" + url);
        if(httpMethod.ordinal() == HttpMethod.GET.ordinal()) {
            RequestEntity requestEntity = enrichRequestEntity(url, json, HttpMethod.GET,headers);
            log.info("do request:{}"+ requestEntity);
            responseEntity = doRequest(requestEntity);
        }else{
            HttpEntity requestEntity = new HttpEntity(json, headers);
            log.info("do request:{}"+ requestEntity);
            responseEntity = restTemplate.postForEntity(url,requestEntity,String.class);
        }
        responseBody = responseEntity.getBody();
        log.info("response Body: " + responseBody);
        return responseBody;
    }

    public RequestEntity enrichRequestEntity(String url, Map<String, String> map, HttpMethod httpMethod, MultiValueMap headers) {
        StringBuffer sb = new StringBuffer("");
        for (String key : map.keySet()) {
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        String query = sb.substring(0, sb.length() - 1);
        URI uri = UriComponentsBuilder.fromHttpUrl(url).query(query).build().encode().toUri();

        return new RequestEntity(headers, httpMethod, uri);

    }

}
