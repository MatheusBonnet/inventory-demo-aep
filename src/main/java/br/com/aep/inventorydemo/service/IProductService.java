package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.ProductModel;

public interface IProductService {

	
	public void inativarProduto(final Long id);
	
	public ProductModel buscaPorId(final Long id) throws ProductException;

	public ProductModel atualizarProduto(ProductModel productModel) throws ProductException;
	
	public ProductModel saveProduct(ProductModel productModel) throws ProductException;

}
