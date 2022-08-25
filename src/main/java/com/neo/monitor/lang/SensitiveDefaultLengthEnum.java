package com.neo.monitor.lang;

import lombok.Getter;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description:
 */
public enum SensitiveDefaultLengthEnum {
    /**
     * 默认长度
     */
    DEFAULT(0,0),

    /**
     *中文姓名
     */
    CHINESE_NAME(1,0),

    /**
     * 密码
     */
    PASSWORD(6,0),

    /**
     * 身份证号
     */
    ID_CARD_NUM(0,4),

    /**
     * 固定电话
     */
    FIXED_PHONE(0,4),

    /**
     * 电话
     */
    MOBILE(3,4),

    /**
     * 地址
     */
    ADDRESS(6,0),
    /**
     * 邮箱
     */
    EMAIL(1,0),

    /**
     * 银行卡号
     */
    BANKCARD(6,4),

    /**
     * 默认策略
     */
    DEFAULT_STRATEGY(6,0),
    ;

    SensitiveDefaultLengthEnum(int begin, int end){
        this.begin = begin;
        this.end = end;
    };
    /**
     * 开始长度
     */
    @Getter
    private final int begin;

    /**
     * 结束长度
     */
    @Getter
    private final int end;
}
