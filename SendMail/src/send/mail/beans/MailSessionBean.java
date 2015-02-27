package send.mail.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import send.mail.util.Constants;

@Stateless
public class MailSessionBean {
	
	@Resource(mappedName = "java:jboss/mail/Default")
    private Session mySession;
		
	public void sendMail(String to, String subject, String body) {
		
		System.out.println("Try to send a mail with params: [to=" + to + "], " + 
								"[from=" + Constants.EMAIL_ADDRESS_FROM + "], " +
								"[subject=" + subject + "]");
		
		String enrichedBody = getEnrichedMessageBody(body); 
		
        try {
        	Message message = new MimeMessage(mySession);
			message.setFrom(new InternetAddress(Constants.EMAIL_ADDRESS_FROM));
			Address toAddress = new InternetAddress(to);
 	        message.addRecipient(Message.RecipientType.TO, toAddress);
	        message.setSubject(subject);
	        message.setContent(enrichedBody, "text/plain");
	        Transport.send(message);
	        System.out.println("Message successfully transported to email server...");
		} catch (AddressException e) {
			System.out.println("Oops, something went wrong...");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("Oops, something went wrong...");
			e.printStackTrace();
		}
	}
	
	/**
	 * Get an enriched message body with standard header and footer.
	 * @param body the original message body
	 * @return the enriched message body
	 */
	private String getEnrichedMessageBody(String body) {
		return Constants.MESSAGE_BODY_HEADER + body + Constants.MESSAGE_BODY_FOOTER;
	}
}
