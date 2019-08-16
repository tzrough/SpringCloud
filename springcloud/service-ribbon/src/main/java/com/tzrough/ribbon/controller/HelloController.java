package com.tzrough.ribbon.controller;

import brave.sampler.Sampler;
import com.tzrough.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    @Autowired
    HelloService helloService;


    /**
     *
     * 设置参数默认值后，url 中不需要添加 name 参数
     *
     **/
    @GetMapping(value = "/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "vistor") String name)
    {
        return helloService.sayHello(name);
    }

}
