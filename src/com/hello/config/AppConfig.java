package com.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sims
 * @date 2018/3/19 10:37
 **/
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate rest = new RestTemplate();
        return rest;
    }
}
