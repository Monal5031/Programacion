/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

/**
 *
 * @author fsociety
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class RoundRobin {

	static Queue<Process> gc = new LinkedList<>();
	static float idle=0;
	static ArrayList<Process> final_list = new ArrayList<>();

	public void findIdleTime(ArrayList<Process> lc, int quantum) {
		float curTime=0;
		for(int i=0;i<lc.size();i++){
			curTime+= Math.min(lc.get(i).totalExecutionTime , quantum);
			idle+=Math.max(0, lc.get(i).relTime - curTime);
	}
	}

	public void findWaitingTime(ArrayList<Process> lc, int quantum) {
		float t =0; // Current time
		Process p;
		int len = lc.size();
		// Keep traversing Processes in round robin manner
		// until all of them are not done.

		while(true) {
			boolean done = true;
			if (t == 0) {
				int i = 0;
				while(i < lc.size()) {
					p = lc.get(i);
					if(p.relTime <= t+quantum && p.relTime >= t) {
							gc.add(p);
							lc.remove(i);
					} else {
							break;
					}
				}
			}

			// Traverse all Processes one by one repeatedly
		for (int j = 0 ; j< gc.size(); j++) {
			if(t > 0){
				int i =0;
				while(i<lc.size()){
					p=lc.get(i);
					if(p.relTime<=t+quantum && p.relTime>=t){
						gc.add(p);
						lc.remove(i);
					} else {
					break;
					}
				}
			}
			p=gc.poll();
			// If burst time of a Process is greater than 0
			// then only need to Process further
			if (p.rem_bt > 0) {
				done = false; // There is a pending Process
				if (p.rem_bt > quantum){
					// Increase the value of t i.e. shows
					// how much time a Process has been Processed
					t += quantum;
					// Decrease the burst_time of current Process
					// by quantum
					p.rem_bt -= quantum;
					gc.add(p);
				} else {
				// If burst time is smaller than or equal to
				// quantum. Last cycle for this Process
					// Increase the value of t i.e. shows
					// how much time a Process has been Processed
					t = t + p.rem_bt;
					// Waiting time is current time minus time
					// used by this Process
					p.waitingTime = t - p.totalExecutionTime + p.waitingTime;
					// As the Process gets fully executed
					// make its remaining burst time = 0
					p.rem_bt = 0;
					final_list.add(p);
				}
			}
			t += 0;
		}
		// If all Processes are done
		if (done == true && final_list.size() == len) {
			break;
		} else if (final_list.size() < len) {
				t++;
				if (lc.size() > 0 && lc.get(0).relTime == t) {
					gc.add(lc.get(0));
				}
			}
		}
	}

	// Method to calculate turn around time
	public void findTurnAroundTime(Queue<Process> gc) {
		// calculating turnaround time by adding burst time and waiting time
		Process p=null;


		for (int i = 0; i < final_list.size() ; i++){

			final_list.get(i).tat = final_list.get(i).totalExecutionTime + final_list.get(i).waitingTime;

	}
}

	// Method to calculate average time
	public void findavgTime(ArrayList<Process> lc,int quantum)throws Exception {

		float total_wt = 0;
		float total_tat = 0;

		// Function to find waiting time of all Processes
		findWaitingTime(lc, quantum);

		// Function to find turn around time for all Processes
		findTurnAroundTime(gc);

		// Calculate total waiting time and total turn
		// around time
		Process p;

		for (int i=0; i<final_list.size(); i++) {
			total_wt = total_wt + final_list.get(i).waitingTime;
			total_tat = total_tat + final_list.get(i).tat;
		}
				double avgTurnAroundTime = (double)total_wt / (double)final_list.size();
				double avgWaitTime = (double)total_tat / (double) final_list.size();
				double standardDeviation = 0;
				for (int i = 0; i < final_list.size(); i++) {
					standardDeviation += Math.pow(Math.abs(final_list.get(i).tat - avgTurnAroundTime), 2);
				}

				FileWriter outFile = new FileWriter("/home/fsociety/Desktop/Programacion/output.txt");
				BufferedWriter bWriter = new BufferedWriter(outFile);
				bWriter.write(quantum+" ");
				bWriter.write(avgWaitTime+" ");
				bWriter.write(avgTurnAroundTime+"\n");
		System.out.println("Average waiting time = " + avgTurnAroundTime);
		System.out.println("Average turn around time = " + avgWaitTime);
				System.out.println("Standard Deviation for average turn around time is: "+
						Math.pow((standardDeviation/(double)final_list.size()),0.5));
	}
}
