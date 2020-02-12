package crm.dao;

import crm.db.DbUtil;
import crm.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public static void add_update_Customer(Customer customer) {

        if(customer.getId() == 0) {

            try {
                String db = "INSERT INTO customer (name, surname, birth_day) VALUES (?, ?, ?)";
                String [] idColumn = {"id"};
                Connection connection = DbUtil.setConnection();

                PreparedStatement statement = connection.prepareStatement(db, idColumn);
                statement.setString(1, customer.getName());
                statement.setString(2, customer.getSurName());
                statement.setString(3, customer.getDateOfBirth().toString());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if(resultSet.next()){
                    customer.setId(resultSet.getInt(1));
                }

                System.out.println("New customer: " + customer.getName() + " " + customer.getSurName() + " was added!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {

            String db = "UPDATE customer SET name = ?, surname = ?, birth_day = ? WHERE id = ?";
            try {
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setString(1, customer.getName());
                statement.setString(2, customer.getSurName());
                statement.setString(3, customer.getDateOfBirth().toString());
                statement.setInt(4, customer.getId());
                statement.executeUpdate();

                System.out.println("Customer: " + customer.getName() + " " + customer.getSurName() + " updated!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Customer> getCustomers() {
        String db = "SELECT * FROM customer";
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setName(resultSet.getString("name"));                     // ?????
                customer.setSurName(resultSet.getString("surName"));
                customer.setDateOfBirth(resultSet.getString("birth_day"));
                customer.setId(resultSet.getInt("id"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    /*public static void delete(Customer customer) {
        String db = "DELETE FROM customer WHERE id = ?";

        if (customer != null && getCustomerById(customer.getId()) != null) {
            try {
                Connection connection = DbUtil.setConnection();
                PreparedStatement statement = connection.prepareStatement(db);
                statement.setInt(1, customer.getId());
                statement.executeUpdate();

                System.out.println("New customer: " + customer.getName() + " " + customer.getSurName() + " deleted!");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Customer does not exist!");
        }
    }*/

    public static Customer getCustomerById(int id) {
        String db = "SELECT * FROM customer WHERE id = ?";

        try {
            Connection connection = DbUtil.setConnection();
            PreparedStatement statement = connection.prepareStatement(db);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {                                     //????
                Customer customer = new Customer();
                customer.setName(resultSet.getString("name"));
                customer.setSurName(resultSet.getString("surname"));
                customer.setDateOfBirth(resultSet.getString("birth_day"));
                customer.setId(resultSet.getInt("id"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteById(int id) {
        String db = "DELETE FROM customer WHERE id = ?";
        if (id != 0) {
            try {
                CarDAO.deleteByCustomerId(id);

                Customer customer = getCustomerById(id);
                customer.setId(0);

                Connection connection = DbUtil.setConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(db);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Customer does not exist!");
        }

    }

}
