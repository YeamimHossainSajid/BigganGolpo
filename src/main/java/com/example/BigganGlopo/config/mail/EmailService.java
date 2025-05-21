package com.example.BigganGlopo.config.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String toEmail, String otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(toEmail);
            helper.setSubject("Your BigganGolpo OTP Code – Secure Your Account");

            String plainText = "Welcome to BigganGolpo!\n\n" +
                    "Your OTP code is: " + otp + "\n\n" +
                    "This OTP is valid for 5 minutes.\n" +
                    "If you did not request this code, please ignore this message.\n\n" +
                    "– The BigganGolpo Team";

            String htmlContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>Welcome to BigganGolpo!</h2>" +
                    "<p style='font-size: 16px; color: #34495e;'>Thank you for joining BigganGolpo — a platform where curious minds of all ages can explore science, discover fascinating facts, and engage in thought-provoking discussions. Whether you're a student, a professional, or simply someone who loves science, BigganGolpo is for you.</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>To complete your registration, please use the One-Time Password (OTP) below:</p>" +
                    "<h3 style='font-size: 32px; color: #2980b9; font-weight: bold; text-align: center;'>"
                    + otp + "</h3>" +
                    "<p style='font-size: 16px; color: #34495e;'>This OTP is valid for 5 minutes. If you didn’t request this, you can safely ignore this email or contact our support team.</p>" +
                    "<br>" +
                    "<p style='font-size: 16px; color: #34495e;'>Best regards,</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>The BigganGolpo Team</p>" +
                    "<footer style='font-size: 12px; color: #95a5a6; text-align: center;'>" +
                    "BigganGolpo | Inspiring Curiosity in Everyone</footer>" +
                    "</body>" +
                    "</html>";

            helper.setText(plainText, htmlContent);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }





}


