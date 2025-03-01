package com.totaldevservices;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class TDSCommons {

    public static void createDbIfNotExists(String ip, String databaseName, String port) {
        Connection connection = null;
        Statement statement = null;
        try {
            log.debug(String.format("Creating %s database if not exist...", databaseName));
            String serverConnectionIP = String.format("jdbc:postgresql://%s:%s/", ip, port);
            connection = DriverManager.getConnection(serverConnectionIP, "tds", "fccareermanager");
            statement = connection.createStatement();
            statement.executeQuery(String.format("SELECT count(*) FROM pg_database WHERE datname = '%s'", databaseName));
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count <= 0) {
                statement.executeUpdate(String.format("CREATE DATABASE %s", databaseName));
                log.debug(String.format("Database %s created.", databaseName));
            } else {
                log.debug(String.format("Database %s already exist.", databaseName));
            }
        } catch (SQLException e) {
            log.error(e.toString());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    log.debug("Closed Statement.");
                }
                if (connection != null) {
                    log.debug("Closed Connection.");
                    connection.close();
                }
            } catch (SQLException e) {
                log.error(e.toString());
            }
        }
    }
}
