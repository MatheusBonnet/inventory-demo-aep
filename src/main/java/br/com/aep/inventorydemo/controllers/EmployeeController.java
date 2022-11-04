package br.com.aep.inventorydemo.controllers;

import br.com.aep.inventorydemo.model.EmployeeModel;
import br.com.aep.inventorydemo.model.Response;
import br.com.aep.inventorydemo.repository.IEmployeeRepository;
import br.com.aep.inventorydemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeModel>> findAll() {
        return ResponseEntity.ok(iEmployeeRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<EmployeeModel>> atualizarUser(@PathVariable("id") Long id, @RequestBody EmployeeModel user){
        Response<EmployeeModel> response = new Response<>();
        response.setData(this.employeeService.atualizarUsuario(user));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeModel>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(iEmployeeRepository.findById(id));
    }

    @PostMapping("/auth/singup")
    public ResponseEntity<Response<EmployeeModel>> salvar(@RequestBody EmployeeModel employeeModel) {
        Response<EmployeeModel> response = new Response<>();
        response.setData(this.employeeService.saveUserWithRoleDefault(employeeModel));
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/singup/admin")
    public ResponseEntity<Response<EmployeeModel>> savalrAdmin(@RequestBody EmployeeModel employeeModel) {
        Response<EmployeeModel> response = new Response<>();
        response.setData(this.employeeService.saveUserWithRoleAdmin(employeeModel));
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

}
