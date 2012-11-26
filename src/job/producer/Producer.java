/**
 * 
 */
package job.producer;

import job.queue.JobQueue;
import job.type.Job;

/**
 * @author rohit
 *
 */
public class Producer extends Thread{
	private JobQueue jobQueue;
	private static Producer producerInstance = null;
	
	protected Producer() {
		
	}
	
	public static Producer getInstance() {
		if(producerInstance == null)
			producerInstance = new Producer();
		return producerInstance;
	}
	
	public void run() {
		while(jobQueue.getQueue().size() <= jobQueue.getMaxJobs()) {
			synchronized (jobQueue) {
				
				// Create a new job
				System.out.println("Creating a new job");
				Job job =  new Job();
				System.out.println("New job created: "+job.getJobID());
				
				// Set the various parameters of the job before queuing
				job.setJobType(1);
				
				// Add the job to the queue
				System.out.println("Enquing the job into the queue");
				jobQueue.getQueue().add(job);
				
				// Set the jobState to "Queued"
				job.setJobState(1);
				
				System.out.println("Job "+job.getJobID()+" enqueued successfully");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
