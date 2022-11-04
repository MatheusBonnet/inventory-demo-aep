package br.com.aep.inventorydemo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_product")
public class ProductModel {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	private String nome;
	
	private int quantidade;
	
	private String descricao;

	private Boolean ativo;
	
	private Date dataInsercao;
	
	private Date dataInativacao;
	
	@OneToOne
	private CategoryModel categoryModel;
	
	@OneToOne
	private ProviderModel providerModel;
	
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}

	public ProductModel(Long id, String nome, int quantidade, String descricao, Boolean ativo, Date dataInsercao,
						Date dataInativacao, CategoryModel categoryModel, ProviderModel providerModel) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.ativo = ativo;
		this.dataInsercao = dataInsercao;
		this.dataInativacao = dataInativacao;
		this.categoryModel = categoryModel;
		this.providerModel = providerModel;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public ProviderModel getProviderModel() {
		return providerModel;
	}

	public void setProviderModel(ProviderModel providerModel) {
		this.providerModel = providerModel;
	}
	
	

}
