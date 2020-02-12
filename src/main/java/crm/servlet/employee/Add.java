package crm.servlet.employee;

import crm.dao.EmployeeDAO;
import crm.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee_add")
public class Add extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String address = request.getParameter("address");
        String mobile_phone = request.getParameter("mobile_phone");
        String note = request.getParameter("note");
        Double man_hours_cost = Double.parseDouble(request.getParameter("man_hours_cost"));

        Employee employee = new Employee(name, surName, address, mobile_phone, note, man_hours_cost);
        EmployeeDAO.add_update_Employee(employee);

        getServletContext().getRequestDispatcher("/WEB-INF/employee/add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/employee/add.jsp").forward(request, response);

    }

}
