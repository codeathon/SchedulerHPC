/**
 * 
 */
package job.dispatcher;

import java.lang.management.ManagementFactory;
import java.util.Random;

import cluster.Cluster;
import job.queue.JobQueue;
import job.type.Job;
import job.type.Matrix;

/**
 * @author rohit
 *
 */
public class Dispatcher extends Thread {
	private JobQueue jobQueue;
	private static Dispatcher dispatcherInstance = null;
	static final java.lang.management.ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

	protected Dispatcher() {
	}
	
	public static Dispatcher getInstance() {
		if(dispatcherInstance == null)
			dispatcherInstance = new Dispatcher();
		return dispatcherInstance;
	}
	
	
	public void run() {
		while(true) {
			if(jobQueue.getQueue().size()!=0) {
				synchronized (jobQueue) {
					Job job = jobQueue.getQueue().remove();
					if(job.getJobType()==1) {
						Matrix tempjob = new Matrix();
					
						Random r = new Random();
						int randomMachine = r.nextInt(Cluster.machineList.size()-1) + 1;
						job.setMachineID(randomMachine);
						Cluster.returnMachine(randomMachine).getJobList().add(job);
						if(Cluster.returnMachine(randomMachine).getJobList().size() > 4 && !Cluster.returnUsableMachineList().contains(Cluster.returnMachine(randomMachine))) {
							Cluster.returnUsableMachineList().add(Cluster.returnMachine(randomMachine));
							System.out.println(randomMachine+" added to USABLE list");
						}
						
						System.out.println("Job added to machine: "+randomMachine);
						
						job.setJobState(2);
						// Set the Start Time
						long startTime = System.nanoTime()/1000000;
						job.setStartTime(startTime);
						
						System.out.println("Executing job "+job.getJobID());
						tempjob.execute();
						System.out.println("Successfully Executed job "+job.getJobID());
						
						// Set the jobState to "Finished"
						job.setJobState(3);
						
						// Set the End Time
						long endTime = System.nanoTime()/1000000;
						job.setEndTime(endTime);
						
						// Set the duration
						job.setDuration((job.getEndTime()-job.getStartTime())/1000);
						System.out.println("Duration: "+job.getDuration());
						// Calculate R
						job.calculateR();
						
						System.out.println("Job R: "+job.getR());
						
						// Update R for the Machine
						Cluster.returnMachine(randomMachine).calculateR();
						
						System.out.println("Updated Machine "+randomMachine+ " R: "+Cluster.returnMachine(randomMachine).getR());
					}
				}
			}
		}
	}

	/**
	 * @return the jobQueue
	 */
	public JobQueue getJobQueue() {
		return jobQueue;
	}

	/**
	 * @param jobQueue the jobQueue to set
	 */
	public void setJobQueue(JobQueue jobQueue) {
		this.jobQueue = jobQueue;
	}
}
