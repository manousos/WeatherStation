package gr.manousos.sensor.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Execute sensors programs/scripts and read their output.
 * 
 * @author manousos
 *
 */
public class SensorExecutor {
	/**
	 * <ul>
	 * <li>First parameters is program name and its parameters.
	 * <li>Last -1 parameter is the total taken samples. Default is 1</li>
	 * <li>Last parameter is interval time (in seconds) between next
	 * sample.Default is 0 sec</li>
	 * </ul>
	 * {@code ./ProgramName param1 param2 .. paramN #5 3} The right part of #
	 * symbol is sensors command. The left part of # smbol is interval and
	 * samples number parameters
	 * 
	 * @param args,
	 *            the executed command @throws IOException @throws
	 *            InterruptedException @throws
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		long interval = 0;
		int takenSamples = 1;
		String command = String.join(" ", args);

		System.out.println(command);
		// Parse execution params
		String takenSampleStr = null, intervalStr = null;
		try {
			takenSampleStr = command.split("#")[1].trim().split(" ")[0];
			intervalStr = command.split("#")[1].trim().split(" ")[1];
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			takenSamples = Integer.parseInt(takenSampleStr);
			interval = Long.parseLong(intervalStr);
		} catch (NumberFormatException nfe) {
			System.err.println(nfe.getMessage());
			nfe.printStackTrace();
		}
		System.out.println("Execution Parameters ");
		System.out.println("Taken Samples " + takenSamples + " Interval time " + interval);

		try {
			for (int i = 0; i < takenSamples; i++) {
				String pythonOutput;
				Process p = Runtime.getRuntime().exec(command.split("#")[0].trim());

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

				while ((pythonOutput = stdInput.readLine()) != null) {
					System.out.println(pythonOutput);
				}
				while ((pythonOutput = stdError.readLine()) != null) {
					System.err.println(pythonOutput);
				}
				Thread.sleep(interval * 1000);
			}

			System.out.println("Good bye");
			System.exit(0);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
