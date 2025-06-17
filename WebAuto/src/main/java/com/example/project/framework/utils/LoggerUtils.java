package com.example.project.framework.utils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoggerUtils {

    // Todo Tạo logger (SLF4J) cho class này
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    // Todo dùng log SLF4J để gọi logback (infor, debug, warn, error)
    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    // Log lỗi kèm exception stack trace
    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }
}
