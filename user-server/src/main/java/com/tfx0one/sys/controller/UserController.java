package com.tfx0one.sys.controller;


import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.tfx0one.common.base.BaseController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 2fx0one
 * @since 2019-02-28
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User hello(@PathVariable String id) {
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getById(id);
    }
}
