package com.gctcw.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 日期时间工具类
 * </p>
 *
 * @author gctcw
 * @since 2022-11-17
 */
public class DateTimeUtil {
    /**
     * 获取字符串日期时间格式
     *
     * @param localDateTime
     * @param pattern
     * @return String
     */
    public static String str(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return df.format(localDateTime);
    }

    /**
     * 时间戳转 LocalDateTime
     *
     * @param timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime of (String timestamp) {
        long timeSecond = Long.valueOf(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return Instant.ofEpochSecond(timeSecond).atZone(zoneId).toLocalDateTime();
    }
}
