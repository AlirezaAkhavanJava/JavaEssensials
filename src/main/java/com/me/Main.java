package com.me;

import com.me.JDBC.ConnectionExecutor;

public class Main {
    static void main() {
        ConnectionExecutor executor = new ConnectionExecutor();
        //executor.table();
        //executor.insertValue("Catch a Fish");
        executor.updateNameValue(" Play basketball!" , "Say Goodbye");
    }
}