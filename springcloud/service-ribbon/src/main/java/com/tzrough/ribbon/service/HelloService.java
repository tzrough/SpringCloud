package com.tzrough.ribbon.service;

import brave.sampler.Sampler;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService
{
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "sayHelloError")
    public String sayHello(String name)
    {

        return restTemplate.getForObject("http://service-hello/hello?name=" + name, String.class);
    }

    public String sayHelloError(String name)
    {
        return "sorry " + name + ", error occured";
    }

}
