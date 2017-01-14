package gr.manousos.iot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "temperature")
@Table(name = "Temperature")
public class Temperature extends AbstractEntity<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@ManyToOne
	@JoinColumn
	private Location location;
	@Column(nullable = false)
	private Float temperature;
	private Date sampleDate;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Date getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

}
