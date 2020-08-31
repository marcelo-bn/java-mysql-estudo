package db;

import java.io.IOException;
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
        properties.setProperty("password", "marcelomac");
        properties.setProperty("useSSL", "false");

        /*Properties properties = getProperties();
        final String url = properties.getProperty("banco.url");
        final String usuario = properties.getProperty("banco.usuario");
        final String senha = properties.getProperty("banco.senha");*/

        String host = "localhost";
        String port = "3306";
        String dbname = "curso_java";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbname;

        try {
            cnx = DriverManager.getConnection(url, properties);
            //cnx = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnx;

    }


    /*private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String path = "/java-mysql-estudo/java-mysql/src/conexao.properties";
        prop.load(ConnectionFactory.class.getResourceAsStream(path));
        return prop;

    }*/

}
