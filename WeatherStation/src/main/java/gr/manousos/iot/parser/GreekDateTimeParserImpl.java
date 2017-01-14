package gr.manousos.iot.parser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * Implements {@link GreekDateTimeParser}
 * 
 * @author manousos
 *
 */
@Component
public class GreekDateTimeParserImpl implements GreekDateTimeParser {
	@Override
	public Date convertCurrentLocalDateTimeToGreek() {
		LocalDateTime localDT = LocalDateTime.now();
		ZoneId localZonedDT = ZonedDateTime.now().getZone();

		ZoneId greekZoneId = ZoneId.of("Europe/Athens");
		ZonedDateTime greekDateTime = localDT.atZone(localZonedDT).withZoneSameInstant(greekZoneId);

		return Date.from(greekDateTime.toInstant());
	}
}
