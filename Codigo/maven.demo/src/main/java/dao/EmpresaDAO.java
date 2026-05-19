package dao;

import model.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpresaDAO extends DAO {

    public Empresa insert(Empresa e) throws SQLException {

        String sql = "INSERT INTO empresa (nome, cnpj_cpf, email, senha) VALUES (?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getCnpjCpf());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getSenha());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Nome: " + e.getNome());
                System.out.println("CNPJ/CPF: " + e.getCnpjCpf());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Senha: " + e.getSenha());
            }

            return e;
        }
    }

    public Empresa update(Empresa e) throws SQLException {

        String sql = "UPDATE empresa SET nome=?, email=?, senha=? WHERE cnpj_cpf=?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getEmail());
            stmt.setString(3, e.getSenha());
            stmt.setString(4, e.getCnpjCpf());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Nome: " + e.getNome());
                System.out.println("CNPJ/CPF: " + e.getCnpjCpf());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Senha: " + e.getSenha());
            }

            return e;
        }
    }

    public void remove(String cnpjCpf) throws SQLException {

        String sql = "DELETE FROM empresa WHERE cnpj_cpf=?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpjCpf);

            stmt.executeUpdate();
        }
    }

    public Optional<Empresa> get(String cnpjCpf) throws SQLException {

        String sql = "SELECT * FROM empresa WHERE cnpj_cpf=?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpjCpf);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(mapEmpresa(rs));
            }
        }

        return Optional.empty();
    }

    public List<Empresa> listar() throws SQLException {

        List<Empresa> lista = new ArrayList<>();

        String sql = "SELECT * FROM empresa ORDER BY nome ASC";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapEmpresa(rs));
            }
        }

        return lista;
    }

    public Optional<Empresa> autenticar(String email, String senha) throws SQLException {

        String sql = "SELECT * FROM empresa WHERE email=?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                if (senha.equals(rs.getString("senha"))) {

                    Empresa e = mapEmpresa(rs);

                    return Optional.of(e);
                }
            }
        }

        return Optional.empty();
    }

    private Empresa mapEmpresa(ResultSet rs) throws SQLException {

        Empresa e = new Empresa();

        e.setNome(rs.getString("nome"));
        e.setCnpjCpf(rs.getString("cnpj_cpf"));
        e.setEmail(rs.getString("email"));
        e.setSenha(rs.getString("senha"));

        return e;
    }
}