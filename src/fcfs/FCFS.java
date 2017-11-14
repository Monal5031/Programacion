/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfs;

/**
 *
 * @author fsociety
 */


 public class FCFS{


	public int averagetime() {

		return 0;

	}

	public void getWaitingTime(Process proc[],int n,double wT[]){

		int finishtime=0;
		wT[0]=0;
		finishtime =proc[0].burstTime+proc[0].arrivalTime;
		for(int i=1; i<n; i++)
		{
			if(proc[i].arrivalTime<finishtime){
				finishtime += proc[i].burstTime;
				wT[i]=finishtime-proc[i].arrivalTime;
	}
			else{
				finishtime=proc[i].arrivalTime + proc[i].burstTime;
				wT[i]=0;
			}



		}

	}
	public void getTurnAroundTime(Process proc[], int n, double wT[], double tT[])	// Method to calculate turn around time
	{
		for (int i = 0; i < n; i++) tT[i] = proc[i].burstTime + wT[i];
	}
	public void getAvgTime(Process proc[], int n)		// Method to calculate average time
	{
		double wT[] = new double[n], tT[] = new double[n];
		double totalTT = 0;
		double avgTT,v=0;
		getWaitingTime(proc, n, wT);			// Function to find waiting time of all processes
		getTurnAroundTime(proc, n, wT, tT);		// Function to find turn around time for all processes
		System.out.println("Process name "+" Turn around time "+" Waiting time ");
		for (int i = 0; i < n; i++)
		{						// Calculating total turnaround time
			totalTT+=tT[i];
			System.out.println(" " + proc[i].pid+"\t\t "+tT[i]+"\t\t"+wT[i]);
		}
		avgTT= totalTT / (double)n;
		for(int i=0;i<n;i++) v+=Math.pow(tT[i]-avgTT,2);
		System.out.println("Average turn around time = "+avgTT);
		System.out.println("Standard deviation for average turn around time = "+Math.pow(v/(double)n,0.5));
	}



}
