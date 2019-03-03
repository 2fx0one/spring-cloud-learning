package com.tfx0one;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 * @Auth 2fx0one
 * 2019/3/2 23:16
 */
@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")
public class UserController {


    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/hello/{id}")
//    @HystrixCommand(fallbackMethod = "fallbackHello")
//    @HystrixCommand(fallbackMethod = "fallbackHello",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//            })
    public String hello(@PathVariable String id) {
//        User u = restTemplate.getForObject("http://127.0.0.1:10001/sys/user/1", User.class);
//        1、从注册中心获取实例
//        List<ServiceInstance> list = discoveryClient.getInstances("user-server");
//        ServiceInstance instance = list.get(0);
//        System.out.println(instance);
//        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/sys/user/1";
//        2。 开启 Robbin负载均衡 loadBalanced
        long begin = System.currentTimeMillis();
//        String baseUrl = "http://user-server" + "/sys/user/" + id;
//        System.out.println(baseUrl);
//        User u = restTemplate.getForObject(baseUrl, User.class);
        User u = userFeignClient.getById("1");
        long end = System.currentTimeMillis();
        System.out.println("访问用时：" + (end - begin));

        return u.getName();
    }

    public String fallbackHello(String id) {
        return "网络拥挤！";
    }

    public String defaultFallback() {
        return "defalut 网络拥挤！";
    }
}
