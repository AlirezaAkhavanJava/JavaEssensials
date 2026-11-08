package com.me;

import com.me.JDBC.Database;
import com.me.JDBC.UsingStatement;

public class Main {
    static void main() {
        Database database = new UsingStatement();
        database.preparedInsert("Kill yourself");
    }
}