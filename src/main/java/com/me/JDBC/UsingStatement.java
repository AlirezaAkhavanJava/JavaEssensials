package com.me.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class UsingStatement extends DataSourceConfiguration {


    @Override
    public void createToDoTable() {
        try {
            String sql = """
                    CREATE TABLE IF NOT EXISTS todo (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT
                    );
                    """;
            Statement statement = super.dataSource.createStatement();
            statement.executeQuery(sql);

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage().toUpperCase());
        }
    }

    @Override
    public void insert() {
        try {
            String sql = "INSERT INTO todo(name) VALUES('Walk')";
            Statement statement = super.dataSource.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException | NullPointerException e) {
            System.out.println("Message " + e.getLocalizedMessage().toUpperCase());
        }
    }
}
