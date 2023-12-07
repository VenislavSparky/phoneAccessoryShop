package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {
    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    private final String shopEmail;

    public EmailServiceImpl(TemplateEngine templateEngine, JavaMailSender javaMailSender, @Value("${mail.phoneAccessoryMail}") String shopEmail
    ) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
        this.shopEmail = shopEmail;
    }

    @Override
    public void sendRegistrationEmail(String userEmail, String username, String activationCode) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setFrom(shopEmail);
            mimeMessageHelper.setReplyTo(shopEmail);
            mimeMessageHelper.setSubject("Welcome to phoneAccessoryBulgaria!");
            mimeMessageHelper.setText(generateRegistrationEmailBody(username,activationCode),true);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRegistrationEmailBody(String username,String activationCode) {
        Context context = new Context();
        context.setVariable("username", username);
        context.setVariable("activation_code", activationCode);
        return templateEngine.process("email/activation-email.html", context);
    }

}
