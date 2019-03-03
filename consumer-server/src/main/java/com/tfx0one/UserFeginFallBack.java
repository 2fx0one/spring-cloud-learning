package com.tfx0one;

import org.springframework.stereotype.Component;

/*
 * @Auth 2fx0one
 * 2019/3/3 10:35
 */
@Component
public class UserFeginFallBack implements UserFeignClient {
    @Override
    public User getById(String id) {
        User u = new User();
        u.setName("unknown");
        return u;
    }
}
