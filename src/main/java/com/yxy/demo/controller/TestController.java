package com.yxy.demo.controller;

import com.alibaba.fastjson.JSON;
import com.yxy.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/http")
public class TestController {
    @RequestMapping(value = "/info")
    public String info(HttpServletRequest request) {
        return request.getProtocol();
    }

    @RequestMapping(value = "/person")
    public String person(@RequestBody Person person) {
        System.out.println("person->" + JSON.toJSONString(person));
        return "ok";
    }

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request) {
        try {
            int i = 1 / 0 ;
        }catch (Exception e){
            log.info("错误{}",e.getMessage(),e);
        }
        return "123";
    }

}
