package com.boot.common;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/15.
 */
public interface RedisConstant {

    /**
     * 商户号自增key
     */
    String MERCHANT_INCR_KEY = "merchant:incr";

    String MY_REDIS_NAME="core:proxy:abutment:merchant:0000000001:ac11f50c15c2429aac0b7f3912b2f911";
    String MY_HOPE="nameredis";
    String FLAG_VALUE="20180626-redisValue";

    /**
     * 设置过期时间一天，与TIME_UNIT配合
     * 60*60*24
     */
    Long DAY_TIME = 86400L;

    /**
     * 设置过期时间一小时，与TIME_UNIT配合
     * 60*60
     */
    Long HOUR_TIME = 3600L;

    /**
     * 过期时间单位，与TIME配合
     */
    TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    /**
     * access_key 前缀
     */
    String AK_PREFX = "ak_";

    /**
     * 商户号前缀
     */
    String MERCHANT_PREFX = "mer_";

    /**
     * 权限前缀
     */
    String PERMISSION_PREFX = "permission_";

    /**
     * 第三方加密key前缀
     */
    String THIRD_ENCRYPT_KEY_PREFX = "tek_";

    /**
     * 第三方配置前缀
     */
    String THIRD_PROPERTY_PREFX = "tp_";

    /**
     * 方法名称前缀
     */
    String METHOD_NAME_PREFX = "methodname_";

}
