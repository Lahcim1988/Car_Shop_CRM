package crm.dao;

import crm.db.DbUtil;
import crm.entity.ProfitLose_Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfitLoseDAO {

    public static double chargeRepairFee(ProfitLose_Report plReport){

        String db = "SELECT SUM(customer_fee) FROM crm.car_service where repair_status = 'DONE' " +
                "and repair_start_day >= ? and repair_start_day < ?";
        double fee = 0;
        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setString(1, plReport.getRepairStartDay().toString());
            statement.setString(2, plReport.getRepairEndDay().toString());
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                fee = result.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fee;
    }

}
