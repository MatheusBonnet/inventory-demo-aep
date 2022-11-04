package br.com.aep.inventorydemo.repository;

import br.com.aep.inventorydemo.model.EmployeeModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleModel, Long> {

    @Query("SELECT u FROM RoleModel u WHERE u.id = :id")
    public RoleModel findRole(@Param("id") Long id);

}
