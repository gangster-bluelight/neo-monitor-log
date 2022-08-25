package com.neo.monitor.lang;

import lombok.Getter;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description:
 * - 点号（.）：匹配除换行符 \n 之外的任何单字符
 */
public enum SensitiveStrategyEnum {
    /**
     *中文姓名
     */
    CHINESE_NAME("(?<=.{1}).","*"),

    /**
     * 密码
     */
    PASSWORD("(?<=.)","*"),

    /**
     * 身份证号
     */
    ID_CARD_NUM("(?<=\\w{0})\\w(?=\\w{4})","*"),

    /**
     * 固定电话
     */
    FIXED_PHONE("(?<=\\w{0})\\w(?=\\w{4})","*"),

    /**
     * 电话
     */
    MOBILE("(?<=\\w{3})\\w(?=\\w{4})","*"),

    /**
     * 地址
     */
    ADDRESS("(.{5}).+(.{4})","$1*****$2"),
    /**
     * 邮箱
     */
    EMAIL("(\\w+)\\w{3}@(\\w+)","$1***@$2"),

    /**
     * 银行卡号
     */
    BANKCARD("(?<=\\w{4})\\w(?=\\w{4})","*"),

    /**
     * 默认策略
     */
    DEFAULT_STRATEGY("","")
    ;

    SensitiveStrategyEnum(String pattern, String replaceChar){
        this.pattern = pattern;
        this.replaceChar = replaceChar;
    }

    /**
     * 正则-输入格式(1,2,2)
     */
    @Getter
    private final String pattern;

    /**
     * 替换后的字符
     */
    @Getter
    private final String replaceChar;
}
