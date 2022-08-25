package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 手机号码脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveMobile implements IStrategy {

    @Override
    public String desensitization(String mobile,int begin ,int end) {
        if(begin != SensitiveDefaultLengthEnum.MOBILE.getBegin() && begin !=0 &&
                end != SensitiveDefaultLengthEnum.MOBILE.getEnd() && end !=0){
            return SensitiveInfoUtils.mobilePhone(mobile,begin,end);
        }
        return SensitiveInfoUtils.mobilePhone(mobile, SensitiveDefaultLengthEnum.MOBILE.getBegin(), SensitiveDefaultLengthEnum.MOBILE.getEnd());
    }

}
