package com.neo.monitor.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 身份证号脱敏
 * @author blue-light
 * Date: 2022-08-17
 */
@Documented
@JacksonAnnotationsInside
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveIdCard.class,pattern = "(?<=\\w{0})\\w(?=\\w{4})",replaceChar = "*")
public @interface SensitiveIdCard {

}
