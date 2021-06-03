package com.example.EmployeeList;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDbUtil {
    private DataSource dataSource;

    public EmployeeDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Employee> getEmployee() throws Exception {

        List<Employee> employees = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from employee order by FullName";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {

                int ID = myRs.getInt("ID");
                String FullName = myRs.getString("FullName");
                String Birthday = myRs.getString("Birthday");
                String Address = myRs.getString("Address");
                String Position = myRs.getString("Position");
                String Department = myRs.getString("Department");

                Employee tempEmployee = new Employee(ID, FullName, Birthday, Address, Position, Department);

                employees.add(tempEmployee);
            }

            return employees;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addEmployee(Employee theEmployee) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "insert into employee "
                    + "(FullName, Birthday, Address, Position, Department) "
                    + "values (?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theEmployee.getFullName());
            myStmt.setString(2, theEmployee.getBirthday());
            myStmt.setString(3, theEmployee.getAddress());
            myStmt.setString(4, theEmployee.getPosition());
            myStmt.setString(5, theEmployee.getDepartment());

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }

    public Employee getEmployee(String theEmployeeId) throws Exception {

        Employee theEmployee = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int ID;

        try {
            ID = Integer.parseInt(theEmployeeId);

            myConn = dataSource.getConnection();

            String sql = "select * from employee where ID=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, ID);

            myRs = myStmt.executeQuery();

            if (myRs.next()) {
                String FullName = myRs.getString("FullName");
                String Birthday = myRs.getString("Birthday");
                String Address = myRs.getString("Address");
                String Position = myRs.getString("Position");
                String Department = myRs.getString("Department");

                theEmployee = new Employee(ID, FullName, Birthday, Address, Position, Department);
            }
            else {
                throw new Exception("Could not find student id: " + ID);
            }

            return theEmployee;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
}
