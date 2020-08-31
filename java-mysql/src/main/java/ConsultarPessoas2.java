import db.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws IOException {
        Connection conexao = ConnectionFactory.getDBConnection();

        String sql = "SELECT * FROM pessoa WHERE nome like ?";

        PreparedStatement stmt = null;
        List<Pessoa> p = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome da pesquisa: ");
        String valor = teclado.nextLine();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + valor + "%");
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

        teclado.close();

    }


}
