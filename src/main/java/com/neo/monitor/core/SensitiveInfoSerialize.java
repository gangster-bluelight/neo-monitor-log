package com.neo.monitor.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.neo.monitor.annotation.SensitiveInfo;
import com.neo.monitor.strategy.IStrategy;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * 序列化实现类
 *
 * @author blue-light
 * Date: 2022-08-17
 * <p>
 * JsonSerializer抽象类：【泛型中指定的类型是需要被转换的数据类型】
 * - 通俗解释：序列化处理类，用于实现具体脱敏的逻辑，通过重写serialize()方法把原数据变成带*的数据
 * -- 需要获取数据，那么需要使用到 getXxxx() 方法，故需要将注解添加到对应的 get 方法上，若使用了 Lombok 需要自己定义相应的 get 方法。
 * -- 需要使用 using 属性指定处理参数的类，该类需要继承 JsonSerializer 类，并重写 serialize()。
 * -- 其作用是处理属性，按照规则封装到指定的参数中，通过value 获取属性，通过 gen.writeXxx() 方法写出参数。
 * JsonDeserializer抽象类：【】
 * - 通俗解释：反序列化时，对参数进行封装，故到的是 setXxxx() 方法，所以需要将注解添加到对应的 set 方法上，若使用了 Lombok 需要自己定义相应的 set 方法。
 * -- 需要使用 using 属性指定处理参数的类，该类需要继承 JsonDeserializer 类，并重写 deserialize()。
 * -- 其作用是处理参数，按照规则封装到指定的属性中，通过 p.getText() 获取参数
 * <p>
 * ContextualSerializer接口：
 * - 官方解释：JsonSerializer可以实现的附加接口获得一个回调，该回调可用于创建序列化程序的上下文实例，以用于处理支持的类型的属性。这对于可以通过批注配置的序列化程序很有用，或者应具有不同的行为，具体取决于要序列化的属性的类型。
 * - 通俗理解：通过回调函数实现自定义注解中的字段信息传递给自定义JsonSerializer对象的操作，比如我们这的自定义注解中存在type和permission两个字段，自定义JsonSerializer序列化工具中也存在type和permission两个字段，把注解中的两个字段值赋值给自定义JsonSerializer。
 **/
@Slf4j
@NoArgsConstructor
public class SensitiveInfoSerialize extends JsonSerializer<String> implements ContextualSerializer {
    /**
     * 脱敏策略
     */
    private IStrategy strategy;
    /**
     * 开始显示的字符下标
     */
    private int begin;
    /**
     * 结尾显示的字符下标
     */
    private int end;
    /**
     * 脱敏的正则
     */
    private String pattern;
    /**
     * 替换后的字符
     */
    private String replaceChar;

    public SensitiveInfoSerialize(IStrategy strategy, String pattern, String replaceChar, int begin, int end) {
        this.strategy = strategy;
        this.pattern = pattern;
        this.replaceChar = replaceChar;
        this.begin = begin;
        this.end = end;
    }

    /**
     * 序列化的逻辑处理
     * 第一个参数：表示的是被序列化的类型的值
     * 第二个参数：表示的是用于输出生成的Json内容
     * 第三个参数：表示序列化器提供者，用于获取序列化配置或者其他序列化器
     * 将想要序列化的字符串传入 jsonGenerator.writeString()方法的参数中
     */
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        log.info("hh");
        /// 默认使用正则脱敏、 begin、end 不为空，则策略脱敏
        if (begin == 0 && end == 0) {
            gen.writeString(strategy.desensitizationByPattern(value, pattern, replaceChar));
        } else {
            gen.writeString(strategy.desensitization(value, begin, end));
        }
    }

    /**
     * 自定义注解被拦截后的回调函数
     * 第一个参数：表示序列化器提供者，用于获取序列化配置或者其他序列化器
     * 第二个参数：表示代表这个属性的方法或者字段，用于获取要序列化的值。
     * 返回：该方法的返回结果是一个序列化器，根据所要实现的序列化行为来决定是返回当前序列化器还是新建一个序列化器，从而改变序列化时的行为。
     */
    @Override
    @SneakyThrows
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        log.info("test");
        if (beanProperty != null) {
            // 非 String 类直接跳过
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                SensitiveInfo sensitiveInfo = beanProperty.getAnnotation(SensitiveInfo.class);
                if (sensitiveInfo == null) {
                    sensitiveInfo = beanProperty.getContextAnnotation(SensitiveInfo.class);
                }
                if (sensitiveInfo != null) {
                    Class<? extends IStrategy> clazz = sensitiveInfo.strategy();
                    // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
                    return new SensitiveInfoSerialize(clazz.getDeclaredConstructor().newInstance(), sensitiveInfo.pattern(), sensitiveInfo.replaceChar(), sensitiveInfo.begin(), sensitiveInfo.end());
                }
                return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
            }
        }
        return serializerProvider.findNullValueSerializer(null);
    }
}
