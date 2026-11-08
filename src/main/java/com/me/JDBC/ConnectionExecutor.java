package com.me.JDBC;

public class ConnectionExecutor {

    JDBCConnection connection = new JDBCConnection();
    private final JdbcExceptionHandler handler = new JdbcExceptionHandler();


    private void execute(String action, DbAction task) {
        try {
            task.run();
        } catch (Exception e) {
            exceptionMessage(handler.translate(action, e));
        }
    }

    public void exceptionMessage(DatabaseException e) {
        System.out.println("\u001B[31m======== FAILED ========\u001B[0m");
        System.out.println("\u001B[33m" + e.getMessage() + "\u001B[0m");
        if (e.getSqlState() != null) {
            System.out.println("SQLState: " + e.getSqlState());
        }
    }

    public void table() {
        execute("create table", () -> connection.CreateTable());
    }

    public void insertValue() {
        execute("insert value", () -> connection.insertValue());
    }

    public void insertValue(String value) {
        execute("insert value '" + value + "'", () -> connection.insertValue(value));
    }
}