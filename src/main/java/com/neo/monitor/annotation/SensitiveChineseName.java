package com.neo.monitor.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 中文姓名脱敏
 * @author blue-light
 * Date: 2022-08-17
 */
@Documented
@JacksonAnnotationsInside
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveChineseName.class, pattern = "(?<=.{1}).",replaceChar = "*")
public @interface SensitiveChineseName {


}
