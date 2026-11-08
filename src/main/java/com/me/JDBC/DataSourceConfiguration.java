package com.me.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DataSourceConfiguration implements Database {

    Connection dataSource;

    protected DataSourceConfiguration() throws SQLException {
        dataSource = DriverManager.getConnection("jdbc:sqlite:lite.db");
    }


    @Override
    public void makeConnection() {

    }

}