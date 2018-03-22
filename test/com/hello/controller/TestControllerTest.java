package com.hello.controller;

import com.hello.services.HttpService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})//../web/WEB-INF/
//, "classpath*:dispatcher-servlet.xml"
public class TestControllerTest {
    @Autowired
    private HttpService httpService;

    private static Logger logger = Logger.getLogger(TestControllerTest.class);
    @Test
    public void testModelAndView() throws Exception {
        String ret = httpService.httpRequest("http://192.168.10.101:8080/test", "{}", HttpMethod.GET);
        logger.info(ret);
    
    }

}