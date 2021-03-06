package com.boot.service.impl;

import com.boot.common.RedisConstant;
import com.boot.service.RedisService;
import com.boot.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ZHUYONGQIANG on 2018/6/8.
 */
@Service
public class RedisServiceImpl implements RedisService{
    private Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public String getRedisValue() {
        String redisKey = RedisConstant.FLAG_VALUE;
        Object abutmentMerObj =  redisUtils.get(redisKey);
        if (abutmentMerObj != null) {
            return "从缓存中查询到了key："+redisKey+"的值："+abutmentMerObj.toString();
        }else{
            return "从缓存中没有查到该key";
        }
    }

    @Override
    public String setRedisValue() {
        String redisKey = RedisConstant.FLAG_VALUE;
        //设置缓存的key、value以及失效时间，失效一个小时，HOUR_TIME为小时，TIME_UNIT单位为秒
        boolean booLock = redisUtils.setNX(redisKey,"2018-07-11日志",RedisConstant.HOUR_TIME, RedisConstant.TIME_UNIT);
        return "插入redis服务器成功";
    }

    @Override
    public String refreshRedisValue() {
        String redisKey = RedisConstant.FLAG_VALUE;
        redisUtils.del(redisKey);
        return "清除缓存";
    }
}
