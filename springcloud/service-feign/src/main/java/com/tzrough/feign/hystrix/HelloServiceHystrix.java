package com.tzrough.feign.hystrix;

import com.tzrough.feign.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/** 实现 HelloService 接口 **/
@Component
public class HelloServiceHystrix implements HelloService
{
    @Override
    public String sayHello(@RequestParam String name)
    {
        return "sorry " + name + ", error occured";
    }


}
