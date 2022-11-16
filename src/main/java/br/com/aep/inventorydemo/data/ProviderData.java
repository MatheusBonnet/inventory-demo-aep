package br.com.aep.inventorydemo.data;

import java.io.Serializable;

public class ProviderData implements Serializable {

    private Long id;

    private String nome;

    private String empresa;

    private String contato;

    private String cnpj;

    private String endereco;

    private String email;

    public ProviderData() {
    }

    public ProviderData(Long id, String nome, String empresa, String contato, String cnpj, String endereco, String email) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.contato = contato;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
