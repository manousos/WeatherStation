package gr.manousos.iot.it.repository;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gr.manousos.iot.WeatherStationApplication;
import gr.manousos.iot.repository.LocationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = WeatherStationApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLocationRepository {
	@Autowired
	LocationRepository locationRepository;

	@Test
	public void testFindOne() {
		Assert.assertNotNull(locationRepository.findOne(1L));
	}
}
