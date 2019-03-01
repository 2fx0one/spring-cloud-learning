package com.tfx0one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * @Auth 2fx0one
 * 2019/2/28 20:33
 */
@EnableDiscoveryClient
@SpringBootApplication
public class    UserServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
