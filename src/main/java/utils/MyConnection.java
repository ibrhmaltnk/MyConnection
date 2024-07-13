package utils;

import java.sql.*;

public class MyConnection {

    public Connection connection;
    public Statement statement;
    public  String url;
    public String username;
    public String password;

    public MyConnection(String url, String username, String password) {

        this.url = url;
        this.username = username;
        this.password = password;
        try {
            connection=DriverManager.getConnection(url,username,password);
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ResultSet getResultSet(String sql){

        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
