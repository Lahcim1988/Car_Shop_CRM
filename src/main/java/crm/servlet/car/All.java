package crm.servlet.car;

import crm.dao.CarDAO;
import crm.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all_cars")
public class All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        List<Car> cars = CarDAO.getByCustomerId(id);
        request.setAttribute("cars", cars);
        request.setAttribute("customer_id", id);

        getServletContext().getRequestDispatcher("/WEB-INF/car/all.jsp").forward(request, response);

    }
}
