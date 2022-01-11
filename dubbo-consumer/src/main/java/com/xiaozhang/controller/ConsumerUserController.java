package com.xiaozhang.controller;

import com.xiaozhang.entiy.User;
import com.xiaozhang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerUserController {

    @DubboReference
    private UserService userService;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User user = userService.getUserInfo(id);
        log.info("response from provider: {}", user);
        return user;
    }
}
