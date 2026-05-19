package service;

import dao.EmpresaDAO;
import model.Empresa;

import java.sql.SQLException;
import java.util.List;

public class EmpresaService {

    private final EmpresaDAO dao;

    public EmpresaService() {
        this.dao = new EmpresaDAO();
    }

    public Empresa insert(Empresa e) {

        try {
            return dao.insert(e);

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao inserir empresa: " + ex.getMessage(), ex
            );
        }
    }

    public Empresa update(String cnpjCpf, Empresa e) {

        try {

            e.setCnpjCpf(cnpjCpf);

            return dao.update(e);

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao atualizar empresa: " + ex.getMessage(), ex
            );
        }
    }

    public void remove(String cnpjCpf) {

        try {

            dao.remove(cnpjCpf);

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao remover empresa: " + ex.getMessage(), ex
            );
        }
    }

    public Empresa get(String cnpjCpf) {

        try {

            return dao.get(cnpjCpf)
                    .orElseThrow(() ->
                        new RuntimeException("Empresa não encontrada")
                    );

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao buscar empresa: " + ex.getMessage(), ex
            );
        }
    }

    public List<Empresa> listar() {

        try {

            return dao.listar();

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao listar empresas: " + ex.getMessage(), ex
            );
        }
    }

    public Empresa autenticar(String email, String senha) {

        try {

            return dao.autenticar(email, senha)
                    .orElseThrow(() ->
                        new RuntimeException("Email ou senha inválidos")
                    );

        } catch (SQLException ex) {

            throw new RuntimeException(
                "Erro ao autenticar empresa: " + ex.getMessage(), ex
            );
        }
    }
}