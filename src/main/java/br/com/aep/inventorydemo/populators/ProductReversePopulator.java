package br.com.aep.inventorydemo.populators;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductReversePopulator implements Populator<ProductData, ProductModel> {


    @Override
    public void populate(ProductData productData, ProductModel productModel) {

        productData.setId(productModel.getId());
        productData.setAtivo(productModel.getAtivo());
        productData.setDataInsercao(productModel.getDataInsercao());
        productData.setDataInativacao(Objects.nonNull(productModel.getDataInativacao()) ? productModel.getDataInativacao() : null);
        productData.setDescricao(productModel.getDescricao());
        productData.setQuantidade(productModel.getQuantidade());
        productData.setNome(productModel.getNome());
        productData.setCategoria(productModel.getCategoryModel().getCategoryName());
        productData.setFornecedor(productModel.getProviderModel().getNome());
    }
}
