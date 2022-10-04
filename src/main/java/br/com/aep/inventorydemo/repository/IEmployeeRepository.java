package br.com.aep.inventorydemo.repository;

import br.com.aep.inventorydemo.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long>{

	public EmployeeModel findByCpf(String cpf);

	@Query("SELECT u FROM EmployeeModel u WHERE u.email = :email")
	public Optional<EmployeeModel> findByEmail(@Param("email")String email);

}
