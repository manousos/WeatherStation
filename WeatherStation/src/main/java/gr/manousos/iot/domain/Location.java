package gr.manousos.iot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location extends AbstractEntity<Long> {
	@Id
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
