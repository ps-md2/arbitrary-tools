import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			URL url = new URL("http://localhost:8080/CurrentStateProject.backend/service/LocationDetection/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "[{\"street\":\""+MainWindow.street.getText()+"\","
					+ "\"number\":\""+MainWindow.nr.getText()+"\","
					+ "\"city\":\""+MainWindow.city.getText()+"\","
					+ "\"ply\":\""+MainWindow.plz.getText()+"\"}]";


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
	 
		  } catch (MalformedURLException e1) {
	 
			e1.printStackTrace();
	 
		  } catch (IOException e1) {
	 
			e1.printStackTrace();
	 
		 }
			
	}
		
}