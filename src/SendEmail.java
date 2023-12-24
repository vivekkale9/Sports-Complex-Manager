/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kajal
 */
import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class SendEmail {
	public static void main(String[] args) {
		
		System.out.println("preparing to send message ...");
		String message = "Hello , Dear, this is message for security check . ";
		String subject = "CodersArea : Confirmation";
		String to = "vivekskale03@gmail.com";
		String from = "djb4557@gmail.com";
		
//		sendEmail(message,subject,to,from);
		//sendAttach(message,subject,to,from);
	       
        

		
		//Variable for gmail
    String host="smtp.gmail.com";
		
		//get the system properties
    Properties properties = System.getProperties();
    System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
                //properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		JOptionPane.showMessageDialog(null,"first");
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("djb4557@gmail.com", "KaradRandi@69");
			}
			
		
			
		});
		JOptionPane.showMessageDialog(null,"second");
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(new InternetAddress(from));
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		JOptionPane.showMessageDialog(null,"third");
		System.out.println("Sent success...................");
		
		
		}catch (Exception e) {
                    System.out.println("This is exception"+e);
		}
			
        }}
