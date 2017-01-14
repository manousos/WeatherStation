package gr.manousos.iot.parser;

import java.util.Date;

/**
 * Parse a system date time to Greek date & time
 * 
 * @author manousos
 */
public interface GreekDateTimeParser {
	/**
	 * Return the DateTime in Greece from local (system) date time
	 * 
	 * @return the Greek date time
	 */
	public Date convertCurrentLocalDateTimeToGreek();
}
