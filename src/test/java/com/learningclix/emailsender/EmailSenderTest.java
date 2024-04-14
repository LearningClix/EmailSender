package com.learningclix.emailsender;

import com.learningclix.emailsender.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderTest {


    @Autowired private EmailService emailService;
    @Test
    void setEmail(){
        emailService.sendEmail (
                "compiler.1998@gmail.com",
                "THis is Test Email",
                "Body of Test Email"
        );
    }
}
