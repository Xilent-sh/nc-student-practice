/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.social.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Soulpain
 */
public class Mailer {
    private Session session;
    
    private Mailer() {
        // hi there
    }
    
    public static Mailer getInstance() {
        return MailerHolder.INSTANCE;
    }
    
    private static class MailerHolder {

        private static final Mailer INSTANCE = new Mailer();
    }
    
    public void send(String to, String subject, String body) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("admin@example.com", "Tester"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);

        } catch (Throwable e) {
            // hello
        }
    }
}
