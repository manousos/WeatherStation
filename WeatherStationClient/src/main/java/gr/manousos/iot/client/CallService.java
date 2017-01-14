package gr.manousos.iot.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import gr.manousos.iot.domain.SensorData;

public class CallService {
	String sensorName;
	String sensorSamples[];
	SensorData sensorData;
	Properties prop = new Properties();

	public CallService(String sensorSamples[], String sensorName) throws FileNotFoundException, IOException {
		this.sensorSamples = sensorSamples;
		this.sensorName = sensorName;
	
		prop.load(CallService.class.getResourceAsStream("/gr/manousos/iot/client/app.properties"));
		createSensorData();
	}

	private String getRequestMessage() {
		Gson gson = new Gson();
		String json = gson.toJson(sensorData);

		return json;
	}

	private void createSensorData() {
		sensorData = new SensorData();
		sensorData.setSamples(sensorSamples);
		sensorData.setName(sensorName);
		sensorData.setLocationId(Long.getLong(prop.getProperty("sensor.location"), 0));
	}

	public void doRestCall() {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(prop.getProperty("service.uri"));
			String input = getRequestMessage();
			System.out.println("Request: " + input);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				System.err.println(response.getStatus());
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
