package br.ufscar.dc.dsw.domain;

public class Usuario {
    
    private long id;
    private String email;
    private String senha;
    private String nome;
    private String papel;
    
    public Usuario(long id) {
        this.id = id;
    }

    public Usuario(String email, String senha, String nome, String papel) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.papel = papel;
    }

    public Usuario(long id, String email, String senha, String nome, String papel) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.papel = papel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

}
