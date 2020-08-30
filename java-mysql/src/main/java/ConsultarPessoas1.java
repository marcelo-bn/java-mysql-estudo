import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

    public static void main(String[] args) {
        Connection conexao = ConnectionFactory.getDBConnection();

        String sql = "SELECT * FROM pessoa";

        PreparedStatement stmt = null;

        List<Pessoa> p = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                p.add(new Pessoa(codigo,nome));
            }

            for(Pessoa a: p) {
                System.out.println(a.getCodigo() + " ==> " + a.getNome());
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
