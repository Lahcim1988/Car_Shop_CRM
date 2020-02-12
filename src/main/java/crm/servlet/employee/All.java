package crm.servlet.employee;

import crm.dao.EmployeeDAO;
import crm.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee_all")
public class All extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployee = EmployeeDAO.getEmployees();
        request.setAttribute("employees", allEmployee);

        getServletContext().getRequestDispatcher("/WEB-INF/employee/all.jsp").forward(request, response);
    }
}