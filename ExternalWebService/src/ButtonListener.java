import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:8080/CurrentStateProject.backend/service/submitComplaint/fileComplaint");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("street", MainWindow.street.getText()));
            nameValuePairs.add(new BasicNameValuePair("streetNo", MainWindow.nr.getText()));
            nameValuePairs.add(new BasicNameValuePair("city", MainWindow.city.getText()));
            nameValuePairs.add(new BasicNameValuePair("plz", MainWindow.plz.getText()));
            nameValuePairs.add(new BasicNameValuePair("desc", MainWindow.description.getText()));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs, Charset.defaultCharset()));

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
	}
		
}