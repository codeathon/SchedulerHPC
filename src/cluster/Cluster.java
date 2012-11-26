/**
 * 
 */
package cluster;

import java.util.ArrayList;

import machine.Machine;

/**
 * @author rohit
 * Simulates a cluster with a list of Machines/nodes
 */
public class Cluster {
	public static ArrayList<Machine> machineList;
	public static ArrayList<Machine> usableMachineList;
	private static Cluster clusterInstance = null;
	private int R;
	private int C;
	
	public ArrayList<Machine> getMachineList() {
		return machineList;
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

	public Cluster() {
	}
	
	public static Cluster getInstance() {
		if(clusterInstance == null)
			clusterInstance = new Cluster();
		return clusterInstance;
	}
	
	public void createCluster(int numberOfNodes) {
		for(int i=0;i<numberOfNodes;i++) {
			Machine machine = new Machine();
			machineList.add(machine);
		}
	}
	
	public static Machine returnMachine(int machineID) {
		return machineList.get(machineID);
	}
	
	public static ArrayList<Machine> returnUsableMachineList() {
		return usableMachineList;
	}
	
}

