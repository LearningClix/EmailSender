package com.learningclix.emailsender.service.impl;

import com.learningclix.emailsender.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.File;
import java.util.Objects;

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
        log.info ( "Sending email to: " + to + " with subject: " + subject + " and body: " + body );
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage ( );
        simpleMailMessage.setTo ( to );
        simpleMailMessage.setSubject ( subject );
        simpleMailMessage.setText ( body );
        javaMailSender.send ( simpleMailMessage );
        log.info ( "Email sent successfully..." );
    }

    @Override
    public void sendHtmlEmail(String to, String subject, String htmlContent) {
        log.info ( "Sending email to: " + to + " with subject: " + subject + " and htmlContent: " + htmlContent );
        MimeMessage mimeMessage = javaMailSender.createMimeMessage ();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo ( to );
            helper.setSubject ( subject );
            helper.setText ( htmlContent, true );
            javaMailSender.send ( mimeMessage );
        } catch (MessagingException e) {
            e.printStackTrace ();
            throw new RuntimeException ( e );
        }
        log.info ( "Html Email sent successfully..." );
    }

    @Override
    public void sendHtmlEmail(String[] to, String subject, String htmlContent) {
        log.info ( "Sending email to: " + to + " with subject: " + subject + " and htmlContent: " + htmlContent );
        MimeMessage mimeMessage = javaMailSender.createMimeMessage ();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo ( to );
            helper.setSubject ( subject );
            helper.setText ( htmlContent, true );
            javaMailSender.send ( mimeMessage );
        } catch (MessagingException e) {
            e.printStackTrace ();
            throw new RuntimeException ( e );
        }
        log.info ( "Email sent successfully..." );
    }

    @Override
    public void sendAttachmentEmail(String to, String subject, String body, File attachment) {
        log.info ( "Sending email to: " + to + " with subject: " + subject + " and attachment: " + attachment.getName ());
        MimeMessage mimeMessage = javaMailSender.createMimeMessage ();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo ( to );
            helper.setSubject ( subject );
            helper.setText ( body );
            FileSystemResource fileSystemResource = new FileSystemResource(attachment);
            helper.addAttachment ( Objects.requireNonNull ( fileSystemResource.getFilename ( ) ), attachment );
            javaMailSender.send ( mimeMessage );
        } catch (MessagingException e) {
            e.printStackTrace ();
            throw new RuntimeException ( e );
        }
        log.info ( "Email with attachement sent successfully..." );
    }

    @Override
    public void sendAttachmentEmail(String[] to, String subject, String body, File attachment) {
        log.info ( "Sending email to: " + to + " with subject: " + subject + " and attachment: ");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage ();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo ( to );
            helper.setSubject ( subject );
            helper.setText ( body );
            FileSystemResource fileSystemResource = new FileSystemResource(attachment);
            helper.addAttachment ( Objects.requireNonNull ( fileSystemResource.getFilename ( ) ), attachment );
            javaMailSender.send ( mimeMessage );
        } catch (MessagingException e) {
            e.printStackTrace ();
            throw new RuntimeException ( e );
        }
        log.info ( "Multple Email with attachement sent successfully..." );
    }
}
