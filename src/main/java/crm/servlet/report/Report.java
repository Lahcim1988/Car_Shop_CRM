package crm.servlet.report;

import crm.entity.ManHours_Report;
import crm.entity.ProfitLose_Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/report")
public class Report extends HttpServlet {

    private final String DATE_START = "2019-01-01";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String repair_start_time = request.getParameter("repair_start_time");
        String repair_end_time = request.getParameter("repair_end_time");

        ManHours_Report hours_report = new ManHours_Report(repair_start_time, repair_end_time);
        hours_report.setHoursList();

        ProfitLose_Report pl_report = new ProfitLose_Report(repair_start_time, repair_end_time);
        pl_report.setRepairCost();

        request.setAttribute("time_report", hours_report.getHoursList());
        request.setAttribute("pl_report", pl_report);
        getServletContext().getRequestDispatcher("/WEB-INF/report/report.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        ManHours_Report hours_report = new ManHours_Report(DATE_START, date);
        hours_report.setHoursList();
        request.setAttribute("time_report", hours_report.getHoursList());

        ProfitLose_Report profitLose_report = new ProfitLose_Report(DATE_START, date);
        profitLose_report.setRepairCost();
        request.setAttribute("pl_report", profitLose_report);


        getServletContext().getRequestDispatcher("/WEB-INF/report/report.jsp").forward(request, response);
    }
}
