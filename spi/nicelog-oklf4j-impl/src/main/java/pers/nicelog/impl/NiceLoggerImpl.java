package pers.nicelog.impl;

import pers.oklf4j.api.Logger;

/**
 * 日志实现类，简单使用控制台打印
 */
public class NiceLoggerImpl implements Logger {

    private static final String PREFIX = "[NiceLoggerImpl]";

    @Override
    public void info(String s) {
        System.out.println(PREFIX + s);
    }

    @Override
    public void error(String s, Throwable throwable) {
        System.err.println(PREFIX + s);
        throwable.printStackTrace();
    }

}
