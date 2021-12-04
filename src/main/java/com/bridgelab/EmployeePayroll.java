package com.bridgelab;

import java.sql.*;
import java.util.Date;
import java.util.Enumeration;

public class EmployeePayroll {
    public static void main(String[] args) {
        String dbURl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "Antara";
        String password = "##Antara55";
        try {
            Connection connection = DriverManager.getConnection(dbURl, userName, password);
            if (connection != null) {
                System.out.println("Connected" + connection);
            }
            Statement readStat = connection.createStatement();
            String sqlUpdate = "update employee_payroll set salary=500000 where name='terisa'";
            int value1 = readStat.executeUpdate(sqlUpdate);
            if (value1 > 0) {
                System.out.println("Successfully updated");
            }
            String sqlRead1 = "SELECT name from employee_payroll where start_date between '2019-01-01' and '2020-12-31'";
            ResultSet resultSet1 = readStat.executeQuery(sqlRead1);
            while (resultSet1.next()) {
                String name = resultSet1.getString("name");
                System.out.println(name);
            }
            String sqlInsert = "INSERT INTO employee_payroll(name,salary,start_date) values ('anuska',6000000,'2021-05-01')";
            int value=readStat.executeUpdate(sqlInsert);
            if(value>0){
                System.out.println("Successfully added");
            }
            String sqlRead = "SELECT * FROM employee_payroll";
            ResultSet resultSet = readStat.executeQuery(sqlRead);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                Date start_date = resultSet.getDate("start_date");
                System.out.println(id + " | " + name + " | " + salary + " | " + start_date);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listDrivers();
    }
    public static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
