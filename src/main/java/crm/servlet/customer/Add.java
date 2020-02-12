package crm.servlet.customer;

import crm.dao.CustomerDAO;
import crm.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer_add")
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String birth = request.getParameter("dateOfBirth");
        Customer customer = new Customer(name, surName, birth);
        CustomerDAO.add_update_Customer(customer);
        getServletContext().getRequestDispatcher("/WEB-INF/customer/add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/customer/add.jsp").forward(request, response);

    }
}
