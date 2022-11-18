package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.data.ProviderData;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.exception.ProviderException;
import br.com.aep.inventorydemo.facade.ProviderFacade;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.repository.ICategoryRepository;
import br.com.aep.inventorydemo.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    private IProviderRepository iProviderRepository;

    @Autowired
    private ProviderFacade providerFacade;

    @Override
    public void excluiProvider(Long id) {
        try {
            ProviderModel providerModel = iProviderRepository.findById(id).get();
            if (Objects.nonNull(providerModel) && providerModel.getAtivo() == Boolean.TRUE) {
                providerModel.setAtivo(Boolean.FALSE);
                iProviderRepository.save(providerModel);
            }

        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR, e.getMessage());
        }
    }

    @Override
    public ProviderData buscaPorId(Long id) {
        try {
            ProviderModel providerModel = iProviderRepository.findById(id).get();

            return Objects.nonNull(providerModel) ? providerFacade.populaProviderData(new ProviderData(), providerModel) : null;

        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ProviderData atualizarProvider(ProviderData providerData) throws ProviderException {
        try {
            ProviderModel providerModel = iProviderRepository.findById(providerData.getId()).get();
            providerFacade.atualizaProvider(providerModel, providerData);
            iProviderRepository.save(providerModel);
            return providerFacade.populaProviderData(providerData, providerModel);
        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, e.getMessage());
        }


    }

    @Override
    public ProviderModel saveProvider(ProviderModel providerModel) throws ProviderException {
        try {
            {
                providerModel.setAtivo(Boolean.TRUE);
                this.iProviderRepository.save(providerModel);
            }
            return providerModel;

        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, e.getMessage());
        }
    }

    @Override
    public ProviderData buscaPorNome(String nome) {
        try {
            ProviderModel providerModel = iProviderRepository.findByName(nome);
            return Objects.nonNull(providerModel) ? providerFacade.populaProviderData(new ProviderData(), providerModel) : null;

        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public List<String> allByname() {
        try {
            List<String> providerNames = iProviderRepository.allByName();
            return Objects.nonNull(providerNames) ? providerNames : new ArrayList<>();

        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public List<ProviderData> findAll() {
        try {
            List<ProviderModel> providerModels = iProviderRepository.findAll();
            List<ProviderData> providerDataList = new ArrayList<>();
            for(ProviderModel providerModel: providerModels){
                if(providerModel.getAtivo() == Boolean.TRUE) {
                    providerDataList.add(providerFacade.populaProviderData(new ProviderData(), providerModel));
                }
            }

            return CollectionUtils.isEmpty(providerDataList) ?  new ArrayList<>() : providerDataList;

        } catch (ProviderException e) {
            throw new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }


    }
}
