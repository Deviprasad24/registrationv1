package com.api.payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailSender {


        @Autowired
        private JavaMailSender javaMailSender;

        public void sendMail(
                String to,
                String subject,
                String message
        ){
            SimpleMailMessage sm=new SimpleMailMessage();
            sm.setTo(to);
            sm.setSubject(subject);
            sm.setText(message);
            javaMailSender.send(sm);


        }
    }


