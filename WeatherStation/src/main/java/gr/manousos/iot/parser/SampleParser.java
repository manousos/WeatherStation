package gr.manousos.iot.parser;

/**
 * Parser for sensors samples
 * 
 * @author manousos
 *
 */
public interface SampleParser {
	/**
	 * It's REQUIRED to set sample
	 * 
	 * @param sample
	 */
	public void setSample(String sample);

	/**
	 * Parse a Temperature from sensor response
	 * 
	 * @return temperature
	 */
	public Float parseTemperature();

	/**
	 * Parse a Humidity from sensor response
	 * 
	 * @return humidity
	 */
	public Float parseHumidity();
}
