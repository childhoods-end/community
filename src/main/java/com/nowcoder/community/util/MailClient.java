package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailClient {

    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);

    @Autowired
    // 核心组件，处理邮件请求
    // 有构建功能（createMimeMessage)和发送功能（send)
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to, String subject, String content) {
        try {
            // 空的实例，需要填入内容
            MimeMessage message = mailSender.createMimeMessage();
            // 调用 MimeMessageHelper,传入 message 来完成邮件的生成
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);   //发件人
            helper.setTo(to);       //收件人
            helper.setSubject(subject);             // 标题
            // 不加 true 则是普通文本，true 后可发送 html 文件
            helper.setText(content, true);     // 内容
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            // e.getMessage() 异常信息
            logger.error("发送邮件失败:" + e.getMessage());
        }
    }
}
