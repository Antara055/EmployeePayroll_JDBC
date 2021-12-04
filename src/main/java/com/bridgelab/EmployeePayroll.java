package com.bridgelab;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayroll {
    public static void main(String[] args) {
        String dbURl="jdbc:mysql://localhost:3306/payroll_service";
        String userName="Antara";
        String password="##Antara55";
        try {
            Connection connection = DriverManager.getConnection(dbURl, userName, password);
            if (connection != null) {
                System.out.println("Connected"+connection);
            }
        }
        catch (SQLException e){
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
