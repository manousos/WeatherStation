package gr.manousos.iot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.manousos.iot.domain.SensorData;
import gr.manousos.iot.service.SampleService;

@RestController
@RequestMapping("/sensor")
public class SensorRestController {
	@Autowired
	SampleService sampleService;

	@RequestMapping(method = RequestMethod.POST, value = "/postSamples")
	public ResponseEntity<Void> postSamples(@RequestBody SensorData sensorData) {

		boolean success = sampleService.saveSample(sensorData);
		if (success) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
