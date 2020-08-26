import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        Connection conexao = ConnectionFactory.getDBConnection();

        String sql = "DELETE FROM cursos WHERE idcurso = 10";

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






