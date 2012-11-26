/**
 * 
 */
package engine;

import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

import machine.Machine;
import cluster.Cluster;
import cluster.ClusterStats;

import job.dispatcher.Dispatcher;
import job.producer.Producer;
import job.queue.JobQueue;
import job.type.Job;

/**
 * @author rohit
 * Cretes threads to execute different parts of the scheduler
 */
public class SchedulerEngine extends Thread {
	private JobQueue jobQueue;
	private Dispatcher dispatcher;
	private Producer producer;
	private Cluster cluster;
	private ClusterStats clusterStats;
	
	/**
	 * @param
	 */
	public SchedulerEngine() {
	}
	
	public void run() {
		
		this.cluster = Cluster.getInstance();
		Cluster.machineList = (new ArrayList<Machine>());
		this.cluster.createCluster(5);
		Cluster.usableMachineList = new ArrayList<Machine>();
		
		this.jobQueue = JobQueue.getInstance();
		this.jobQueue.setQueue(new PriorityBlockingQueue<Job>());
		
		this.producer = Producer.getInstance();
		producer.setJobQueue(jobQueue);
		producer.start();
		
		this.dispatcher = Dispatcher.getInstance();
		dispatcher.setJobQueue(jobQueue);
		dispatcher.start();
		try {
			dispatcher.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		
		this.clusterStats = ClusterStats.getInstance();
		clusterStats.setMachineList(new ArrayList<Machine>());
		clusterStats.setUsableMachineList(new ArrayList<Machine>());
		clusterStats.start();*/
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

	/**
	 * @return the dispatcher
	 */
	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	/**
	 * @param dispatcher the dispatcher to set
	 */
	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	/**
	 * @return the producer
	 */
	public Producer getProducer() {
		return producer;
	}

	/**
	 * @param producer the producer to set
	 */
	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	/**
	 * @return the clusterStats
	 */
	public ClusterStats getClusterStats() {
		return clusterStats;
	}

	/**
	 * @param clusterStats the clusterStats to set
	 */
	public void setClusterStats(ClusterStats clusterStats) {
		this.clusterStats = clusterStats;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	
	
	
}
