
//import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.Spring;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Main {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	try {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Lab6hibernate/rest/services/customers/A");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		//output
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
   }
	
	}
	
	
	//public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
			/*
			try {

					URL url = new URL("http://localhost:8080/Lab6hibernate/rest/services/authenticate");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");

					String input = "{\"username\":\"sssss\",\"pwd\":\"123456\"}";

					OutputStream os = conn.getOutputStream();
					os.write(input.getBytes());
					os.flush();
					if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
						throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
					}
					BufferedReader br = new BufferedReader(new InputStreamReader(
							(conn.getInputStream())));
					String output="";
					String content = "";
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						content += output;				
	                          }

				    ObjectMapper obj = new ObjectMapper();
					
					JsonNode actualObj = obj.readTree(content);
					
					String token = actualObj.get("result").toString();
					
					token = (token.replace("\"", ""));
					
					url = new URL("http://127.0.0.1:8080/Lab6hibernate/rest/services/customers/sssss");
					conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setDoOutput(true);
					
					conn.setRequestProperty("token", token);
					
					br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					output = "";
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		*/
		

    



