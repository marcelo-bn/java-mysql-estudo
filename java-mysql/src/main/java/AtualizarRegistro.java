import db.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarRegistro {

    public static void main(String[] args) throws IOException {
        Connection conexao = ConnectionFactory.getDBConnection();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o id da pessoa: ");
        int id = teclado.nextInt();

        String sql = "SELECT codigo, nome FROM pessoa WHERE codigo = ?";

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();


            if(rs.next()) {
                Pessoa p = new Pessoa(rs.getInt(1),rs.getString(2));
                System.out.println("Nome atual: " + p.getNome());
                teclado.nextLine();
                System.out.println("Informe o novo nome da pessoa: ");
                String novo_nome = teclado.nextLine();

                String sql2 = "UPDATE pessoa SET nome = ? WHERE codigo = ?";

                stmt.close();

                stmt = conexao.prepareStatement(sql2);
                stmt.setString(1,novo_nome);
                stmt.setInt(2,id);
                stmt.executeUpdate();

                System.out.println("Nome alterado com sucesso!");


            } else {
                System.out.println("Pessoa não encontrada!");
            }


            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        teclado.close();
        

    }
}
