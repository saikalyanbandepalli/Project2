package org.revature.RevTaskManagement.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(message,true,"UTF-8");
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(body);

        mailSender.send(message);
    }

    public void sendOtpEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your OTP for Password Reset");
        message.setText("Use the following OTP to reset your password: " + otp);
        mailSender.send(message);
    }
}