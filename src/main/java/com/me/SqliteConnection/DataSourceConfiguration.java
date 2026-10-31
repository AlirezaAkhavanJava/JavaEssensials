package com.me.SqliteConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DataSourceConfiguration implements CreateConnection {


    public void makeConnection() throws SQLException {
        try {
            String url = "jdbc:sqlite:lite.db";
            Connection dataSource = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("EXCEPTION : " + e.getLocalizedMessage());
        }
    }

}
