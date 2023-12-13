package com.example.mail.utils;


import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtil {
    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;

    public String sendMailOne(String to,String subject,String context){
        try {
            MimeMessage mimeMessage = null;
            mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setText(context);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(to);
            javaMailSender.send(mimeMessage);
            System.out.println("发送成功");
            return "success";
        }catch (Exception e){
            System.out.println("发送失败");
            return "error";
        }
    }
}