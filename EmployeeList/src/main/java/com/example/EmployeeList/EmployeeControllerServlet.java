package com.example.EmployeeList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeControllerServlet", value = "/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
    private EmployeeDbUtil employeeDbUtil;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        Context initContext = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/practice");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        try {
            employeeDbUtil = new EmployeeDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listEmployee(request, response);
                    break;
                case "ADD":
                    addEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }


    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String FullName = request.getParameter("FullName");
        String Birthday = request.getParameter("Birthday");
        String Address = request.getParameter("Address");
        String Position = request.getParameter("Position");
        String Department = request.getParameter("Department");

        Employee theEmployee = new Employee(FullName, Birthday, Address, Position, Department);

        employeeDbUtil.addEmployee(theEmployee);

        listEmployee(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Employee> employees = employeeDbUtil.getEmployee();

        request.setAttribute("EMPLOYEE_LIST", employees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employee.jsp");
        dispatcher.forward(request, response);
    }
}
