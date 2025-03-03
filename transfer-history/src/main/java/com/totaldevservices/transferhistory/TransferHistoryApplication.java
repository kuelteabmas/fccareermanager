package com.totaldevservices.transferhistory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import static com.totaldevservices.tdscommons.TDSCommons.createDbIfNotExists;

@Profile("staging")
@SpringBootApplication
public class TransferHistoryApplication {

//    @Value("${dbName}")
//    private static String databaseName;
//
//    public static void main(String[] args) {
//        createDbIfNotExists("192.168.12.165", databaseName, "5432");
//        SpringApplication.run(TransferHistoryApplication.class, args);
//    }

    /// //////////////////////////////////////////////////////////////
    ///
//    private String databaseName;
//
//    @Value("${dbName.name}")
//    public void setDatabaseName(String databaseName) {
//        this.databaseName = databaseName;
//    }
//
//    public String getDatabaseName() {
//        return databaseName;
//    }

//    public static void main(String[] args) {
//        TransferHistoryApplication application = new TransferHistoryApplication();
//        application.setDatabaseName(application.getDatabaseName());
//        createDbIfNotExists("192.168.12.165", application.getDatabaseName(), "5432");
//        SpringApplication.run(TransferHistoryApplication.class, args);
//    }

/// //////////////////////////////////////////////////////////////
    //    @Value("${dbName.name}")
//    private String databaseName;

//    public static void main(String[] args) {
//        createDbIfNotExists("192.168.12.165", databaseName, "5432");
//        SpringApplication.run(TransferHistoryApplication.class, args);
//    }
//
//    @Bean
//    public TransferHistoryApplication application() {
//        return new TransferHistoryApplication();
//    }

    /// //////////////////////////////////

//    @Value("${dbName}")
//    private String databaseName;
//
//    public static void main(String[] args) {
//        SpringApplication.run(TransferHistoryApplication.class, args);
//    }
//
//    public TransferHistoryApplication(@Value("${dBname}") String dBName, String ip, String port) {
//        this.databaseName = dBName;
//        // Other configuration properties can be passed like this
//        // or you can create a constructor with all required parameters
//
//        createDbIfNotExists("192.168.12.165", databaseName, "5432");
//
//    }

//    /// /////////////////////////////
//
//
//    private static String dbName;
//
//    @Autowired
//    public TransferHistoryApplication(@Value("${dbName}") String dbName) {
//        this.dbName = dbName;
//    }
//
//    public static void main(String[] args) {
//        createDbIfNotExists("192.168.12.165", dbName, "5432");
//        SpringApplication.run(TransferHistoryApplication.class, args);
//    }
//


    //    /// /////////////////////////////




    private static String DBNAME;

    @Value("${dbName}")
    public void setDbName(String dbName) {
        DBNAME = dbName;
    }

    public static String getDBNAME() {
        return DBNAME;
    }

    public static void main(String[] args) {
        getDBNAME();
        createDbIfNotExists("192.168.12.165", DBNAME, "5432");
        SpringApplication.run(TransferHistoryApplication.class, args);
    }
}
