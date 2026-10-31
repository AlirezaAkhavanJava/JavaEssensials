package com.me.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DataSourceConfiguration implements Database {

    Connection dataSource;

    @Override
    public void makeConnection(String url) {
        try {
            dataSource = DriverManager.getConnection(url);
        } catch (SQLException | NullPointerException e) {
            System.out.println("EXCEPTION : " + e.getLocalizedMessage());
        }
    }
}