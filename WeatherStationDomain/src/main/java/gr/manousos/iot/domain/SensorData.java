package gr.manousos.iot.domain;

public class SensorData {
	String name;
	Long locationId;
	String[] samples;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String[] getSamples() {
		return samples;
	}

	public void setSamples(String[] samples) {
		this.samples = samples;
	}

}
