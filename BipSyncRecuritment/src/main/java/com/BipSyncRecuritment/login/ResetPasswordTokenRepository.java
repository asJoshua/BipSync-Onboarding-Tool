package com.BipSyncRecuritment.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer> {

    ResetPasswordToken findByToken(String token);

}
