package com.neo.monitor.advice;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;

/**
 * @author blue-light
 * Date 2021/1/9
 * Description
 */
public class LcyRollingFileAppender extends RollingFileAppender<Object> {
    @Override
    protected void subAppend(Object event) {
        DesensitizationAppender appender = new DesensitizationAppender();
        appender.operation((LoggingEvent) event);
        super.subAppend(event);
    }
}
