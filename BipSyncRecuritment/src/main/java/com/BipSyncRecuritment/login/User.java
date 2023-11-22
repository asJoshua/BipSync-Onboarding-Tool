package com.BipSyncRecuritment.login;


import jakarta.persistence.*;

import java.util.Set;

//entity created to map user object to users table in the database
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String userFirstName;

    private String userLastName;


    //user_id (foreign key) links user_roles to users table
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "user_role")
    private Set<String> roles;

    public User () {}




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return userFirstName;
    }
    public String getLastname() {
        return userLastName;
    }


    public Set<String> getRoles() {
        return roles;
    }
}

