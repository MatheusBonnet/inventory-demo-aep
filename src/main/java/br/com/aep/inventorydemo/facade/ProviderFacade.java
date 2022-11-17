package br.com.aep.inventorydemo.facade;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.data.ProviderData;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.populators.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderFacade {

    @Autowired
    private Populator<ProviderModel, ProviderData> populatorProvider;

    @Autowired
    private Populator<ProviderData, ProviderModel> providerReversePopulator;

    public ProviderModel atualizaProvider(ProviderModel model, ProviderData data){
        populatorProvider.populate(model , data);
        return model;
    }

    public ProviderData populaProviderData(ProviderData providerData, ProviderModel providerModel){
        providerReversePopulator.populate(providerData , providerModel);
        return providerData;
    }

    public Populator<ProviderModel, ProviderData> getPopulatorProvider() {
        return populatorProvider;
    }

    public void setPopulatorProvider(Populator<ProviderModel, ProviderData> populatorProvider) {
        this.populatorProvider = populatorProvider;
    }

    public Populator<ProviderData, ProviderModel> getProviderReversePopulator() {
        return providerReversePopulator;
    }

    public void setProviderReversePopulator(Populator<ProviderData, ProviderModel> providerReversePopulator) {
        this.providerReversePopulator = providerReversePopulator;
    }
}
