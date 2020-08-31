import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;

    public int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement stmt = getConexao()
                    .prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(stmt, atributos);

            if(stmt.executeUpdate() > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
        int index = 1;

        for (Object atributo: atributos){
            if(atributo instanceof String) {
                stmt.setString(index, (String) atributo);
            } else if(atributo instanceof Integer) {
                stmt.setInt(index, (Integer) atributo);
            }
            index++;
        }
    }

    private Connection getConexao() {
        try {
            if(conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexao = ConnectionFactory.getDBConnection();
        return conexao;
    }

    public void close() {
        try {
            getConexao().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao = null;
        }
    }
}
