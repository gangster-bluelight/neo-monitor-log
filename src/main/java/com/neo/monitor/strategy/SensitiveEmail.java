package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 电子邮箱脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveEmail implements IStrategy {

    @Override
    public String desensitization(String email,int begin,int end) {
        if(begin != SensitiveDefaultLengthEnum.EMAIL.getBegin() && begin !=0 ){
            return SensitiveInfoUtils.email(email,begin);
        }
        return SensitiveInfoUtils.email(email, SensitiveDefaultLengthEnum.EMAIL.getBegin());
    }

}
