package com.curupira.model;

import javax.persistence.*;

@Entity
public class Role implements CurupiraModel{
    private Long id;

    private String roleName;

    public static Role create(String roleName){
        Role role = new Role();

        role.setRoleName(roleName);
        return role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    @Transient
    public String getName() {
        return Role.class.getName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
