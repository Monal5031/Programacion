package fcfs;

import presjf.*;

public class Process {
	public String pid;	 // Process ID
	public int arrivalTime, burstTime, priority;  // arrival, burst, priority
	public double ioInterrupt, ioProcessing; // I/O interrupt, I/O processing(waiting)

	public Process(String[] metaData, int relativeArrivalTime) {
		this.pid = metaData[0];
			// Calculating actual arrival time from relative arrival time
		this.arrivalTime = relativeArrivalTime + Integer.parseInt(metaData[1]);
		this.burstTime = Integer.parseInt(metaData[2]);
		this.ioInterrupt = Double.parseDouble(metaData[3]);
		this.ioProcessing = Double.parseDouble(metaData[4]);
		this.priority = Integer.parseInt(metaData[5]);
	}
}
