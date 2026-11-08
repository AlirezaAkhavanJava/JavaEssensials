package com.me.JDBC;

@FunctionalInterface
public interface DbAction {
    void run() throws Exception;
}