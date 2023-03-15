package com.gctcw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * 程序启动入口
 */
@SpringBootApplication
@EnableScheduling
public class GctcwFrameworkRobotApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("America/New_York")));
        SpringApplication.run(GctcwFrameworkRobotApplication.class, args);
    }

}
