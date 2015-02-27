package send.mail.ws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import send.mail.beans.MailSessionBean;

@Path("/mail")
public class MailWS {
	
	@EJB
	MailSessionBean mailBean;
	
	@GET
	@Path("send")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response sendMail(@QueryParam("to") String to, 
							 @QueryParam("subject") String subject,
							 @QueryParam("body") String body) {
		
		// check for non-empty parameters...
		if(to == null || to.equals("") ||
		   subject == null || subject.equals("") || 
		   body == null || body.equals("")) {
			System.err.println("Please provide non-empty information for the parameters: to, subject, body");
			return Response.ok().build();
		}
		
		mailBean.sendMail(to, subject, body);
		
		return Response.ok().build();
	}
	
}
