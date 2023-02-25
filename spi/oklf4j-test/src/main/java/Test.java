import pers.oklf4j.api.Logger;
import pers.oklf4j.factory.Oklf4jFactory;

import java.util.Map;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        Logger testLogger = Oklf4jFactory.getLogger(Test.class);
        testLogger.info("测试信息日志");
        testLogger.error("测试错误日志", new IllegalArgumentException("参数错误"));

        Thread.sleep(500L);
        System.out.println();
        Logger mapLogger = Oklf4jFactory.getLogger(Map.class);
        mapLogger.info("测试信息日志");
        mapLogger.error("测试错误日志", new IllegalArgumentException("参数错误"));
    }
}
