package com.neo.monitor.entity;

import com.neo.monitor.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description:
 */
@Data
@Builder
public class UserEntity implements Serializable {
    /**
     * 中文姓名--正则
     */
    @SensitiveChineseName
    private String userNamePattern;
    /**
     * 中文姓名--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveChineseName.class, begin = 1)
    private String userNameLength;
    /**
     * 密码--正则
     */
    @SensitivePassword
    private String passwordPattern;
    /**
     * 密码--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitivePassword.class, begin = 6)
    private String passwordLength;
    /**
     * 身份证--正则
     */
    @SensitiveIdCard
    private String idCardPattern;
    /**
     * 身份证--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveIdCard.class, end = 4)
    private String idCardLength;
    /**
     * 固话--正则
     */
    @SensitiveFixedPhone
    private String fixedPhonePattern;
    /**
     * 固话--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveFixedPhone.class, end = 4)
    private String fixedPhoneLength;
    /**
     * 手机--正则
     */
    @SensitiveMobile
    private String mobilePattern;
    /**
     * 手机--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveMobile.class,begin = 3,end = 4)
    private String mobileLength;
    /**
     * 地址--正则
     */
    @SensitiveAddress
    private String addressPattern;
    /**
     * 地址--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveAddress.class, begin = 7)
    private String addressLength;
    /**
     * 邮箱--正则
     */
    @SensitiveEmail
    private String emailPattern;
    /**
     * 邮箱--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveEmail.class, begin = 1)
    private String emailLength;
    /**
     * 银行卡号--正则
     */
    @SensitiveBankCard
    private String bankCardPattern;
    /**
     * 银行卡号--自定义正则
     */
    @SensitiveInfo(pattern = "(?<=\\w{6})\\w(?=\\w{4})",replaceChar = "*")
    private String bankCardCustomizePattern;
    /**
     * 银行卡号--长度
     */
    @SensitiveInfo(strategy = com.neo.monitor.strategy.SensitiveBankCard.class, begin = 6, end = 4)
    private String bankCardLength;
}
