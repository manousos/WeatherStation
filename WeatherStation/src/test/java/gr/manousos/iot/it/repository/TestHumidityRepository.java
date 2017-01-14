package gr.manousos.iot.it.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gr.manousos.iot.WeatherStationApplication;
import gr.manousos.iot.domain.Humidity;
import gr.manousos.iot.repository.HumidityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = WeatherStationApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHumidityRepository {
	@Autowired
	private HumidityRepository humidityRepository;

	static Humidity h1 = new Humidity();
	static Long id = null;

	@BeforeClass
	public static void initialRecords() {
		h1.setSampleDate(new Date());
		h1.setHumidity(new Float(60.8));
	}

	@Test
	public void testFindOne() {
		assertNotNull(humidityRepository.findOne(id));
	}

	@Test
	public void a_testSave() {
		id = humidityRepository.save(h1).getId();
	}

	@Test
	public void z_testDelete() {
		humidityRepository.delete(id);
		assertNull(humidityRepository.findOne(id));
	}
}
