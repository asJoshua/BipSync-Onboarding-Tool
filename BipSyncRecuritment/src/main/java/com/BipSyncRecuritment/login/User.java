package com.BipSyncRecuritment.login;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

//entity created to map user object to users table in the database
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  @NotEmpty(message = "Username is required")
    private String username;
    //@Email
    //@NotEmpty(message = "Email is required")
    @Column(name = "user_email")
    private String userEmail;
    //@NotEmpty(message = "First Name is required")
    private String userFirstName;
   // @NotEmpty(message = "Last Name is required")
    private String userLastName;
   // @NotEmpty(message = "Password is required")
    private String password;








    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ResetPasswordToken passwordResetToken;

    //user_id (foreign key) links user_roles to users table
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "user_role")
    private Set<String> roles;

    public User () {}

    public User(String username, String userEmail, String userFirstName, String userLastName, String password, Set<String> roles){
        this.username= username;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.password = password;
        this.roles = roles;
    }




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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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

    public void setRoles(Set<String> roles) {
        this.roles= roles;
    }


}

