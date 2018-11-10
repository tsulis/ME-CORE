package com.me.core.service.impl;

import com.me.core.entity.User;
import com.me.core.service.EmailService;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

  @Override
  public void sendMail(User user) {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);
    mailSender.setUsername("rthi.adm@gmail.com");
    mailSender.setPassword("Rth1Adm1n");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper;
    try {
      helper = new MimeMessageHelper(message, true);
      helper.setTo(user.getEmail());
      helper.setFrom(mailSender.getUsername());
      helper.setSubject("Verification Code");
      helper.setText("Your verification code is " + user.getVerificationCode());
    } catch (MessagingException e) {
      e.printStackTrace();
    }

    mailSender.send(message);
  }
}
