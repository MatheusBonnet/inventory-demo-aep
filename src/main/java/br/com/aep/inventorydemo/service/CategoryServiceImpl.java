package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.data.CategoryData;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR, e.getMessages());
        }
    }

    @Override
    public CategoryModel buscaPorId(Long id){
        try {
            Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
            return Objects.nonNull(categoryModel) ? categoryModel.get() : null;

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessages());
        }
    }

    @Override
    public CategoryModel atualizarCategory(CategoryData categoryData) throws CategoryException {
        try {
            Optional<CategoryModel> category = categoryRepository.findById(categoryData.getId());
            if(Objects.nonNull(category)){
               category.get().setCategoryName(categoryData.getCategoryName());
               categoryRepository.save(category.get());
            }

            return category.get();

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR,  e.getMessages());
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
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, e.getMessages());
        }
    }

    @Override
    public CategoryModel buscaPorNome(String nome){
        try {
           CategoryModel categoryModel = categoryRepository.findByName(nome);
           return Objects.nonNull(categoryModel) ? categoryModel : null;

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessages());
        }
    }

    @Override
    public List<String> allByname(){
        try {
            List<String> categoryNames = categoryRepository.allByName();
            return Objects.nonNull(categoryNames) ? categoryNames : null;

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessages());
        }
    }


}
