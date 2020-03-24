package com.springboot.demo11task;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Demo11TaskApplicationTests {


    @Autowired(required = false)
    JavaMailSenderImpl javaMailSenderImpl;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("subject");
        message.setText("text");
        message.setFrom("sendfrom");
        message.setTo("155151151@qq.com");
        javaMailSenderImpl.send(message);
    }

    @Test
    void test02() throws MessagingException {
        // 创建一个复杂的消息邮件
        MimeMessage message = javaMailSenderImpl.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
        mimeMessageHelper.setSubject("subject");
        mimeMessageHelper.setText("<b>text</b>",true);// 设置true告诉他是html
        mimeMessageHelper.setFrom("sendfrom");
        mimeMessageHelper.setTo("155151151@qq.com");

        // 上传文件
        mimeMessageHelper.addAttachment("1.jpg",new File("c:\\1.jpg"));
        mimeMessageHelper.addAttachment("2.jpg",new File("c:\\2.jpg"));
        javaMailSenderImpl.send(message);
    }
}
