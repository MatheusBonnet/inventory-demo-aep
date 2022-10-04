package br.com.aep.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long>{

}
