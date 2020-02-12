package crm.servlet.employee;

import crm.dao.CarSeviceDAO;
import crm.entity.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee_service")
public class EmployeeService extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("empId"));

        System.out.println(id);

        List<CarService> employeeId = CarSeviceDAO.getByEmploeeId(id);

        for (CarService service : employeeId) {
            System.out.println(service);
        }

        request.setAttribute("car_service", employeeId);

        getServletContext().getRequestDispatcher("/WEB-INF/employee/service.jsp").forward(request, response);


    }


}
