package com.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.model.TestModel;
import com.hello.services.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.portlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sims
 * @date 2018/3/8 15:51
 **/
@Controller
public class TestController {
    @Autowired
    private HttpService httpService;

    @RequestMapping("test")
    public ModelAndView testModelAndView( ModelMap model)
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
//        ModelMap model  = new ModelMap();
        model.addAttribute("test1", responseBody);
        model.addAttribute("msg","****111");
        ModelAndView modelView = new ModelAndView("test",model);
//        modelView.addObject("test1", "234");
//        modelView.addObject("msg","****111");
        return modelView;
    }
}
