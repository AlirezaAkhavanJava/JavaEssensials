package com.me.JDBC;

public interface Database {
    void createToDoTable();
    void insert();
    void preparedInsert(String value);
}
