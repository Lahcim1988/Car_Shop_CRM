package crm.servlet.carService;

import crm.dao.CarSeviceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_service")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("service_id"));
        CarSeviceDAO.deleteById(id);
        getServletContext().getRequestDispatcher("/WEB-INF/car_service/delete.jsp").forward(request, response);


    }
}