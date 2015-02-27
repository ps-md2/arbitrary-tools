package send.mail.ws;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriInfo;

/**
 * Copied from EAI exercises.
 */
public class RootImpl implements Root {

	public Map<String, Map<String, URI>> links(UriInfo uriInfo) {
		Map<String, URI> links = new HashMap<>();
		links.put("adder", adderUri(uriInfo));
		
		Map<String, Map<String, URI>> map = new HashMap<>();
		map.put("links", links);
		return map;
	}

	private URI adderUri(UriInfo uriInfo) {
		return uriInfo.getBaseUriBuilder()
				.path(MailWS.class)
				.build();
	}
}
