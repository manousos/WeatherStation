package gr.manousos.iot.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.TemporalType;

import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.Temporal;

/**
 * Abstract entity.
 * 
 * @author manousos
 *
 * @param <T>,
 *            the type of primary key
 */
@MappedSuperclass
public abstract class AbstractEntity<T> {
	@Version
	private long version;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified = new Date();

	public abstract T getId();

	public abstract void setId(T id);

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		if (lastModified == null)
			this.lastModified = new Date();
		else
			this.lastModified = lastModified;
	}

}
