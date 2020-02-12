package crm.dao;

import crm.db.DbUtil;
import crm.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public static void add_update_Car(Car car) {

        if (car.getId() == 0) {
            String db = "INSERT INTO car (customer_id, model, brand, manufacture_year, " +
                    "registration_number, " +
                    "next_service) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                String[] idColumn = {"ID"};
                Connection connection = DbUtil.setConnection();


                PreparedStatement statement = connection.prepareStatement(db, idColumn);
                statement.setInt(1, car.getCustomer_id());
                statement.setString(2, car.getModel());
                statement.setString(3, car.getBrand());
                statement.setString(4, car.getYearOfManufacture());
                statement.setString(5, car.getRegistrationNumber());
                statement.setString(6, car.getNextService());
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    car.setId(rs.getInt(1));
                }


                System.out.println("Car " + car.getModel() + " added!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String db = "UPDATE car SET customer_id = ?, model = ?, brand = ?, manufacture_year = ?, " +
                        "registration_number = ?, next_service = ? WHERE id = ?";

                Connection connection = DbUtil.setConnection();

                PreparedStatement statement = connection.prepareStatement(db);
                statement.setString(1, car.getModel());
                statement.setString(2, car.getBrand());
                statement.setString(4, car.getYearOfManufacture());
                statement.setString(5, car.getRegistrationNumber());
                statement.setString(6, car.getNextService());
                statement.setInt(6, car.getCustomer_id());

                statement.executeUpdate();

                System.out.println("Car " + car.getModel() + " updated!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static Car getById(int id) {
        String db = "SELECT * FROM car WHERE id = ?";

        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return carData(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Car> getByCustomerId(int customerId) {
        String db = "SELECT * FROM car WHERE customer_id = ?";
        List<Car> cars = new ArrayList<>();
        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setCustomer_id(resultSet.getInt("customer_id"));
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setRegistrationNumber(resultSet.getString("registration_number"));
                car.setNextService(resultSet.getString("next_service"));
                car.setYearOfManufacture(resultSet.getString("manufacture_year"));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Car> getCars() {
        String db = "SELECT * FROM car";
        List<Car> cars = new ArrayList<>();
        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Car car = carData(resultSet);
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Car carData(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setCustomer_id(resultSet.getInt("customer_id"));
        car.setId(resultSet.getInt("id"));
        car.setBrand(resultSet.getString("brand"));
        car.setModel(resultSet.getString("model"));
        car.setRegistrationNumber(resultSet.getString("registration_number"));
        car.setNextService(resultSet.getString("next_service"));
        car.setYearOfManufacture(resultSet.getString("manufacture_year"));
        return car;
    }

    public static void deleteByCustomerId(int id) {
        String db = "DELETE FROM car WHERE customer_id = ?";
        if (id != 0) {
            try {
                List<Car> carList = getByCustomerId(id);
                if (carList != null) {
                    for (Car itt : carList) {
                        itt.setId(0);
                    }
                }

                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteById(int id) {
        String db = "DELETE FROM car WHERE id = ?";
        if (id != 0) {
            try {
                Car car = getById(id);
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setInt(1, id);
                statement.executeUpdate();
                car.setId(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
