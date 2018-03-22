package com.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.model.TestModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;

/**
 * @author sims
 * @date 2018/3/8 15:04
 *
 *
 **/
//@RequestMapping(value = "/hello")
@Controller
//@RequestMapping(value = "hello")
public class HelloController {
    //    private static Logger logger = Logger.getLogger(HelloController.class);
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(@RequestParam LinkedHashMap linkedHashMap ) {
        //@RequestParam LinkedHashMap model
//@RequestParam String modelStr,
//        HashMap modelObj = JSON.parseObject(modelStr, HashMap.class);
        ModelMap model = new ModelMap();
        model.addAttribute("msg", "Spring MVC Hello World:" + linkedHashMap.get("name"));
        model.addAttribute("name", "Hello world!" + linkedHashMap.get("count"));
//        return new ModelAndView("redirect:hello", model);
        String ret = null;
        try {
            ret = new ObjectMapper().writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ret;
    }
    @PostMapping(value = "test1",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView test(@RequestBody TestModel testModel)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("model");
        view.addObject("testModel", testModel);
        return view;

    }
}



