package com.bkmovieapplication.context;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.jsp.tagext.TryCatchFinally;

public class DBContext {

    public Connection getConnection() throws Exception {
//        final String url = "jdbc:mysql://remotemysql.com:3306/oj3bOO0Agn";
//        final String user = "oj3bOO0Agn";
//        final String password = "ptIj0LrRVx";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            return DriverManager.getConnection(url, user, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
        final String url = "jdbc:mysql://127.0.0.1:3306/quanlyphimdb";
        final String user = "root";
        final String password = "123456789";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
        } catch (Exception e) {
        }
    }
}
