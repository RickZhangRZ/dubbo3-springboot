package com.xiaozhang.Impl;


import com.xiaozhang.entiy.User;
import com.xiaozhang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;

@DubboService
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     *
     * @param userId
     * @return
     * RPC provider 接口 实现
     */
    @Override
    public User getUserInfo(long userId) {

        log.info("request from consumer: {}", RpcContext.getContext().getRemoteAddress());
        log.info("response from provider: {}" , RpcContext.getContext().getLocalAddress());
        return new User(userId, "userName" + userId , " --->>>>response from remote RPC provider:" + RpcContext.getContext().getLocalAddress());
    }
}



