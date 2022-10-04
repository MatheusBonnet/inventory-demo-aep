package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void inativarProduto(Long id) {

        try {
            ProductModel productModel = buscaPorId(id);
            if(Objects.nonNull(productModel) && productModel.getAtivo() == Boolean.TRUE){
                productModel.setAtivo(false);
                productRepository.save(productModel);
            }
        }catch (ProductException e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ProductModel buscaPorId(Long id) throws ProductException {
        try {
            Optional<ProductModel> productModel = productRepository.findById(id);
            return productModel.get();
        }catch (ProductException e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ProductModel atualizarProduto(ProductModel productModel) throws ProductException {
        return null;
    }

    @Override
    public ProductModel saveProduct(ProductModel productModel) throws ProductException {
        try{

            if(Objects.nonNull(productModel)){
                productRepository.save(productModel);
            }

            return productModel;

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
