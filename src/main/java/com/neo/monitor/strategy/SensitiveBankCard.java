package com.neo.monitor.strategy;

import com.neo.monitor.lang.SensitiveDefaultLengthEnum;
import com.neo.monitor.utils.SensitiveInfoUtils;

/**
 * 银行卡号脱敏
 * @author blue-light
 * Date: 2022-08-17
 **/
public class SensitiveBankCard implements IStrategy {

    @Override
    public String desensitization(String bankCard,int begin, int end) {
        if(begin != SensitiveDefaultLengthEnum.BANKCARD.getBegin() && begin !=0 &&
                end != SensitiveDefaultLengthEnum.BANKCARD.getEnd() && end !=0){
            return SensitiveInfoUtils.bankCard(bankCard,begin,end);
        }
        return SensitiveInfoUtils.bankCard(bankCard, SensitiveDefaultLengthEnum.BANKCARD.getBegin(), SensitiveDefaultLengthEnum.BANKCARD.getEnd());
    }

}
