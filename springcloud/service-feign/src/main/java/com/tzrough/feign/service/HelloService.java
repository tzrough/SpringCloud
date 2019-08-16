package com.tzrough.feign.service;

import com.tzrough.feign.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hello", fallback = HelloServiceHystrix.class)
public interface HelloService
{
    /**
     * FeignClien 方法入参前必须使用 @RequestParam 注解, 否则会报错
     * 使用 RestTemplate 方法拼接URL参数, 方法入参不需要加 @RequestParam 注解
     **/
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello(@RequestParam String name);

}
