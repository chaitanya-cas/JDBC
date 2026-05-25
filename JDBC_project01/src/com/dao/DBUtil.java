package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
    private final static String URL ="jdbc:mysql://localhost:3306/jdbc_db";
    private final static String USER = "root";
    private final static String PASS = "cas@123";

    public static Connection getConnection()throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        return con;
    }

}
