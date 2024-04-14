package com.learningclix.emailsender.service.impl;

import com.learningclix.emailsender.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.File;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender  javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver handlerExceptionResolver) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * @param to
     * @param subject
     * @param body
     */
    @Override
    public void sendEmail(String to, String subject, String body) {
        log.info ( "Sending email to: " + to + " with subject: " + subject + " and body: " + body );
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage ( );
        simpleMailMessage.setTo ( to );
        simpleMailMessage.setSubject ( subject );
        simpleMailMessage.setText ( body );
        javaMailSender.send ( simpleMailMessage );
        log.info ( "Email sent successfully..." );
    }

    @Override
    public void sendEmail(String[] to, String subject, String body) {

    }

    @Override
    public void sendHtmlEmail(String to, String subject, String body) {

    }

    @Override
    public void sendHtmlEmail(String[] to, String subject, String body) {

    }

    @Override
    public void sendAttachmentEmail(String to, String subject, String body, File attachment) {

    }

    @Override
    public void sendAttachmentEmail(String[] to, String subject, String body, File attachment) {

    }
}
