import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CriarTabelaPessoas {

    public static void main(String[] args) {

        Connection conexao = ConnectionFactory.getDBConnection();

        String sql = "CREATE TABLE IF NOT EXISTS pessoa (" +
                "codigo INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(80) NOT NULL" +
                ")";

        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }








    }
}






