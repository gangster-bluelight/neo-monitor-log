package com.neo.monitor;

import com.neo.monitor.entity.UserEntity;
import com.neo.monitor.utils.JsonMapper;
import com.neo.monitor.utils.SensitiveWordFilter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Set;

@Slf4j
@SpringBootTest
class NeoMonitorLogsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        UserEntity userEntity = UserEntity.builder()
                .userNamePattern("张三四")
                .userNameLength("张三四")
                .passwordPattern("12234bhbiHJF6543")
                .passwordLength("122^&*676543")
                .idCardPattern("432145167805126789")
                .idCardLength("432145167805126789")
                .fixedPhonePattern("076512344321")
                .fixedPhoneLength("076512344321")
                .mobilePattern("15678900987")
                .mobileLength("15678900987")
                .addressPattern("北京市东城区东华门街道北京香江戴斯酒店")
                .addressLength("北京市东城区东华门街道北京香江戴斯酒店")
                .emailPattern("23345@qq.com")
                .emailLength("23345@qq.com")
                .bankCardPattern("6212262502009182455")
                .bankCardCustomizePattern("6212262502009182455")
                .bankCardLength("6212262502009182455")
                .build();
        log.info(JsonMapper.nonNullMapper().toJson(userEntity));
    }

    @Test
    @SneakyThrows
    public void test2(){
        long beginTime = System.currentTimeMillis();
        File file = ResourceUtils.getFile("classpath:SensitiveWord.txt");
        SensitiveWordFilter filter = new SensitiveWordFilter(file.getPath());
        log.info("敏感词的数量：" + filter.sensitiveWordMap.size());
        String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
                + "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
        log.info("待检测语句字数：" + string.length());

        Set<String> set = filter.getSensitiveWord(string, 1);
        long endTime = System.currentTimeMillis();
        log.info("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        log.info("总共消耗时间为：" + (endTime - beginTime));
    }
}
