package com.me.JDBC;

import java.sql.SQLException;

public class DatabaseException extends RuntimeException {

    private final String sqlState;
    private final int errorCode;

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof SQLException sql) {
            this.sqlState = sql.getSQLState();
            this.errorCode = sql.getErrorCode();
        } else {
            this.sqlState = null;
            this.errorCode = 0;
        }
    }

    public String getSqlState() { return sqlState; }
    public int getErrorCode() { return errorCode; }
}