package com.nuc.library.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static final String DBDriver="com.mysql.jdbc.Driver";
    public static final String DBUrl="jdbc:mysql://127.0.0.1:3306/librarysystem?useUnicode=true&characterEncoding=UTF-8";
    public static final String username="root";
    public static final String password="123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DBDriver);
        Connection conn = DriverManager.getConnection(DBUrl, username, password);
        if (conn != null)
            System.out.println("连接成功");
        return conn;
    }
}
