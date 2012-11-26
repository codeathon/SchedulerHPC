/**
 * 
 */
package cluster;

import java.util.ArrayList;

import machine.Machine;

/**
 * @author rohit
 * Might be used to collect Cluster stats
 */
public class ClusterStats extends Thread{
	private ArrayList<Machine> machineList;
	private ArrayList<Machine> usableMachineList;
	private int R;
	private int C;
	
	private static ClusterStats clusterStatsInstance = null;
	
	protected ClusterStats() {
	}
	
	public static ClusterStats getInstance() {
		if(clusterStatsInstance == null)
			clusterStatsInstance = new ClusterStats();
		return clusterStatsInstance;
	}

	/**
	 * @return the machineList
	 */
	public ArrayList<Machine> getMachineList() {
		return machineList;
	}

	/**
	 * @param machineList the machineList to set
	 */
	public void setMachineList(ArrayList<Machine> machineList) {
		this.machineList = machineList;
	}

	/**
	 * @return the usableMachineList
	 */
	public ArrayList<Machine> getUsableMachineList() {
		return usableMachineList;
	}

	/**
	 * @param usableMachineList the usableMachineList to set
	 */
	public void setUsableMachineList(ArrayList<Machine> usableMachineList) {
		this.usableMachineList = usableMachineList;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}
	
	public void calculateR() {

	}	
}
