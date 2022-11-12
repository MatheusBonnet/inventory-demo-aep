package br.com.aep.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aep.inventorydemo.model.ProductModel;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Long>{

    @Query("SELECT p FROM ProductModel p JOIN p.providerModel c WHERE c.nome = :name")
    public List<ProductModel> allProductByProvider(@Param("name") String name);

    @Query("SELECT p FROM ProductModel p JOIN p.categoryModel c WHERE c.categoryName = :name")
    public List<ProductModel> allProductsByCategory(@Param("name") String name);

}
