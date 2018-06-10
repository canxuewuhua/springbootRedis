package com.boot.controller;

import com.boot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZHUYONGQIANG on 2018/6/8.
 */
@Controller
@RequestMapping(value = {"/redis"})
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/checkKey")
    @ResponseBody
    public String getRedisCacheValue() {
        return redisService.getRedisValue();
    }

    @RequestMapping(value = "/setKey")
    @ResponseBody
    public String setRedisValue() {
        return redisService.setRedisValue();
    }

    @RequestMapping(value = "/refreshKey")
    @ResponseBody
    public String refreshRedisValue() {
        return redisService.refreshRedisValue();
    }
}
