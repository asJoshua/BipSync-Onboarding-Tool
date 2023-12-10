package com.BipSyncRecuritment.login;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

//entity created to map user object to users table in the database
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "user_email")
    private String userEmail;

    @NotEmpty(message = "Password is required")
    private String password;


    private String userFirstName;

    private String userLastName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ResetPasswordToken passwordResetToken;

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
    public String getUserEmail() {
        return userEmail;
    }


    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
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

    public ResetPasswordToken getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(ResetPasswordToken passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }
}

