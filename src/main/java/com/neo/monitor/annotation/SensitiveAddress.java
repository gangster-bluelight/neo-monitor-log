package com.neo.monitor.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 地址脱敏
 *
 * @author blue-light
 * Date: 2022-08-17
 */
@Documented
@JacksonAnnotationsInside
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveAddress.class, pattern = "(.{5}).+(.{4})", replaceChar = "$1*****$2")
public @interface SensitiveAddress {

}
