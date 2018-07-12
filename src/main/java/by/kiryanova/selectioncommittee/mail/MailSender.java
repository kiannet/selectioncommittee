package by.kiryanova.selectioncommittee.mail;

import com.mysql.cj.api.Session;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

public class MailSender {
    public MailSender() { }

    /*public static void sendMail(String subject, String text, String toEmail) {
        Session session = (new MailSessionCreator()).createSession();
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            LOGGER.log(Level.ERROR, "Cannot send an email: " + e, e);
        }
    }*/
}
