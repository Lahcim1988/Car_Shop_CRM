package crm.servlet.car;

import crm.dao.CarDAO;
import crm.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car_add")
public class Add extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("customer_id"));
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String yearOfManufacture = request.getParameter("yearOfManufacture");
        String registrationNumber = request.getParameter("registrationNumber");
        String nextService = request.getParameter("nextService");
        Car car = new Car(id, model, brand, yearOfManufacture, registrationNumber, nextService);
        CarDAO.add_update_Car(car);
        request.setAttribute("customer_id", id);

        getServletContext().getRequestDispatcher("/WEB-INF/car/add.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        request.setAttribute("customer_id", id);
        getServletContext().getRequestDispatcher("/WEB-INF/car/add.jsp").forward(request, response);
    }
}
