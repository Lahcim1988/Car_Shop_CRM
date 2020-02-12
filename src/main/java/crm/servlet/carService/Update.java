package crm.servlet.carService;

import crm.dao.CarDAO;
import crm.dao.CarSeviceDAO;
import crm.dao.EmployeeDAO;
import crm.entity.Car;
import crm.entity.CarService;
import crm.entity.Employee;
import crm.entity.RepairStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static crm.servlet.carService.Add.createService;

@WebServlet("/update_service")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("service_id"));

        CarService carService = createService(request);
        carService.setId(id);

        CarSeviceDAO.add_update_CarService(carService);

        getServletContext().getRequestDispatcher("/WEB-INF/car_service/details.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("service_id"));
        CarService carService = CarSeviceDAO.getById(id);
        List<Employee> employees = EmployeeDAO.getEmployees();
        List<Car> cars = CarDAO.getCars();

        request.setAttribute("employees", employees);
        request.setAttribute("cars", cars);
        request.setAttribute("repair_status", RepairStatus.values());

        request.setAttribute("car_service", carService);


        getServletContext().getRequestDispatcher("/WEB-INF/car_service/details.jsp").forward(request, response);

    }
}