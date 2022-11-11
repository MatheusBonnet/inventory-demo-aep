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

    public ProviderModel atualizaProduto(ProviderModel model, ProviderData data){
        populatorProvider.populate(model , data);
        return model;
    }

    public Populator<ProviderModel, ProviderData> getPopulatorProvider() {
        return populatorProvider;
    }

    public void setPopulatorProvider(Populator<ProviderModel, ProviderData> populatorProvider) {
        this.populatorProvider = populatorProvider;
    }
}
