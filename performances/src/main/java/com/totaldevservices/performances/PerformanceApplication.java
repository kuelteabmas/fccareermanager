package com.totaldevservices.performances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.totaldevservices.tdscommons.TDSCommons.createDbIfNotExists;

@SpringBootApplication
public class PerformanceApplication {
    public static void main(String[] args) {
        createDbIfNotExists("transferhistorydb", "5892");
        SpringApplication.run(PerformanceApplication.class, args);
    }
}
