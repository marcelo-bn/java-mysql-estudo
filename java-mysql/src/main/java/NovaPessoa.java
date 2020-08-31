import db.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe um nome:");
        String nome = teclado.nextLine();

        String sql = "INSERT INTO pessoa (nome) VALUES (?)";

        Connection conexao = ConnectionFactory.getDBConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome); // Não considera como comando SQL!!
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        teclado.close();
    }
}
