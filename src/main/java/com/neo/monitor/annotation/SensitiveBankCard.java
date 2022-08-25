package com.neo.monitor.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 银行卡号脱敏
 *
 * @author blue-light
 * Date: 2022-08-17
 * 注解JacksonAnnotationsInside说明：
 * - 官方:引用文本 元注释（在其他注释上使用的注释）用于指示Jackson应该使用它拥有的元注释，而不是使用目标注释（使用此注释注释的注释）。这在创建“组合注释”时非常有用，因为它有一个容器注释，这个容器注释需要用这个注释以及它“包含”的所有注释进行注释。
 * - 通俗理解:自定义的注解加上这个注解，自定义的注解就会被Jackson的注解拦截器（JacksonAnnotationIntrospector）findSerializer发现拦截并处理
 */
@Documented
@JacksonAnnotationsInside
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveChineseName.class, pattern = "(?<=\\w{4})\\w(?=\\w{4})", replaceChar = "*")
public @interface SensitiveBankCard {

}
