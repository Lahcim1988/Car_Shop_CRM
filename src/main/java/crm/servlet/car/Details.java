package crm.servlet.car;

import crm.dao.CarDAO;
import crm.dao.CarSeviceDAO;
import crm.entity.Car;
import crm.entity.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/details_car")
public class Details extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("car_id"));
        Car car = CarDAO.getById(id);
        request.setAttribute("car", car);

        List<CarService> carServices = CarSeviceDAO.getByCarId(id);
        request.setAttribute("car_service", carServices);

        getServletContext().getRequestDispatcher("/WEB-INF/car/details.jsp").forward(request, response);

    }
}
