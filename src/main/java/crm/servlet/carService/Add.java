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

@WebServlet("/add_service")
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarService carService = createService(request);
        CarSeviceDAO.add_update_CarService(carService);
        getServletContext().getRequestDispatcher("/WEB-INF/car_service/add.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = EmployeeDAO.getEmployees();

        List<Car> cars = CarDAO.getCars();

        request.setAttribute("all_employee", employees);
        request.setAttribute("car", cars);
        request.setAttribute("repair_status", RepairStatus.values());

        getServletContext().getRequestDispatcher("/WEB-INF/car_service/add.jsp").forward(request, response);
    }

    public static CarService createService(HttpServletRequest request) throws ServletException, IOException {
        String receiveDay = request.getParameter("receiveDay");
        String repairPlanDay = request.getParameter("repairPlanDay");
        String repair_start_day = request.getParameter("repair_start_day");
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String issueNote = request.getParameter("issueNote");
        String repairNote = request.getParameter("repairNote");
        String repairStatus = request.getParameter("repairStatus");
        int car_id = Integer.parseInt(request.getParameter("car_id"));
        double customerFee = Double.parseDouble(request.getParameter("customerFee"));
        double partsFee = Double.parseDouble(request.getParameter("partsFee"));
        double man_hours_cost =  Double.parseDouble(request.getParameter("man_hours_cost"));
        int man_hours_amount = Integer.parseInt(request.getParameter("man_hours_amount"));
        CarService carService = new CarService(receiveDay, repairPlanDay, repair_start_day, employee_id, issueNote,
                repairNote, repairStatus, car_id, customerFee, partsFee, man_hours_cost, man_hours_amount);
        return carService;
    }
}