package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description:
 */
public class DefaultSensitiveStrategy implements IStrategy{
    @Override
    public String desensitization(String source, int begin, int end) {
        return SensitiveInfoUtils.password(source, SensitiveDefaultLengthEnum.DEFAULT_STRATEGY.getBegin());
    }
}
