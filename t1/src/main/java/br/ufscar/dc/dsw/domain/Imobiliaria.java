package br.ufscar.dc.dsw.domain;

public class Imobiliaria extends Usuario {
    
    private String cnpj;
    private String descricao;
    
    public Imobiliaria(long id) {
        super(id);
    }

    public Imobiliaria(String email, String senha, String cnpj, String nome, String descricao) {
        super(email, senha, nome, "imobiliaria");
        this.cnpj = cnpj;
        this.descricao = descricao;
    }

    public Imobiliaria(long id, String email, String senha, String cnpj, String nome, String descricao) {
        super(id, email, senha, nome, "imobiliaria");
        this.cnpj = cnpj;
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
