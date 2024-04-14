package com.learningclix.emailsender.service;

import java.io.File;

public interface EmailService {

//     send email to single user
    void sendEmail(String to, String subject, String body);

//    Send email to multiple users
    void sendEmail(String []to, String subject, String body);

//    Send email to single user with HTML body
    void sendHtmlEmail(String to, String subject, String body);

//    Send email to multiple users with HTML body
    void sendHtmlEmail(String []to, String subject, String body);

//    Send email to single user with attachment or attachments
    void sendAttachmentEmail(String to, String subject, String body, File attachment);

//    Send email to multiple users with attachment or attachments
    void sendAttachmentEmail(String []to, String subject, String body, File attachment);

}
