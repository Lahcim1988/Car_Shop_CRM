package crm.servlet.customer;

import crm.dao.CustomerDAO;
import crm.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/all")
public class All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String get = request.getParameter("get");
        List<Customer> customerList = CustomerDAO.getCustomers();
        List<Customer> all = new ArrayList<>();

        for (Customer c : customerList) {
            System.out.println(c);
            Pattern pattern = Pattern.compile(get);
            Matcher matcher = pattern.matcher(c.getSurName());
            boolean match = matcher.find();

            if (match) {
                all.add(c);
            }
        }

        request.setAttribute("customer", all);
        getServletContext().getRequestDispatcher("/WEB-INF/customer/all.jsp").forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> allCustomer = CustomerDAO.getCustomers();
        request.setAttribute("customers", allCustomer);
        getServletContext().getRequestDispatcher("/WEB-INF/customer/all.jsp").forward(request, response);
    }
}
