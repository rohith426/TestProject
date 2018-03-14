/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author user
 */
public class SendGmail {
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        SendGmail sm=new SendGmail();
        sm.sendMail();
    }
    public void sendMail() throws UnsupportedEncodingException {

		//final String username = "vthumma@ivbplus.com.au";
		//final String password = "vijay125";
                //String[] recipients={"vthumma@ivbplus.com.au","tvijayp@gmail.com","tvijayp9@gmail.com"};
                final String username = "techhelp@ivbplus.com";
		final String password = "Admin@123";
                String[] recipients={"vthumma@ivbplus.com.au","tvijayp@gmail.com","tvijayp9@gmail.com"};
                
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.host", "smtp.zoho.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
                        //message.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
			message.setFrom(new InternetAddress("techhelp@ivbplus.com","IVBPlus TECH TEAM"));
                         InternetAddress[] addressBcc = new InternetAddress[recipients.length - 1];
            InternetAddress addressTo = new InternetAddress(recipients[0]);
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("vthumma@ivbplus.com.au,tvijayp@gmail.com"));
                        
                         for (int i = 1; i < recipients.length; i++) {
                addressBcc[i - 1] = new InternetAddress(recipients[i]);
            }
            
            message.setRecipient(Message.RecipientType.TO, addressTo);
            message.setRecipients(Message.RecipientType.BCC, addressBcc);
            
            
            
			message.setSubject("Testing gmail Subject2");
			message.setText("Dear Sir/Madam,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Sent message successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
