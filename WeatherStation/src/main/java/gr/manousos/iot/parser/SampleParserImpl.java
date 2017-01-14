package gr.manousos.iot.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import gr.manousos.iot.service.SampleService;

/** Implements {@link SampleService} */
@Component
public class SampleParserImpl implements SampleParser {
	private String sample;
	private Pattern floatWithOneDecimal = Pattern.compile("[0-9]+.[0-9]");
	private Pattern floatPercent = Pattern.compile("[0-9]+.[0-9]%");

	@Override
	public void setSample(String sample) {
		if (sample == null || sample.isEmpty()) {
			throw new IllegalArgumentException("No sample to parse");
		}
		this.sample = sample;
	}

	@Override
	public Float parseTemperature() {
		Matcher matcher = floatWithOneDecimal.matcher(sample);

		return (matcher.find() ? Float.parseFloat(matcher.group(0)) : null);
	}

	@Override
	public Float parseHumidity() {
		Matcher matcher = floatPercent.matcher(sample);

		return (matcher.find() ? Float.parseFloat(matcher.group(0).replace("%", "")) : null);
	}

}
