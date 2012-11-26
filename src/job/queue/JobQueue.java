/**
 * 
 */
package job.queue;

import java.util.concurrent.PriorityBlockingQueue;

import job.type.Job;

/**
 * @author rohit
 */
public class JobQueue {
	private int maxJobs = 150;
	private PriorityBlockingQueue<Job> queue;
	private static JobQueue instance = null;
	
	/**
	 * @return the jobQueue
	 */
	public PriorityBlockingQueue<Job> getQueue() {
		return this.queue;
	}

	/**
	 * @param jobQueue the jobQueue to set
	 */
	public void setQueue(PriorityBlockingQueue<Job> jobQueue) {
		this.queue = jobQueue;
	}

	/**
	 * 
	 */
	protected JobQueue() {
	}

	public static JobQueue getInstance() {
		if(instance == null) {
			instance = new JobQueue();
		}
		return instance;
	}

	/**
	 * @return the maxJobs
	 */
	public int getMaxJobs() {
		return maxJobs;
	}

	/**
	 * @param maxJobs the maxJobs to set
	 */
	public void setMaxJobs(int maxJobs) {
		this.maxJobs = maxJobs;
	}
}