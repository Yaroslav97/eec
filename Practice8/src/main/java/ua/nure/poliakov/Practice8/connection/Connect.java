package ua.nure.poliakov.Practice8.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final String URL = "jdbc:mysql://localhost:3306/practicedb?user=root&password=pass&autoReconnect=true&useSSL=false";

    private Connection connection;

    public Connect() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}