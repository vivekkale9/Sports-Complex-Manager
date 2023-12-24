/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kajal
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
public class rupesmail {
    public static void main(String[] args) {

        // Sender's email address
        String fromEmail = "djb4557@gmail.com";
        // Sender's email password
        String fromPassword = "KaradRandi@69";
        // Recipient's email address
        String toEmail = "vivekskale03@gmail.com";

        // Set up properties for the mail server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Create a session with the mail server
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("djb4557@gmail.com:", "KaradRandi@69");
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            // Set the subject and message body
            message.setSubject("Test email from JavaMail API");
            message.setText("Hello, this is a test email from the JavaMail API.");

            // Send the email message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}