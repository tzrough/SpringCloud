package com.tzrough.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${vistor}")
    String vistor;

    @RequestMapping(value = "hello")
    public String hello()
    {
        return "hello, " + vistor;
    }
}
