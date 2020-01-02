package com.ziroom.study.spring.controller;

import com.ziroom.study.spring.pojo.dto.req.DemoParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学习spring mvc源码
 *
 * @author huangqiaowei
 * @date 2020-01-01 18:16
 **/
@RestController
@Slf4j
@RequestMapping("demo")
public class StudyMvcController {

    @PostMapping("/demo1")
    public String demo1() {
        return "hello world";
    }

    @PostMapping("/demo2")
    public String demo2(String key) {
        return "hello world";
    }

    @PostMapping("/demo3")
    public String demo3(DemoParams demoParams){
        return "hello world";
    }


}
