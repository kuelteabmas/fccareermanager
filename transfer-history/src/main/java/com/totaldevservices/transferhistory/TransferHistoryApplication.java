package com.totaldevservices.transferhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.totaldevservices.tdscommons.TDSCommons.createDbIfNotExists;

@SpringBootApplication
public class TransferHistoryApplication {
    public static void main(String[] args) {
        createDbIfNotExists("192.168.12.165", "transferhistorydb", "5432");
        SpringApplication.run(TransferHistoryApplication.class, args);
    }
}
