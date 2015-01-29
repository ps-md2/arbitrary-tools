import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

 
public class DummyData {
 
	public static void main(String[] args) {
 
	  try {
//		URL url = new URL("http://128.176.157.188:8080/ReferenceProject.backend/service/workflowState/");

		URL url = new URL("http://localhost:8080/ReferenceProject.backend/service/workflowState/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = "[{\"__internalId\":3,"
				+ "\"instanceId\":3,"
				+ "\"currentWorkflowElement\":\"LocationDetection\","
				+ "\"lastEventFired\":\"MediaCaptured\"},"
				+"{\"__internalId\":1,"
				+ "\"instanceId\":1,"
						+ "\"currentWorkflowElement\":\"Mediacapturing\","
						+ "\"lastEventFired\":\"MediaCaptured\"},"
				+ "{\"__internalId\":5,"
				+ "\"instanceId\":5,"
				+ "\"currentWorkflowElement\":\"Mediacapturing\","
				+ "\"lastEventFired\":\"LocationDetected\"}]";


		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
 
		conn.disconnect();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	 }
 
	}
 
}