package gr.manousos.iot.client;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Thin client. Reads sensors data and send to server via Rest service
 * 
 * @author manousos
 *
 */
public class WeatherStationClientApplication {

	/**
	 * <ul>
	 * <li>First parameters is program name and its parameters.
	 * <li>Last -2 parameter is the total taken samples. Default is 1</li>
	 * <li>Last -1parameter is interval time (in seconds) between next
	 * sample.Default is 0 sec</li>
	 * <li>Last parameter is sensor name</li>
	 * </ul>
	 * {@code ./ProgramName param1 param2 .. paramN #5 3 DHT22} The right part
	 * of # symbol is sensors command. The left part of # symbol is interval,
	 * samples number and sensor name.
	 * 
	 * @param args,
	 *            the executed command @throws IOException @throws
	 *            InterruptedException @throws
	 */
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		String command = String.join(" ", args);
		System.out.println(command);

		ExecuteSensor execute = new ExecuteSensor();
		execute.executeSensorProgram(command);

		new CallService(execute.getSamples(), execute.getSensorName()).doRestCall();
	}

}
