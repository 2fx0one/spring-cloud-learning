package com.tfx0one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Auth 2fx0one
 * 2019/2/28 21:32
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping
public class ConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    @Resource
    private RestTemplate restTemplate;

//    @Resource
//    private DiscoveryClient discoveryClient;

    @GetMapping("/hello/{id}")
    @ResponseBody
    public String hello(@PathVariable String id) {
        System.out.println(id);
//        User u = restTemplate.getForObject("http://127.0.0.1:10001/sys/user/1", User.class);
//        1、从注册中心获取实例
//        List<ServiceInstance> list = discoveryClient.getInstances("user-server");
//        ServiceInstance instance = list.get(0);
//        System.out.println(instance);
//        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/sys/user/1";
//        2。 开启 Robbin负载均衡 loadBalanced
        String baseUrl = "http://user-server" + "/sys/user/1";
        System.out.println(baseUrl);
        User u = restTemplate.getForObject(baseUrl, User.class);
        System.out.println(u);
        return u.getName();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
