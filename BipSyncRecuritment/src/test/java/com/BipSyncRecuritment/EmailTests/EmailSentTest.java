package com.BipSyncRecuritment.EmailTests;

import com.BipSyncRecuritment.email.EmailServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmailSentTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailServiceImp emailService;

    @Captor
    private ArgumentCaptor<SimpleMailMessage> captor;


    /* Adapted using stackover flow  https://stackoverflow.com/questions/36253040/example-of-mockitos-argumentcaptor  */
    @Test
    void sendEmailTest() {

        String to = "test@test.com";
        String subject = "Test Subject for email";
        String body = "Test Body for email";


        emailService.sendEmail(to, subject, body);


        verify(javaMailSender, times(1)).send(captor.capture());

        SimpleMailMessage capturedArgument= captor.getValue();


        assertEquals(to, capturedArgument.getTo()[0]);
        assertEquals(subject, capturedArgument.getSubject());
        assertEquals(body, capturedArgument.getText());
    }
}