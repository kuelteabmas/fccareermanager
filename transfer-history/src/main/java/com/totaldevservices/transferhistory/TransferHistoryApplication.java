package com.totaldevservices.transferhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.totaldevservices.TDSCommons.createDbIfNotExists;

@SpringBootApplication
public class TransferHistoryApplication {
    public static void main(String[] args) {
        createDbIfNotExists("transferhistorydb", "5892");
        SpringApplication.run(TransferHistoryApplication.class, args);
    }
}
