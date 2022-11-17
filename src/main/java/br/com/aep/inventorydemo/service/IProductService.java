package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.ProductModel;

import java.util.List;

public interface IProductService {

	
	public void inativarProduto(final Long id);
	
	public ProductData buscaPorId(final Long id) throws ProductException;

	public ProductData atualizarProduto(ProductData productData) throws ProductException;
	
	public ProductModel saveProduct(ProductData productData) throws ProductException;

	public List<ProductData> findStock();

	public List<ProductModel> allProductByProvider(String name);

	public List<ProductModel> allProductsByCategory(String name);

	public List<ProductData> findAll();

}
