package com.me.JDBC;

import java.sql.SQLException;

public interface SQLiteDBConnection {
    void CreateTable() throws SQLException;

    void insertValue() throws InterruptedException, SQLException;

    void insertValue(String value) throws SQLException;


}
