package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 固话脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveFixedPhone implements IStrategy {

    @Override
    public String desensitization(String fixedPhone,int begin ,int end) {
        if(begin != SensitiveDefaultLengthEnum.FIXED_PHONE.getBegin() && begin !=0 &&
                end != SensitiveDefaultLengthEnum.FIXED_PHONE.getEnd() && end !=0){
            return SensitiveInfoUtils.fixedPhone(fixedPhone,end);
        }
        return SensitiveInfoUtils.fixedPhone(fixedPhone, SensitiveDefaultLengthEnum.FIXED_PHONE.getEnd());
    }

}
