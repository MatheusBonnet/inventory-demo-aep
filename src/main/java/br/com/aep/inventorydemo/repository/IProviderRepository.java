package br.com.aep.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aep.inventorydemo.model.ProviderModel;

@Repository
public interface IProviderRepository extends JpaRepository<ProviderModel, Long>{

}
