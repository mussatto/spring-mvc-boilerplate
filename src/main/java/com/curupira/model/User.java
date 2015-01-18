package com.curupira.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User implements CurupiraModel {
    private Long id;

    private String email;

    private String name;

    private String encodedPassword;

    private List<Role> roles;

    public static User createUser(String email, String name, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setEncodedPassword(User.encodePassword(password));
        return user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="User_Role")
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Column
    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    @Transient
    public static String encodePassword(String password){
        //TODO: encode password
        return password;
    }

    @Transient
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", encodedPassword='" + encodedPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
