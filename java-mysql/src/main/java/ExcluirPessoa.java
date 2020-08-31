import db.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcluirPessoa {
    public static void main(String[] args) throws IOException {
        Connection cnx = ConnectionFactory.getDBConnection();
        String sql = "DELETE FROM pessoa WHERE codigo = ?";
        int id = 4;

        PreparedStatement stmt = null;

        try {
            stmt = cnx.prepareStatement(sql);
            stmt.setInt(1,id);

            int contador = stmt.executeUpdate();
            if(contador > 0) {
                System.out.println("Pessoa excluída com sucesso!");
                System.out.println("Linhas afetadas: "+contador);
            } else {
                System.out.println("Nada ocorreu...");
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
