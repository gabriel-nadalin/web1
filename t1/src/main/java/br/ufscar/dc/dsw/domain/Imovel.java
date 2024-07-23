package br.ufscar.dc.dsw.domain;

public class Imovel {

    private long id;
    private Imobiliaria imobiliaria;
    private String endereco;
    private String cidade;
    private String descricao;
    private Float valor;
    
    public Imovel(long id) {
        this.id = id;
    }

    public Imovel(Imobiliaria imobiliaria, String endereco, String cidade, String descricao, Float valor) {
        this.imobiliaria = imobiliaria;
        this.endereco = endereco;
        this.cidade = cidade;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Imovel(long id, Imobiliaria imobiliaria, String endereco, String cidade, String descricao, Float valor) {
        this.id = id;
        this.imobiliaria = imobiliaria;
        this.endereco = endereco;
        this.cidade = cidade;
        this.descricao = descricao;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    public void setImobiliaria(Imobiliaria imobiliaria) {
        this.imobiliaria = imobiliaria;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
}
