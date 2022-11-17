package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.data.ProductVO;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.ProductModel;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductService {

	
	public void inativarProduto(final Long id);
	
	public ProductVO buscaPorId(final Long id) throws ProductException;

	public ProductModel atualizarProduto(ProductData productData) throws ProductException;
	
	public ProductModel saveProduct(ProductData productData) throws ProductException;

	public List<ProductModel> findStock();

	public List<ProductModel> allProductByProvider(String name);

	public List<ProductModel> allProductsByCategory(String name);

	public List<ProductVO> findAll();

}
