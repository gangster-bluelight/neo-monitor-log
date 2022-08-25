package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 身份证号脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveIdCard implements IStrategy {

    @Override
    public String desensitization(String idCardNum,int begin ,int end) {
        if(begin != SensitiveDefaultLengthEnum.ID_CARD_NUM.getBegin() && begin !=0 &&
                end != SensitiveDefaultLengthEnum.ID_CARD_NUM.getEnd() && end !=0){
            return SensitiveInfoUtils.idCardNum(idCardNum,begin,end);
        }
        return SensitiveInfoUtils.idCardNum(idCardNum, SensitiveDefaultLengthEnum.ID_CARD_NUM.getBegin(), SensitiveDefaultLengthEnum.ID_CARD_NUM.getEnd());
    }

}
