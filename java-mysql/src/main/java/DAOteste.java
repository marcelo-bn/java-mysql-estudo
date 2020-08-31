public class DAOteste {

    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO pessoa (nome) VALUES (?)";
        dao.incluir(sql, "João");
        dao.incluir(sql, "Beth Cabral");
        dao.incluir(sql, "Maria Cunha");
    }
}
