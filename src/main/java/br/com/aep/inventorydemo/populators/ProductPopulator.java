package br.com.aep.inventorydemo.populators;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.model.ProductModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class ProductPopulator implements Populator<ProductModel, ProductData> {


    @Override
    public void populate(ProductModel productModel, ProductData productData) {

        if (Objects.isNull(productModel.getAtivo())){
            productModel.setAtivo(Boolean.TRUE);
        }
        if (Objects.isNull(productModel.getDataInsercao())) {
            productModel.setDataInsercao(new Date());
        }
        productModel.setDataInativacao(null);
        productModel.setDescricao(productData.getDescricao());
        productModel.setQuantidade(productData.getQuantidade());
        productModel.setNome(productData.getNome());
    }
}
