package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 中文名称脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveChineseName implements IStrategy {

    @Override
    public String desensitization(String source,int begin,int end) {
        if(begin != SensitiveDefaultLengthEnum.CHINESE_NAME.getBegin() && begin !=0){
            return SensitiveInfoUtils.chineseName(source,begin);
        }
        return SensitiveInfoUtils.chineseName(source, SensitiveDefaultLengthEnum.CHINESE_NAME.getBegin());
    }

}
