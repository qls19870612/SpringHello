package com.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.model.TestModel;
import com.hello.services.HttpService;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class HelloControllerTest extends TestCase{

   @Autowired(required = true)
    private HttpService httpService;
    private static Logger logger = Logger.getLogger(HelloControllerTest.class);
@Override
protected void setUp() throws Exception {
//    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath*:../web/WEB-INF/applicationContext.xml");
//    httpService = (HttpService)ac.getBean("httpService");
//    System.out.println(httpService==null);

}
@Override
protected  void tearDown()
{

}
    @Test
    public void testModelAndView()
    {
        TestModel testModel = new TestModel();
        testModel.setName("test11111111");
        testModel.setCount(123);

        String modelStr = null;
        try {
            modelStr = new ObjectMapper().writeValueAsString(testModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        String responseBody = httpService.httpRequest("http://192.168.10.101:8080/test1", modelStr, HttpMethod.POST);
        logger.info("--------------------------\n" + responseBody);
    }
}