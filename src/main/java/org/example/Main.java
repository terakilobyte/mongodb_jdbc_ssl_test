package org.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.TimeZone;

public class Main {

    static final String JDBC_DRIVER = "com.mongodb.jdbc.MongoDriver";
    static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    public static void main(String[] args) {
        String userUri = args[0];
        System.out.println(userUri);
        String db = args[1];
        java.util.Properties p = new java.util.Properties();
        p.setProperty("database", db);

        try {
            Connection conn = DriverManager.getConnection(userUri);
            DatabaseMetaData dbmd = conn.getMetaData();

            System.out.println("Successfully connected with " + dbmd.getDriverName() + ":" + dbmd.getDriverVersion());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}