package crm.servlet.carService;

import crm.dao.CarSeviceDAO;
import crm.entity.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details_service")
public class Details extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("service_id"));
        CarService carService = CarSeviceDAO.getById(id);

        System.out.println(carService);
        request.setAttribute("car_service", carService);

        getServletContext().getRequestDispatcher("/WEB-INF/car_service/details.jsp").forward(request,response);

    }
}