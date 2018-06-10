package com.boot.service;

/**
 * Created by ZHUYONGQIANG on 2018/6/8.
 */
public interface RedisService {
    String getRedisValue();
    String setRedisValue();
    String refreshRedisValue();
}
