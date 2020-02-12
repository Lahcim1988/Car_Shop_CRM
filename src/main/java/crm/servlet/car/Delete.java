package crm.servlet.car;

import crm.dao.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_car")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("car_id"));
        CarDAO.deleteById(id);

        String customer_id = request.getParameter("customer_id");
        request.setAttribute("customer_id", customer_id);

        getServletContext().getRequestDispatcher("/WEB-INF/car/delete.jsp").forward(request, response);
    }
}
