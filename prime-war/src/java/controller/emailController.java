
package controller;


import java.io.Serializable;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Message;
import org.primefaces.context.RequestContext;

/**
 *
 * @author pas
 */
public class emailController implements Serializable {

    private final String uname = "ChurigicaleReaven@gmail.com";
    private final String pd = "11111111111try";

     String toemail;
     String subject;
     String message;
     String msg = "";

    public String getToemail() {
        return toemail;
    }

    public void setToemail(String toemail) {
        this.toemail = toemail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

 
    public void send() throws MessagingException {
            try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            props.put("mail.smtp.starttls.enable", "true");

            
            msg = "Loading ....";
            Session session= Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication(){
                
                return new PasswordAuthentication(uname , pd);
            }
            
            
            });
            
        
            Message mailmessage = new MimeMessage(session);
            
            mailmessage.setFrom(new InternetAddress("ChurigicaleReaven@gmail.com"));
            mailmessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toemail));
            mailmessage.setContent(message, "text/html");
            mailmessage.setSubject(subject);
           
            msg = "";
            Transport.send(mailmessage);
            
             msg = "Successful...";
   
            
            RequestContext.getCurrentInstance().execute("PF('email_dialog').hide()");
        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }
    }

  

 
    public emailController() {
    }

}


        