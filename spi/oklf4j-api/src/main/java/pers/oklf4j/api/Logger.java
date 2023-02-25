package pers.oklf4j.api;

/**
 * 日志接口
 */
public interface Logger {

    /**
     * 信息日志接口
     * @param msg
     */
    void info(String msg);

    /**
     * 错误日志接口
     * @param msg
     * @param t
     */
    void error(String msg, Throwable t);

}
