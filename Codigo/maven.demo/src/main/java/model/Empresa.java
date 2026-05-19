package model;

public class Empresa {

    private String nome;
    private String cnpjCpf;
    private String email;
    private String senha;

    public Empresa() {
    }

    public Empresa(String nome, String cnpjCpf, String email, String senha) {
        this.nome = nome;
        this.cnpjCpf = cnpjCpf;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}