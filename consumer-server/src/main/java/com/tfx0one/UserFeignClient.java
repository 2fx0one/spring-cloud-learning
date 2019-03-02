package com.tfx0one;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @Auth 2fx0one
 * 2019/3/3 00:46
 */
@FeignClient("user-server")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User getById(@PathVariable String id) ;

}
