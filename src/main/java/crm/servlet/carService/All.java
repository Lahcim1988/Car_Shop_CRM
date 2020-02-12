package crm.servlet.carService;

import crm.dao.CarSeviceDAO;
import crm.entity.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all_service")
public class All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<CarService> carServices = null;
        if (id == null) {
            carServices = CarSeviceDAO.getServiceCar();
        } else {
            int customer_id = Integer.parseInt(id);
            carServices = CarSeviceDAO.getByCustomerId(customer_id);
        }
        request.setAttribute("car_service", carServices);


        getServletContext().getRequestDispatcher("/WEB-INF/car_service/all.jsp").forward(request, response);
    }
}