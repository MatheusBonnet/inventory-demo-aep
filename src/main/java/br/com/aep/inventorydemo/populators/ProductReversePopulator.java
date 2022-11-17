package br.com.aep.inventorydemo.populators;

import br.com.aep.inventorydemo.data.ProductVO;
import br.com.aep.inventorydemo.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductReversePopulator implements Populator<ProductVO, ProductModel> {


    @Override
    public void populate(ProductVO productVO, ProductModel productModel) {

        productVO.setId(productModel.getId());
        productVO.setAtivo(productModel.getAtivo());
        productVO.setDataInsercao(productModel.getDataInsercao());
        productVO.setDataInativacao(Objects.nonNull(productModel.getDataInativacao()) ? productModel.getDataInativacao() : null);
        productVO.setDescricao(productModel.getDescricao());
        productVO.setQuantidade(productModel.getQuantidade());
        productVO.setNome(productModel.getNome());
        productVO.setCategoria(productModel.getCategoryModel().getCategoryName());
        productVO.setFornecedor(productModel.getProviderModel().getNome());
    }
}
