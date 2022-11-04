package br.com.aep.inventorydemo.repository;

import br.com.aep.inventorydemo.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long>{

    @Query("SELECT c FROM CategoryModel c WHERE c.categoryName = :name")
    public CategoryModel findByName(@Param("name") String name);

    @Query("SELECT c.categoryName FROM CategoryModel c")
    public List<String> allByName();

}
