package com.neo.monitor.strategy;

import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description:
 */
public interface IStrategy {

    /**
     * 脱敏的具体实现方法
     *
     * @param source 原来对象属性
     * @param begin  内容开始显示的下标
     * @param end    内容末尾显示的下标
     * @return 返回脱敏后的信息
     */
    String desensitization(final String source, int begin, int end);

    /**
     * 脱敏的具体实现方法
     *
     * @param source      原来对象属性
     * @param pattern     内容显示正则
     * @param replaceChar 替换后的字符
     * @return 返回脱敏后的信息
     */
    default String desensitizationByPattern(String source, String pattern, String replaceChar) {
        return SensitiveInfoUtils.patternReplace(source, pattern, replaceChar);
    }

}
