package gr.manousos.iot.it.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gr.manousos.iot.WeatherStationApplication;
import gr.manousos.iot.domain.SensorData;
import gr.manousos.iot.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = WeatherStationApplication.class)
public class TestSampleServiceImpl {
	private static SensorData sample;
	@Autowired
	SampleService sampleService;

	@BeforeClass
	public static void createSample() {
		sample=new SensorData();
		sample.setName("DHT22");
		sample.setLocationId(1L);
		sample.setSamples(
				new String[] { "{\"name\":\"DHT22\",\"locationId\":1,\"samples\":[\"Temp=18.6*  Humidity=62.5%\"]}" });
	}

	@Test
	public void testSaveSample() {
		sampleService.saveSample(sample);
	}
}
