package com.codegym.finalproject.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToMySQL {
    private static final String URL ="jdbc:mysql://localhost:3306/testModule3";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
