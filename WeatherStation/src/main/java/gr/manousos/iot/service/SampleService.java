package gr.manousos.iot.service;

import gr.manousos.iot.domain.SensorData;

/**
 * Services for Sensors samples
 * 
 * @author manousos
 *
 */
public interface SampleService {
	/**
	 * Save a sensor sample
	 * 
	 * @param sample
	 * @return true if saved, otherwise false
	 */
	boolean saveSample(SensorData sample);
}
