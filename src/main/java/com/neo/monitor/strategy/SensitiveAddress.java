package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 地址脱敏
 *
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveAddress implements IStrategy {
    @Override
    public String desensitization(String address, int begin, int end) {
        if (begin != SensitiveDefaultLengthEnum.ADDRESS.getBegin() && begin != 0) {
            return SensitiveInfoUtils.address(address, begin);
        }
        return SensitiveInfoUtils.address(address, SensitiveDefaultLengthEnum.ADDRESS.getBegin());
    }
}
