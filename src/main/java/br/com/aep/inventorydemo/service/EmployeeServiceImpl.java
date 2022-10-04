package br.com.aep.inventorydemo.service;

import br.com.aep.inventorydemo.exception.EmployeeException;
import br.com.aep.inventorydemo.model.EmployeeModel;
import br.com.aep.inventorydemo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Objects;
import java.util.Optional;


@Service
@Component
public class EmployeeServiceImpl implements IEmployeeService,UserDetailsService {

	public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";
	
	public static final String MESSAGE_ERROR_USER_NOT_FOUND = "Usuario nao encontrado, tente novamente.";
	
	public static final String MESSAGE_ERROR_REGISTER_USER = "Erro ao salvar, tente novamente!";

	public static final String ADMIN_ROLE = "ADMIN";

	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		EmployeeModel employee = employeeRepository.findByCpf(cpf);

		if(employee == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new org.springframework.security.core.userdetails.User(employee.getCpf(), employee.getPassword(),
				true, true, true, true, employee.getAuthorities());
	}


	@Override
	public EmployeeModel deletar(Long id) {
		try {
			EmployeeModel employee = this.buscaPorId(id);
			this.employeeRepository.deleteById(employee.getId());
			return null;
						
		}catch (EmployeeException m) {
			throw new EmployeeException(MESSAGE_ERROR_USER_NOT_FOUND,HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public EmployeeModel buscaPorId(Long id) {
		try {
			Optional<EmployeeModel> employee = this.employeeRepository.findById(id);
			if (employee.isPresent()) {
				return employee.get();
			}
			throw new EmployeeException(MESSAGE_ERROR_USER_NOT_FOUND, HttpStatus.NOT_FOUND);
			
		} catch (EmployeeException m) {
			throw new EmployeeException(MESSAGE_ERROR_USER_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public EmployeeModel atualizarUsuario(EmployeeModel user) throws EmployeeException {
		try {
			EmployeeModel employee = this.buscaPorId(user.getId());
			if(!Objects.nonNull(employee)) {
				employee.setCpf(user.getCpf());
				employee.setEmail(user.getEmail());
				employee.setNome(user.getNome());
				employee.setSobrenome(user.getSobrenome());
				employee.setRoles(user.getRoles());
				employeeRepository.save(employee);
			}
			
			return employee;
			
		} catch (EmployeeException m) {
			throw new EmployeeException(MESSAGE_ERROR_USER_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public EmployeeModel saveUser(EmployeeModel user) throws EmployeeException {
		try{
			{
				user.setSenha(passwordEncoder.encode(user.getSenha()));
				this.employeeRepository.save(user);
			}

			return user;

		}catch (EmployeeException e){
			throw  new EmployeeException(MESSAGE_ERROR_REGISTER_USER, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw  new EmployeeException(MESSAGE_ERROR_REGISTER_USER, HttpStatus.FORBIDDEN);
		}

	}


	@Override
	public EmployeeModel findAuth() throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		EmployeeModel user = this.employeeRepository.findByCpf(auth.getName());
		
		if(user == null) {
			throw new Exception();
		}
		
		return user;
	}
	
	

	
}