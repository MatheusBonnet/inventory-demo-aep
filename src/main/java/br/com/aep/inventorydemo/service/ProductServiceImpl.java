package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.facade.ProductFacade;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.repository.IProductRepository;
import br.com.aep.inventorydemo.repository.IProviderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IProviderRepository iProviderRepository;

    @Autowired
    private ProductFacade productFacade;


    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(IProductRepository productRepository, ICategoryService iCategoryService, IProviderRepository iProviderRepository, ProductFacade productFacade) {
        this.productRepository = productRepository;
        this.iCategoryService = iCategoryService;
        this.iProviderRepository = iProviderRepository;
        this.productFacade = productFacade;
    }

    @Override
    public void inativarProduto(Long id) {

        try {
            ProductModel productModel = buscaPorId(id);
            if(Objects.nonNull(productModel) && productModel.getAtivo() == Boolean.TRUE){
                productModel.setAtivo(Boolean.FALSE);
                productRepository.save(productModel);
            }
            
        }catch (ProductException e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }

    }

    @Override
    public ProductModel buscaPorId(Long id) throws ProductException {
        try {
            Optional<ProductModel> productModel = productRepository.findById(id);
            return productModel.get();
        }catch (ProductException e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ProductModel atualizarProduto(Long id, ProductData productData) throws ProductException {
        try{

            ProductModel productModel = this.buscaPorId(id);

            if(Objects.nonNull(productData)) {
                CategoryModel categoryModel = iCategoryService.buscaPorNome(productData.getCategoria());
                ProviderModel providerModel = iProviderRepository.findByName(productData.getFornecedor());
                if(productModel.getCategoryModel() != categoryModel){
                    productModel.setCategoryModel(categoryModel);
                }
                if(productModel.getProviderModel() != providerModel){
                    productModel.setProviderModel(providerModel);
                }

                productRepository.save(productFacade.atualizaProduto(productModel, productData));
            }

            return productModel;

        }catch (ProductException e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, e.getMessage());
        }
    }

    @Override
    public ProductModel saveProduct(ProductData productData) throws ProductException {
        try{

            ProductModel productModel = null;

            if(Objects.nonNull(productData)) {
                CategoryModel categoryModel = iCategoryService.buscaPorNome(productData.getCategoria());
                ProviderModel providerModel = iProviderRepository.findByName(productData.getFornecedor());
                productModel = productFacade.saveItem(productData,categoryModel,providerModel);
                productRepository.save(productModel);
            }

            return productModel;

        }catch (CategoryException e){
            throw  new CategoryException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, e.getMessage());
        }
    }

    @Override
    public List<ProductModel> findStock() {
        List<ProductModel> withoutStock = new ArrayList<>();
        List<ProductModel> productModelList = productRepository.findAll();
        for(ProductModel productModel : productModelList){
            if (Objects.nonNull(productModel) && productModel.getQuantidade() <= 100)
                withoutStock.add(productModel);
        }

        return withoutStock;

    }

    @Override
    public List<ProductModel> allProductByProvider(String name) {
        try {
            List<ProductModel> productModelList = productRepository.allProductByProvider(name);
            if(CollectionUtils.isEmpty(productModelList)){
                throw  new Exception(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND);
            }

            return productModelList;

        }catch (Exception e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR, e.getMessage());
        }
    }

    @Override
    public List<ProductModel> allProductsByCategory(String name) {
        try {
            List<ProductModel> productModelList = productRepository.allProductsByCategory(name);
            if(CollectionUtils.isEmpty(productModelList)){
                throw new Exception(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND);
            }

            return productModelList;

        }catch (Exception e){
            throw  new ProductException(InventoryDemoConstants.MESSAGE_ERROR, e.getMessage());
        }
    }
}
