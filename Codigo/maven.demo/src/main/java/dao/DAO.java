package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    //arrumar a url do banco de dados
    private static final String URL = "jdbc:postgresql://localhost/financenote";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Pucminas$";

    public DAO() {
    }

    /**
     * Estabelece a conexão com o banco de dados PostgreSQL.
     *
     * @return uma instância de {@link Connection} se a conexão for bem-sucedida.
     * @throws SQLException se ocorrer algum erro ao conectar.
     */
    protected Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Fecha a conexão com o banco de dados, caso ela não seja nula.
     *
     * @param conn a conexão a ser fechada.
     * @throws RuntimeException se ocorrer erro ao fechar a conexão.
     */
    protected void fecharConexao(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
            }
        }
    }
}
