package com.BipSyncRecuritment.email;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
