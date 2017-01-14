package gr.manousos.iot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads samples from sensor by executed his program.
 * 
 * @author manousos
 *
 */
public class ExecuteSensor {
	private int interval = 0;
	private int takenSamples = 1;
	private String sensorName;
	private String[] samples;

	public String getSensorName() {
		return sensorName;
	}

	public String[] getSamples() {
		return samples;
	}

	/**
	 * Execute the sensor program
	 * 
	 * @param command
	 * @throws InterruptedException
	 */
	public void executeSensorProgram(String command) throws InterruptedException {
		parseCommand(command);

		samples = new String[takenSamples];
		try {
			for (int i = 0; i < takenSamples; i++) {
				String output;
				Process p = Runtime.getRuntime().exec(command.split("#")[0].trim());

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

				while ((output = stdInput.readLine()) != null) {
					samples[i] = output;
					System.out.println(output);
				}
				while ((output = stdError.readLine()) != null) {
					System.err.println(output);
				}
				Thread.sleep(interval * 1000);
			}

			System.exit(0);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Parse from command the
	 * <ul>
	 * <li>The count of taken samples</li>
	 * <li>Interval time for next sample</li>
	 * <li>Sensor name</li>
	 * </ul>
	 * 
	 * @param command
	 */
	private void parseCommand(String command) {
		String takenSampleStr = "", intervalStr = "";

		try {
			takenSampleStr = command.split("#")[1].trim().split(" ")[0];
			intervalStr = command.split("#")[1].trim().split(" ")[1];
			sensorName = command.split("#")[1].trim().split(" ")[2];
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			takenSamples = Integer.parseInt(takenSampleStr);
			interval = Integer.parseInt(intervalStr);
		} catch (NumberFormatException nfe) {
			System.err.println(nfe.getMessage());
			nfe.printStackTrace();
		}
		System.out.println("Execution Parameters ");
		System.out.println("Sensor: " + sensorName + " Taken Samples " + takenSamples + " Interval time " + interval);

	}
}
