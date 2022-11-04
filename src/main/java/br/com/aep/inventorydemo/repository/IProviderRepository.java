package br.com.aep.inventorydemo.repository;

import br.com.aep.inventorydemo.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aep.inventorydemo.model.ProviderModel;

import java.util.List;

@Repository
public interface IProviderRepository extends JpaRepository<ProviderModel, Long>{

    @Query("SELECT u FROM ProviderModel u WHERE u.nome = :name")
    public ProviderModel findByName(@Param("name") String name);

    @Query("SELECT c.nome FROM ProviderModel c")
    public List<String> allByName();

}
