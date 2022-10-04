package br.com.aep.inventorydemo.model;

import org.springframework.security.core.GrantedAuthority;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name = "tb_roles")
public class RoleModel implements GrantedAuthority {


    private static final long serialVersionUID = 1L;

	@Id
    private String nomeRole;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<EmployeeModel> employeeModels;


    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public List<EmployeeModel> getUsers() {
        return employeeModels;
    }

    public void setUsers(List<EmployeeModel> users) {
        this.employeeModels = users;
    }

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}
