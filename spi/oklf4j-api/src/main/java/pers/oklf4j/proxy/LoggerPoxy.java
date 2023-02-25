package pers.oklf4j.proxy;

import pers.oklf4j.api.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日志代理类，主要是为了实现在日志消息前加上类名
 */
public class LoggerPoxy implements Logger {

    private final Logger origin;

    private final Class<?> clazz;

    /**
     * 这里时间格式也可以拓展成从配置文件中取
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LoggerPoxy(Logger origin, Class<?> clazz) {
        this.origin = origin;
        this.clazz = clazz;
    }

    @Override
    public void info(String msg) {
        origin.info(prefix() + msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        origin.error(prefix() + msg, t);
    }

    private String prefix() {
        return DATE_TIME_FORMATTER.format(LocalDateTime.now()) + "--" + clazz.getName() + ": ";
    }
}
