package crm.dao;

import crm.db.DbUtil;
import crm.entity.ManHours_Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManHoursDAO {

    public static List<String[]> getHoursRaport(ManHours_Report hoursReport) {
        String db = "select employee.id, name, surname, sum(man_hours_amount) from car_service " +
                "join employee on car_service.employee_id = employee.id" +
                " where repair_start_time > ? and repair_start_time < ?  GROUP BY employee.id";
        List<String[]> hoursList = new ArrayList<>();

        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setString(1, hoursReport.getRepair_start_time().toString());
            statement.setString(2, hoursReport.getRepair_end_time().toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String data = resultSet.getString("name") + " " + resultSet.getString("surName");
                String[] hr = new String[2];
                hr[0] = data;
                hr[1] = resultSet.getString("sum(man_hours_amount)");
                hoursList.add(hr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoursList;
    }
}
