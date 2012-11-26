/**
 * 
 */
package machine;

/**
 * @author rohit
 * Simulates a machine on a cluster
 */
import java.util.ArrayList;
import java.util.Iterator;

import job.type.*;
public class Machine {
	private static int machineID=1;
	private int numberOfJobs;
	private int maxNumberOfJobs=10;
	private ArrayList<Job> jobList;
	
	// performance parameter
	private double R;
	
	// Power Usage parameter
	private int C;
	
	public Machine() {
		jobList = new ArrayList<Job>();
		machineID++;
	}
	
	/**
	 * @return the machineID
	 */
	public int getMachineID() {
		return machineID;
	}
	/**
	 * @return the numberOfJobs
	 */
	public int getNumberOfJobs() {
		return numberOfJobs;
	}
	/**
	 * @param numberOfJobs the numberOfJobs to set
	 */
	public void setNumberOfJobs(int numberOfJobs) {
		this.numberOfJobs = numberOfJobs;
	}
	/**
	 * @return the maxNumberOfJobs
	 */
	public int getMaxNumberOfJobs() {
		return maxNumberOfJobs;
	}
	/**
	 * @param maxNumberOfJobs the maxNumberOfJobs to set
	 */
	public void setMaxNumberOfJobs(int maxNumberOfJobs) {
		this.maxNumberOfJobs = maxNumberOfJobs;
	}

	public ArrayList<Job> getJobList() {
		return jobList;
	}

	public void setJobList(ArrayList<Job> jobList) {
		this.jobList = jobList;
	}

	public double getR() {
		return R;
	}

	public void setR(double r) {
		R = r;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}
	
	public void calculateR() {
		Iterator<Job> iter = jobList.iterator();
		double sumR=0,averageR;
		while(iter.hasNext()) {
			sumR+=iter.next().getR();
		}
		averageR=sumR/jobList.size();
		this.setR(averageR);
	}
	
	public void calculateC() {
		
	}
}