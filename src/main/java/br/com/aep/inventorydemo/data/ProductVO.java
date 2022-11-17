package br.com.aep.inventorydemo.data;

import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProviderModel;

import java.io.Serializable;
import java.util.Date;

public class ProductVO implements Serializable {

    private Long id;

    private String nome;

    private Integer quantidade;

    private String descricao;

    private String categoria;

    private String fornecedor;

    private Boolean ativo;

    private Date dataInsercao;

    private Date dataInativacao;

    public ProductVO() {
    }

    public ProductVO(Long id, String nome, Integer quantidade, String descricao, String categoria, String fornecedor, Boolean ativo, Date dataInsercao, Date dataInativacao) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.ativo = ativo;
        this.dataInsercao = dataInsercao;
        this.dataInativacao = dataInativacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }
}
