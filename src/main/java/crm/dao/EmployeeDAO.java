package crm.dao;

import crm.db.DbUtil;
import crm.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static void add_update_Employee(Employee employee) {
        if (employee.getId() == 0) {
            String db = "INSERT INTO employee (name, surname, address, mobile_phone, note, man_hours_cost) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                String[] idColumn = {"ID"};
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db,idColumn);
                statement.setString(1, employee.getName());
                statement.setString(2, employee.getSurName());
                statement.setString(3, employee.getAddress());
                statement.setString(4, employee.getMobilePhone());
                statement.setString(5, employee.getNote());
                statement.setDouble(6, employee.getMan_hours_cost());
                statement.executeUpdate();

                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    employee.setId(resultSet.getInt(1));
                }

                System.out.println("Employee: " + employee.getName() + " " + employee.getSurName() + " added!");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String db = "UPDATE employee SET name = ?, surname = ?, address = ?, moblie_phone=?, note=?, man_hours_cost =?  WHERE id = ?";
            try {
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setString(1, employee.getName());
                statement.setString(2, employee.getSurName());
                statement.setString(3, employee.getAddress());
                statement.setString(4, employee.getMobilePhone());
                statement.setString(5, employee.getNote());
                statement.setDouble(6, employee.getMan_hours_cost());
                statement.setInt(7, employee.getId());
                statement.executeUpdate();

                System.out.println("Employee: " + employee.getName() + " " + employee.getSurName() + " updated!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Employee getEmployeeById(int id) {
        String db = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;
        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurName(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setMobilePhone(resultSet.getString("mobile_phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setMan_hours_cost(resultSet.getDouble("man_hours_cost"));
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getEmployees() {
        String db = "SELECT * FROM employee";
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurName(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setMobilePhone(resultSet.getString("mobile_phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setMan_hours_cost(resultSet.getDouble("man_hours_cost"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void deleteById(int id) {
        if (id != 0) {
            try {
                String db = "DELETE FROM employee WHERE id = ?";
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
