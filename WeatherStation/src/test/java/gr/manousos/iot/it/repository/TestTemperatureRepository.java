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
import gr.manousos.iot.domain.Temperature;
import gr.manousos.iot.repository.TemperatureRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = WeatherStationApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTemperatureRepository {
	@Autowired
	private TemperatureRepository temperatureRepository;

	static Temperature t1 = new Temperature();
	static Long id = null;

	@BeforeClass
	public static void initialRecords() {
		t1.setSampleDate(new Date());
		t1.setTemperature(new Float(11.5));
	}

	@Test
	public void testFindOne() {
		assertNotNull(temperatureRepository.findOne(id));
	}

	@Test
	public void a_testSave() {
		id = temperatureRepository.save(t1).getId();
	}

	@Test
	public void z_testDelete() {
		temperatureRepository.delete(id);
		assertNull(temperatureRepository.findOne(id));
	}
}
