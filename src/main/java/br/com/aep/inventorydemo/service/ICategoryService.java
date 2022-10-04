package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;

public interface ICategoryService {

	
	public void excluiCategoria(final Long id);
	
	public CategoryModel buscaPorId(final Long id) throws ProductException;

	public CategoryModel atualizarCategory(CategoryModel categoryModel) throws CategoryException;
	
	public CategoryModel saveCategory(CategoryModel categoryModel) throws CategoryException;

}