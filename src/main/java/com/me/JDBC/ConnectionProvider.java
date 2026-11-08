package com.me.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionProvider implements SQLiteDBConnection {

    protected final Connection dataSource;

    protected ConnectionProvider() {
        try {
            this.dataSource = DriverManager.getConnection("jdbc:sqlite:task.db");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish SQLite connection", e);
        }
    }
}
