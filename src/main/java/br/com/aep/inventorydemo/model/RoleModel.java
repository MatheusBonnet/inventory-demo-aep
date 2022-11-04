package br.com.aep.inventorydemo.model;

import org.springframework.security.core.GrantedAuthority;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_roles")
public class RoleModel implements GrantedAuthority {


    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRole;

    public RoleModel() {
    }

    public RoleModel(Long id, String nomeRole) {
        this.id = id;
        this.nomeRole = nomeRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}
