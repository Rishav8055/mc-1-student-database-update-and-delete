package com.jap;

import javax.management.Query;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class DeleteUpdateStudentData
{

    public Connection getConnection(){
        Connection connection= null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localHost:3306/SCHOOLS";
        String user="root";
        String pass="root@123";
        connection = DriverManager.getConnection(url,user,pass);
        System.out.println("connection success");
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
        return connection;
    }

    public void deleteStudentData() throws SQLException {
      // call getConnection() method
        Connection connection =  getConnection();       //execute delete query
        Statement statement = connection.createStatement();
        String sql="DELETE FROM STUDENT WHERE ROLL_NO=14";
        statement.executeUpdate(sql);
        String sql1="Select * from STUDENT";
        ResultSet resultSet = statement.executeQuery(sql1);
        while (resultSet.next()){
            System.out.println("SCHOOL_NAME : " +resultSet.getString(1));
            System.out.println("STUDENT_NAME: " +resultSet.getString(2));
            System.out.println("ROLL_NO     : " +resultSet.getInt(3));
            System.out.println("CLASS       : " +resultSet.getInt(4));
            System.out.println("TOTALMARKS  : " +resultSet.getInt(5));

        }


    }

    public void updateStudentData() throws SQLException {
        // call getConnection() method
        Connection connection = getConnection();        //execute update query
        Statement statement = connection.createStatement();
        String sql ="UPDATE STUDENT SET TOTALMARKS=800 WHERE TOTALMARKS= 678 ";
        statement.executeUpdate(sql);
        String sql2="SELECT * FROM STUDENT";
        ResultSet resultSet = statement.executeQuery(sql2);
        while (resultSet.next()){
            System.out.println("SCHOOL_NAME : " +resultSet.getString(1));
            System.out.println("STUDENT_NAME: " +resultSet.getString(2));
            System.out.println("ROLL_NO     : " +resultSet.getInt(3));
            System.out.println("CLASS       : " +resultSet.getInt(4));
            System.out.println("TOTALMARKS  : " +resultSet.getInt(5));

        }

    }

    public static void main(String[] args) throws SQLException {
        DeleteUpdateStudentData salesDataDemo = new DeleteUpdateStudentData();
        salesDataDemo.deleteStudentData();
        salesDataDemo.updateStudentData();
    }
}
