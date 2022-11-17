package br.com.aep.inventorydemo.populators;

import br.com.aep.inventorydemo.data.ProviderData;
import br.com.aep.inventorydemo.model.ProviderModel;
import org.springframework.stereotype.Service;

@Service
public class ProviderReversePopulator implements Populator<ProviderData, ProviderModel> {


    @Override
    public void populate(ProviderData providerData, ProviderModel providerModel) {

        providerData.setId(providerModel.getId());
        providerData.setNome(providerModel.getNome());
        providerData.setCnpj(providerModel.getCnpj());
        providerData.setContato(providerModel.getContato());
        providerData.setEmpresa(providerModel.getEmpresa());
        providerData.setEmail(providerModel.getEmail());
        providerData.setEndereco(providerModel.getEndereco());
    }
}
