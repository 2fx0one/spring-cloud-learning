package com.tfx0one;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @Auth 2fx0one
 * 2019/2/28 21:32
 */
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication

@EnableFeignClients
@SpringCloudApplication
public class ConsumerApplication {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() { //feign 已经集成
//        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
