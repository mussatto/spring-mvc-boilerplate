package com.curupira.model;

public enum RoleName {

    ADMIN("ADMIN"),
    USER("USER");

    private String roleName;

    private RoleName(String roleName){
        this.roleName = roleName;
    }

    public String toString(){
        return roleName;
    }
}
