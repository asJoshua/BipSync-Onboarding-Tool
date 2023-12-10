package com.BipSyncRecuritment.login;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_token")
public class ResetPasswordToken {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDateTime;
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "pass_user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public ResetPasswordToken(String token, User user) {
    }

    public ResetPasswordToken() {

    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDateTime() {
        return expiryDateTime;
    }

    public void setExpiryDateTime(LocalDateTime expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryDateTime);
    }


}
