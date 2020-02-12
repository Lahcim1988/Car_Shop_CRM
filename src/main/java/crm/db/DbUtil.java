package crm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static crm.db.ConnEnum.DB_NAME;
import static crm.db.ConnEnum.USER;
import static crm.db.ConnEnum.PASSWORD;

public class DbUtil {

    public static Connection setConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                            + DB_NAME + "?useSSL=false",
                    USER,
                    PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}
