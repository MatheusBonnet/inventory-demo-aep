package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.exception.ProviderException;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;

import java.util.List;

public interface IProviderService {

    public void excluiProvider(final Long id);

    public ProviderModel buscaPorId(final Long id) throws ProviderException;

    public ProviderModel atualizarProvider(ProviderModel providerModel) throws ProviderException;

    public ProviderModel saveProvider(ProviderModel providerModel) throws ProviderException;

    public ProviderModel buscaPorNome(String nome);

    public List<String> allByname();
}
