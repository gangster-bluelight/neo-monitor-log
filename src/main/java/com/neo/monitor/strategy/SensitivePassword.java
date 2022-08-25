package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 密码脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitivePassword implements IStrategy {

    @Override
    public String desensitization(String password,int begin,int end) {
        if(begin != SensitiveDefaultLengthEnum.PASSWORD.getBegin() && begin !=0){
            return SensitiveInfoUtils.password(password,begin);
        }
        return SensitiveInfoUtils.password(password, SensitiveDefaultLengthEnum.PASSWORD.getBegin());
    }

}
