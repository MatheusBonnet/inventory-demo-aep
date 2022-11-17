package br.com.aep.inventorydemo.facade;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.populators.Populator;
import br.com.aep.inventorydemo.populators.ProductReversePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFacade {

    @Autowired
    private Populator<ProductModel, ProductData> productModelPopulator;

    @Autowired
    private Populator<ProductData, ProductModel> productReversePopulator;

    public ProductFacade(Populator<ProductModel, ProductData> productModelPopulator, ProductReversePopulator productReversePopulator) {
        this.productModelPopulator = productModelPopulator;
        this.productReversePopulator =productReversePopulator;
    }

    public ProductModel saveItem(ProductData productData, CategoryModel categoryModel, ProviderModel providerModel) {
        ProductModel productModel = new ProductModel();
        productModelPopulator.populate(productModel , productData);
        productModel.setProviderModel(providerModel);
        productModel.setCategoryModel(categoryModel);
        return productModel;
    }

    public ProductModel atualizaProduto(ProductModel productModel, ProductData productData){
        productModelPopulator.populate(productModel , productData);
        return productModel;
    }

    public ProductData populaData(ProductData productData, ProductModel productModel){
        productReversePopulator.populate(productData , productModel);
        return productData;
    }

    public Populator<ProductModel, ProductData> getProductModelPopulator() {
        return productModelPopulator;
    }

    public void setProductModelPopulator(Populator<ProductModel, ProductData> productModelPopulator) {
        this.productModelPopulator = productModelPopulator;
    }

    public Populator<ProductData, ProductModel> getProductReversePopulator() {
        return productReversePopulator;
    }

    public void setProductReversePopulator(Populator<ProductData, ProductModel> productReversePopulator) {
        this.productReversePopulator = productReversePopulator;
    }
}
