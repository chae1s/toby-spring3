package com.example.tobyspring3.db;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;


public class ConnectionChecker {
    public static void check() throws Exception {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                dbHost,
                dbUser,
                dbPassword
        );

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SHOW DATABASES");
        rs = st.getResultSet();
        while (rs.next()) {
            String str = rs.getString(1);
            System.out.println(str);
        }

    }

    public void add() throws Exception {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                dbHost,
                dbUser,
                dbPassword
        );
        PreparedStatement pstmt = conn.prepareStatement(
                "insert into users(id, name, password) values (?, ?, ?)"
        );
        pstmt.setString(1, "2");
        pstmt.setString(2, "choonsik2");
        pstmt.setString(3, "123456");
        pstmt.executeUpdate();
    }

    public void select() throws Exception {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                dbHost,
                dbUser,
                dbPassword
        );

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        rs = st.getResultSet();
        while (rs.next()) {
            String str = rs.getString(1);
            String str2 = rs.getString(2);
            String str3 = rs.getString(3);
            System.out.println(str + str2 + str3);
        }
    }

    public static void main(String[] args) throws Exception {
        ConnectionChecker cc = new ConnectionChecker();
        cc.select();
    }
}
