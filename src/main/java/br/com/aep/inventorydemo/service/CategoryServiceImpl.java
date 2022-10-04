package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void excluiCategoria(Long id) {
        try {
            CategoryModel categoryModel = buscaPorId(id);
            if(Objects.nonNull(categoryModel)){
                categoryRepository.delete(categoryModel);
            }

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CategoryModel buscaPorId(Long id) throws ProductException {
        try {
            Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
            if(Objects.nonNull(categoryModel)){
                return categoryModel.get();
            }

            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public CategoryModel atualizarCategory(CategoryModel categoryModel) throws CategoryException {
        try {
            Optional<CategoryModel> category = categoryRepository.findById(categoryModel.getId());
            if(Objects.nonNull(category)){
               category.get().setCategoryName(categoryModel.getCategoryName());
               categoryRepository.save(category.get());
            }

            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CategoryModel saveCategory(CategoryModel categoryModel) throws CategoryException {
        try{
            {
                this.categoryRepository.save(categoryModel);
            }
            return categoryModel;

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
