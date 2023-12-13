package com.example.mail.controller;

import com.example.mail.utils.MailUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Resource
    private MailUtil mailUtil;

    @RequestMapping("test")
    public void testSendMailOne() {
        String to = "2207115150@qq.com";
        String subject = "测试";
        String context = "This is a test email.";
        String result = mailUtil.sendMailOne(to, subject, context);
        System.out.println(result);
    }
}
