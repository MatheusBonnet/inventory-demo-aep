package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.exception.EmployeeException;
import br.com.aep.inventorydemo.model.EmployeeModel;

public interface IEmployeeService {

	
	public void deletar(final Long cpf );
	
	public EmployeeModel buscaPorId(final Long cpf);

	public EmployeeModel atualizarUsuario(EmployeeModel user) throws EmployeeException;
	
	public EmployeeModel saveUserWithRoleDefault(EmployeeModel user) throws EmployeeException;

	public EmployeeModel findAuth() throws Exception;

	public EmployeeModel saveUserWithRoleAdmin(EmployeeModel user);

}
