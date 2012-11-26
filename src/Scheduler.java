/**
 * 
 */

/**
 * @author rohit
 *
 */

import engine.SchedulerEngine;

public class Scheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SchedulerEngine engine = new SchedulerEngine();
		
		// Start the scheduler engine
		System.out.println("Starting the scheduler engine");
		engine.start();
	}
}
