package com.bkmovieapplication.context;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.jsp.tagext.TryCatchFinally;

public class DBContext {

    public Connection getConnection() throws Exception {
        /*Connection conn = null;
        try {
            String url = "jdbc:sqlserver://" + serverName + ":"+portNumber + "\\" + instance + ";databaseName="
                    + dbName;
            if (instance == null || instance.trim().isEmpty())
                url = "jdbc:sqlserver://" + serverName + ":"+portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, userID, password);
            System.out.println("Connected");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }

        return conn;*/
        
        final String url = "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_d274054322b1591";
        final String user = "b56b55b5c4f707";
        final String password = "cf4f8883";
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

    /* Insert your other code right after this comment */
 /*
     * Change/update information of your database connection, DO NOT change name of
     * instance variables in this class
     */
 /*private final String serverName = "localhost";
    private final String dbName = "QuanLyPhimDB";

    private final String portNumber = "1433";
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE SQLEXPRESS
    private final String userID = "sa";
    private final String password = "12";*/
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
        } catch (Exception e) {
        }
    }}
