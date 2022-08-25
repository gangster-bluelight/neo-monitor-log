package com.neo.monitor.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.neo.monitor.core.SensitiveInfoSerialize;
import com.neo.monitor.strategy.DefaultSensitiveStrategy;
import com.neo.monitor.strategy.IStrategy;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description: 脱敏信息
 * - 注解@JsonSerialize:是给自定义的注解配置序列化工具的信息，using就是设置注解使用的序列化工具。
 * * 利用@JsonSerialize注解，可以方便地实现将date数据转换成String型数据等功能，该注解作用在属性的getter()方法上。
 * <p>
 * * - @JsonSerialize注解：主要用于数据转换,该注解作用在该属性的getter()方法上
 * * - @JsonInclude注解：返回前端的实体类中如果某个字段为空的话那么就不返回这个字段,所以将@JsonInclude(Include.NON_NULL)注解放在类头上就可以解决。
 * * 实体类与json互转的时候属性值为 null的不参与序列化.
 * * JsonJsonInclude.Include.ALWAYS这个是默认策略，任何情况下都序列化该字段，和不写这个注解是一样的效果。
 * - 注解@Inherited的作用是：使用此注解声明出来的自定义注解，在使用此自定义注解时，如果注解在类上面时，子类会自动继承此注解，否则的话，子类不会继承此注解。
 * 【这里一定要记住，使用Inherited声明出来的注解，只有在类上使用时才会有效，对方法，属性等其他无效。】
 * - @JacksonAnnotationsInside 注解的作用是将多个注解组合到一起
 */
@Inherited
@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = SensitiveInfoSerialize.class)
public @interface SensitiveInfo {
    /**
     * 脱敏策略
     *
     * @return clazz
     */
    Class<? extends IStrategy> strategy() default DefaultSensitiveStrategy.class;

    /**
     * 输入格式，使用正则表达式, 优先级大于value
     *
     * @return 格式
     */
    String pattern() default "";

    /**
     * 替换目标字符, 优先级大于value
     *
     * @return 替换目标字符串
     */
    String replaceChar() default "";

    /**
     * 开始显示几位
     *
     * @return int
     */
    int begin() default 0;

    /**
     * 结束显示几位
     *
     * @return int
     */
    int end() default 0;
}
