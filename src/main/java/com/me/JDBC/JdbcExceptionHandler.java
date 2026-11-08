package com.me.JDBC;

import java.sql.SQLException;

public class JdbcExceptionHandler {

    @SuppressWarnings("unused")
    public DatabaseException translate(String action, Exception e) {

        if (e instanceof InterruptedException) {
            Thread.currentThread().interrupt(); // restore the flag (section 4)
            return new DatabaseException(action + " was interrupted", e);
        }

        if (e instanceof SQLException sql) {
            String state = sql.getSQLState() == null ? "" : sql.getSQLState();
            switch (state) {
                case "23505" -> {
                    return new DatabaseException(action + ": value already exists (unique constraint)", e);
                }
                case "23502" -> {
                    return new DatabaseException(action + ": a required column was null", e);
                }
                case "42P07" -> {
                    return new DatabaseException(action + ": table already exists", e);
                }
                case "42P01" -> {
                    return new DatabaseException(action + ": table does not exist", e);
                }
            }
            if (state.startsWith("08")) {
                return new DatabaseException(action + ": cannot reach the database", e);
            }
            return new DatabaseException(action + " failed: " + sql.getMessage(), e);
        }

        return new DatabaseException(action + " failed unexpectedly: " + e, e);
    }
}