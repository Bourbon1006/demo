package com.example.demo;

import java.sql.*;

public class data {

    // 定义数据库参数
    private static final String URL = "jdbc:mysql://localhost:3306/hub";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2830446056jy";

    // 数据库连接
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //增加用户信息
    public static void insertData(String a,String b) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `users` (username, password) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, a);
            statement.setString(2, b);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询用户信息
    public static void queryUserData() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * from `users`";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("查询结果：");
            System.out.println("用户名\t密码");
            while (resultSet.next()) {
                String usernameData = resultSet.getString("用户名");
                String passwordData = resultSet.getString("密码");
                System.out.println(usernameData + "\t" + passwordData);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean checkUserExists(String username) throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) AS count FROM `users` WHERE username = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        }
        return false;
    }

    public static boolean checkCredentials(String username, String password) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * from `users` where username = ? and password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // 如果查询返回结果，说明用户名和密码匹配
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "abc";
        String password = "123456";
        if(checkCredentials(username,password))
        {
            System.out.println("ok");
        }
    }*/

}
