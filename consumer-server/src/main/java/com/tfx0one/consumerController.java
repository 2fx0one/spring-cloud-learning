package com.tfx0one;

/*
 * @Auth 2fx0one
 * 2019/2/28 21:41
 */

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class consumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello() {
        List<ServiceInstance> list = discoveryClient.getInstances("user-server");
//        User u = restTemplate.getForObject("http://127.0.0.1:10001/sys/user/1", User.class);
        ServiceInstance instance = list.get(0);
        System.out.println(instance);
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/sys/user/1";
        System.out.println(baseUrl);
        User u = restTemplate.getForObject(baseUrl, User.class);
        System.out.println(u);
        return u.getName();
    }
}
