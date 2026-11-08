package com.me.JDBC;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection extends ConnectionProvider {

    String message = "\u001B[32m======== SUCCESS ========\u001B[0m";

    @Override
    public void CreateTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS task ( id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR);";
        Statement statement = dataSource.createStatement();
        statement.executeUpdate(sql);
        System.out.println(message);
    }


    @Override
    public void insertValue() throws InterruptedException, SQLException {
        String sql = "INSERT INTO task('name') VALUES ('Play basketball!')";
        Statement statement = dataSource.createStatement();
        statement.executeUpdate(sql);
        System.out.println(message);
    }

    @Override
    public void insertValue(String value) throws SQLException {
        String sql = "INSERT INTO task('name') VALUES (?)";
        PreparedStatement statement = dataSource.prepareStatement(sql);
        statement.setString(1, value);
        statement.executeUpdate();
        System.out.println(message);
    }

    @Override
    public void updateNameValue(String oldValue, String newValue) throws SQLException {
        String sql = "UPDATE task SET name = ? WHERE name = ?";

        PreparedStatement statement = dataSource.prepareStatement(sql);
        statement.setString(1, newValue);  // SET name = new
        statement.setString(2, oldValue);  // WHERE name = old

        int rows = statement.executeUpdate();
        System.out.println("\u001B[32m" + rows + " row(s) updated".toUpperCase() + "\u001B[0m");

    }
}
