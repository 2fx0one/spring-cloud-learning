package com.tfx0one;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/*
 * @Auth 2fx0one
 * 2019/3/2 23:16
 */
@RestController
public class UserController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{id}")
//    @HystrixCommand(fallbackMethod = "fallbackHello",
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String hello(@PathVariable String id) {
//        User u = restTemplate.getForObject("http://127.0.0.1:10001/sys/user/1", User.class);
//        1、从注册中心获取实例
//        List<ServiceInstance> list = discoveryClient.getInstances("user-server");
//        ServiceInstance instance = list.get(0);
//        System.out.println(instance);
//        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/sys/user/1";
//        2。 开启 Robbin负载均衡 loadBalanced
        String baseUrl = "http://user-server" + "/sys/user/" + id;
        System.out.println(baseUrl);
        User u = restTemplate.getForObject(baseUrl, User.class);
        System.out.println(u);
        return u.getName();
    }

    public String fallbackHello(String id) {
        return "网络拥挤！";
    }
}
