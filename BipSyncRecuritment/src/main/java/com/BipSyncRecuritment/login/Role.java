package com.BipSyncRecuritment.login;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

//entity representing roles table in database
@Entity
@Table(name = "user_roles")
public class Role {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}


