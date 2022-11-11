package br.com.aep.inventorydemo.populators;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.data.ProviderData;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class ProviderPopulator implements Populator<ProviderModel, ProviderData> {


    @Override
    public void populate(ProviderModel providerModel, ProviderData providerData) {

        providerModel.setNome(providerData.getNome());
        providerModel.setCnpj(providerData.getCnpj());
        providerModel.setContato(providerData.getContato());
        providerModel.setEmpresa(providerData.getEmpresa());
        providerModel.setEmail(providerData.getEmail());
        providerModel.setEndereco(providerData.getEndereco());
    }
}
