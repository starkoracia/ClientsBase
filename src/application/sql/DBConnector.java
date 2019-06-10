package application.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "244268paparacia";
    private String urlDBConnection;

    protected Connection connection;

    public DBConnector(String dbName) {
        this.urlDBConnection =
                String.format("jdbc:mysql://localhost:3306/%s?serverTimezone=UTC",dbName);
    }

    protected void toConnect() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(urlDBConnection, DB_USER_NAME,DB_PASSWORD);
            System.out.println("Connection is CONNECT");
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR Connection is fail!!!");
        }
    }

    protected void closeConnect() {
        if(isConnect()) {
            try {
                connection.close();
                System.out.println("Connection is CLOSE");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected Connection getConnection() {
        if(isConnect()) {
            return connection;
        } else {
            return null;
        }
    }

   protected boolean isConnect() {
        if(connection == null) {
            return false;
        } else {
            try {
                if (connection.isClosed()) {
                    return false;
                } else {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
   }
}