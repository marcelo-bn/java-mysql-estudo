package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ConnectionFactory {

    private static Connection cnx;

    public static synchronized Connection getDBConnection() {

        Properties properties = new Properties();

        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "false");

        String host = "localhost";
        String port = "3306";
        String dbname = "curso_java";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbname;

        try {
            cnx = DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnx;

    }

}
