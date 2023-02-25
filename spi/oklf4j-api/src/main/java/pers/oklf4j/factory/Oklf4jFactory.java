package pers.oklf4j.factory;

import pers.oklf4j.api.Logger;
import pers.oklf4j.proxy.LoggerPoxy;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 获取日志操作类实例
 */
public class Oklf4jFactory {

    private static final Map<Class<?>, LoggerPoxy> LOGGER_CACHE = new ConcurrentHashMap<>();

    private static Logger LOGGER;

    static  {
        ServiceLoader<Logger> loggerServiceLoader = ServiceLoader.load(Logger.class);
        //只取第一个
        for (Logger logger : loggerServiceLoader) {
            LOGGER = logger;
            break;
        }
    }

    /**
     * 获取日志操作对象
     * @param clazz
     * @return
     */
    public static Logger getLogger(Class<?> clazz) {
        if (LOGGER == null) {
            System.err.println("没有指定日志实现类");
        }
        return LOGGER_CACHE.computeIfAbsent(clazz, c -> new LoggerPoxy(LOGGER, c));
    }

}
