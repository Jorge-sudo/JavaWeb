package com.alexander.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con  = null;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bdcarritocompras?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "danay hija";
    public Connection getConnection(){
        try {
            con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            return con;
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return con;
    }
}
