/**
 * 
 */
package job.type;

/**
 * @author rohit
 * Describes the job
 * jobState = 0 -> New job
 * 			= 1 -> Queued job
 * 			= 2 -> Running job
 * 			= 3 -> Finished job
 */
public class Job implements Comparable{
	private int machineID;
	protected static int jobID;
	protected double userTime=2.0;
	protected double SLATime=0.5;
	protected double startTime;
	protected double endTime;
	protected double waitTime;
	protected double duration;
	protected int jobType;
	private int jobState = 0;
	private double R;
	private int C;
	
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

	/**
	 * @return 
	 * 
	 */
	
	public void execute() {
	}
	
	public Job() {
		++jobID;
	}

	public Job(int jobType) {
		this.jobType = jobType;
	}
	
	/**
	 * @return the jobID
	 */
	public int getJobID() {
		return jobID;
	}

	/**
	 * @return the userTime
	 */
	public double getUserTime() {
		return userTime;
	}

	/**
	 * @param userTime the userTime to set
	 */
	public void setUserTime(double userTime) {
		this.userTime = userTime;
	}

	/**
	 * @return the sLATime
	 */
	public double getSLATime() {
		return SLATime;
	}

	/**
	 * @param time the sLATime to set
	 */
	public void setSLATime(double time) {
		SLATime = time;
	}

	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the waitTime
	 */
	public double getWaitTime() {
		return waitTime;
	}

	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(double waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
/*	
	public void toString(Job job) {
		System.out.println("Job ID: "+job.getJobID());
		System.out.println("Job Start Time: "+job.getStartTime());
		System.out.println("Job End Time "+job.getEndTime());
		System.out.println("Job Duration "+job.getDuration());
		System.out.println("Job SLA "+job.getSLATime());
		System.out.println("Job User Time "+job.getUserTime());
	}*/

	/**
	 * @return the jobType
	 */
	public int getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(int jobType) {
		this.jobType = jobType;
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	public int getJobState() {
		return jobState;
	}

	public void setJobState(int jobState) {
		this.jobState = jobState;
	}
	
	public void changeJobState(int newState) {
		this.setJobState(newState);
	}
	
	// Using soft calculation for the value of R
	// Sets the value of R between 0 & 100
	public synchronized void calculateR() {
		this.setR(Math.min(100,((((1+this.getSLATime())*(this.getUserTime())*100.0))/this.getDuration())));
	}

	public int getMachineID() {
		return machineID;
	}

	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	
}