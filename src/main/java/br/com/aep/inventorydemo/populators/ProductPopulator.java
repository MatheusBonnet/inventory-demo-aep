package br.com.aep.inventorydemo.populators;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductPopulator implements Populator<ProductModel, ProductData> {


    @Override
    public void populate(ProductModel productModel, ProductData productData) {
        productModel.setAtivo(true);
        productModel.setDataInsercao(new Date());
        productModel.setDataInativacao(null);
        productModel.setDescricao(productData.getDescricao());
        productModel.setQuantidade(productData.getQuantidade());
        productModel.setNome(productData.getNome());
    }
}
