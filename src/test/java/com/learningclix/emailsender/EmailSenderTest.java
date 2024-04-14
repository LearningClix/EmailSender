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
                "This is Test Email",
                "Body of Test Email"
        );
    }

    @Test
    void setEmailMultiple(){
        String[] recipients = {"compiler.1998@gmail.com", "compiler_1998@hotmail.com"};
        emailService.sendEmail (
                recipients,
                "This is Test Email",
                "Body of Test Email"
        );
    }

    @Test
    void setHtmlEmail(){

        String html = "" +
                "<h1>H1 Test Email</h1>" +
                "<h2>H2 Test Email</h2>" +
                "";
        emailService.sendHtmlEmail (
                "compiler.1998@gmail.com",
                "This is Test Email with HTML to multiple recipients",
                html
        );
    }

    @Test
    void setHtmlEmailMultiple(){
        String html = "" +
                "<h1>H1 Test Email</h1>" +
                "<h2>H2 Test Email</h2>" +
                "";
        String[] recipients = {"compiler.1998@gmail.com", "compiler_1998@hotmail.com"};
        emailService.sendHtmlEmail (
                recipients,
                "This is Test Email with HTML to multiple recipients",
                html
        );
    }
}
