package gr.manousos.iot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.manousos.iot.domain.Humidity;
import gr.manousos.iot.domain.Location;
import gr.manousos.iot.domain.SensorData;
import gr.manousos.iot.domain.Temperature;
import gr.manousos.iot.parser.SampleParser;
import gr.manousos.iot.repository.HumidityRepository;
import gr.manousos.iot.repository.LocationRepository;
import gr.manousos.iot.repository.TemperatureRepository;

/** Implements {@link SampleService} */
@Service
@Transactional(readOnly = true)
public class SampleServiceImpl implements SampleService {
	@Autowired
	HumidityRepository humidityRepository;
	@Autowired
	TemperatureRepository temperatureRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	SampleParser sampleParser;

	// TODO: save the average value of samples
	@Transactional
	public boolean saveSample(SensorData sample) {
		// Save the second sample only
		sampleParser.setSample(sample.getSamples()[1]);
		boolean status = false;
		if (sample.getName().equals("DHT22")) {
			Location loc = locationRepository.findOne(sample.getLocationId());
			Temperature t = new Temperature();
			Humidity h = new Humidity();

			t.setSampleDate(new Date());
			t.setTemperature(sampleParser.parseTemperature());
			t.setLocation(loc);

			h.setSampleDate(new Date());
			h.setHumidity(sampleParser.parseHumidity());
			h.setLocation(loc);

			temperatureRepository.save(t);
			humidityRepository.save(h);

			status = true;
		}
		return status;

	}
}
