package com.neo.monitor.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 邮箱脱敏
 *
 * @author blue-light
 * Date: 2022-08-17
 */
@Documented
@JacksonAnnotationsInside
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveEmail.class, pattern = "(\\w+)\\w{3}@(\\w+)", replaceChar = "$1***@$2")
public @interface SensitiveEmail {

}
