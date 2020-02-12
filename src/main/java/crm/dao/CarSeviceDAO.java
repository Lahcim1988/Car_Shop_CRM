package crm.dao;

import crm.db.DbUtil;
import crm.entity.CarService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarSeviceDAO {

    public static void add_update_CarService(CarService carService) {
        if (carService.getId() == 0) {
            String db = "INSERT INTO car_service (employee_id, car_id, receive_day, repair_plan_day, repair_start_day, " +
                    "issue_note, repair_note, repair_status, customer_fee, parts_fee, man_hours_cost, man_hours_amount)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try {
                String[] idColumn = {"ID"};
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db, idColumn);
                statement.setInt(1, carService.getEmployee().getId());
                statement.setInt(2, carService.getCar().getId());
                statement.setString(3, carService.getReceiveDay().toString());
                statement.setString(4, carService.getRepairPlanDay().toString());
                statement.setString(5, carService.getRepair_start_day().toString());
                statement.setString(6, carService.getIssueNote());
                statement.setString(7, carService.getRepairNote());
                statement.setString(8, carService.getRepairStatus().toString());
                statement.setDouble(9, carService.getCustomerFee());
                statement.setDouble(10, carService.getPartsFee());
                statement.setDouble(11, carService.getMan_hours_cost());
                statement.setInt(12, carService.getMan_hours_amount());

                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    carService.setId(rs.getInt(1));
                }

                System.out.println("Car added to service");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String db = "UPDATE car_service SET employee_id = ?, car_id = ?, receive_day = ?, repair_plan_day =?, repair_start_day=?," +
                    "issue_note=?, repair_note=?, repair_status=?, customer_fee=?, parts_fee=?, man_hours_cost=?, man_hours_amount=? " +
                    "WHERE id = ?";
            try {
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setInt(1, carService.getEmployee().getId());
                statement.setInt(2, carService.getCar().getId());
                statement.setString(3, carService.getReceiveDay().toString());
                statement.setString(4, carService.getRepairPlanDay().toString());
                statement.setString(5, carService.getRepair_start_day().toString());
                statement.setString(6, carService.getIssueNote());
                statement.setString(7, carService.getRepairNote());
                statement.setString(8, carService.getRepairStatus().toString());
                statement.setDouble(9, carService.getCustomerFee());
                statement.setDouble(10, carService.getPartsFee());
                statement.setDouble(11, carService.getMan_hours_cost());
                statement.setInt(12, carService.getMan_hours_amount());
                statement.setInt(13, carService.getId());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static List<CarService> getServiceCar() {
        String db = "SELECT * FROM car_service";
        ArrayList<CarService> carList = new ArrayList<>();

        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CarService carService = carFromResultSet(resultSet);
                carList.add(carService);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }


    public static CarService getById(int id) {
        String db = "SELECT * FROM car_service WHERE id = ?";
        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                CarService carService = carFromResultSet(resultSet);
                return carService;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<CarService> getByCustomerId(int id) {
        ArrayList<CarService> carList = new ArrayList<>();

        try {
            String db = "SELECT * FROM car_service JOIN car ON car_service.car_id=car.id where customer_id = ?";

            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CarService carService = carFromResultSet(resultSet);
                carList.add(carService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public static List<CarService> getByCarId(int id) {
        ArrayList<CarService> carList = new ArrayList<>();

        try {
            String db = "SELECT * FROM car_service WHERE car_id = ?";

            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CarService carService = carFromResultSet(resultSet);
                carList.add(carService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public static List<CarService> getByEmploeeId(int id) {
        ArrayList<CarService> carList = new ArrayList<>();
        String db = "SELECT * FROM car_service where employee_id = ? and repair_status = 'PENDING'";
        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CarService carService = carFromResultSet(resultSet);
                carList.add(carService);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }


    private static CarService carFromResultSet(ResultSet resultSet) throws SQLException {
        CarService carService = new CarService();
        carService.setId(resultSet.getInt("id"));
        carService.setReceiveDay(resultSet.getString("receive_day"));
        carService.setRepairPlanDay(resultSet.getString("repair_plan_day"));
        carService.setRepair_start_day(resultSet.getString("repair_start_day"));
        carService.setIssueNote(resultSet.getString("issue_note"));
        carService.setRepairNote(resultSet.getString("repair_note"));
        carService.setRepairStatus(resultSet.getString("repair_status"));
        carService.setCustomerFee(resultSet.getDouble("customer_fee"));
        carService.setPartsFee(resultSet.getDouble("parts_fee"));
        carService.setMan_hours_cost(resultSet.getDouble("man_hours_cost"));
        carService.setMan_hours_amount(resultSet.getInt("man_hours_amount"));
        carService.setEmployee(resultSet.getInt("employee_id"));
        carService.setCar(resultSet.getInt("car_id"));
        return carService;
    }

    public static void deleteById(int id) {
        String db = "DELETE FROM car_service WHERE id = ?";
        if (id != 0) {
            try {
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setInt(1, id);

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Client does not exist!");
        }

    }
}
