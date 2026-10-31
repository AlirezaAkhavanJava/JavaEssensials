package com.me.JDBC;

public interface Database {
    void makeConnection(String url);
    void createToDoTable();
    void insert();
}
