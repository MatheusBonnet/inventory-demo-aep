package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.exception.CategoryException;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.exception.ProviderException;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.repository.ICategoryRepository;
import br.com.aep.inventorydemo.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements IProviderService{

    @Autowired
    private IProviderRepository iProviderRepository;

    @Override
    public void excluiProvider(Long id) {
        try {
            ProviderModel providerModel = buscaPorId(id);
            if(Objects.nonNull(providerModel)){
                iProviderRepository.delete(providerModel);
            }

        }catch (ProviderException e){
            throw  new ProviderException(InventoryDemoConstants.MESSAGE_ERROR, e.getMessage());
        }
    }

    @Override
    public ProviderModel buscaPorId(Long id){
        try {
            Optional<ProviderModel> providerModel = iProviderRepository.findById(id);
            return Objects.nonNull(providerModel) ? providerModel.get() : null;

        }catch (ProviderException e){
            throw  new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ProviderModel atualizarProvider(ProviderModel ProviderModel) throws ProviderException {
       return null;
    }

    @Override
    public ProviderModel saveProvider(ProviderModel ProviderModel) throws ProviderException {
        try{
            {
                this.iProviderRepository.save(ProviderModel);
            }
            return ProviderModel;

        }catch (ProviderException e){
            throw  new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_REGISTER, e.getMessage());
        }
    }

    @Override
    public ProviderModel buscaPorNome(String nome){
        try {
           ProviderModel providerModel = iProviderRepository.findByName(nome);
           return Objects.nonNull(providerModel) ? providerModel : null;

        }catch (ProviderException e){
            throw  new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public List<String> allByname(){
        try {
            List<String> providerNames = iProviderRepository.allByName();
            return Objects.nonNull(providerNames) ? providerNames : new ArrayList<>();

        }catch (ProviderException e){
            throw  new ProviderException(InventoryDemoConstants.MESSAGE_ERROR_NOT_FOUND, e.getMessage());
        }
    }


}
