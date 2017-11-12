public class PreSJF {

	// Method to find the waiting time for all processes 
	void getWaitingTime(Process process[], int n, double wT[]) {
		int rT[] = new int[n];
		int complete = 0, t = 0, min = Integer.MAX_VALUE;
		int shortest = 0, finishTime;
		boolean check = false;

		// Copy the burst time into rT[]
		for (int i = 0; i < n; i++) {
			rT[i] = process[i].bT;
		}

		// Process until all processes get completed
		while (complete != n) {
			// Finding process with min remaining time, among arrived processes till now
			for (int j = 0; j < n; ++j) {
				if ((process[j].aT <= t) && (rT[j] < min) && rT[j] > 0) {
					min = rT[j];
					shortest = j;
					check = true;
				}
			}

			if (check == false) {
				t++;
				continue;
			}

			// Reducing remaining time by one and updating min
			min = --rT[shortest];
			if (min == 0) {
				min = Integer.MAX_VALUE;           
			}

			// If a process gets executed completely
			if (rT[shortest] == 0) {
				complete++;
				// Find finish time of current process
				finishTime = t+1;
				//Galvin Pg.107, 265
				wT[shortest] = finishTime-(process[shortest].aT)-(process[shortest].bT)+
								(process[shortest].iI)+(process[shortest].iP);
				if (wT[shortest] < 0) {
					wT[shortest] = 0;
				}
			}
			// Incrementing time
			t++;
		}
	}

	// Method to calculate turn around time
	void getTurnAroundTime(Process process[], int n, double wT[], double tT[]) {
		for (int i = 0; i < n; i++) {
			tT[i] = process[i].bT + wT[i];
		}
	}

	// Method to calculate average time
	void getAvgTime(Process process[], int n) {
		double[] wT = new double[n];
		double[] tT = new double[n];
		double totalWT = 0, totalTT = 0;
		double avgTT,v=0;
		// Function to find waiting time of all processes
		getWaitingTime(process, n, wT);
		// Function to find turn around time for all processes
		getTurnAroundTime(process, n, wT, tT);
		System.out.println("Process name "+" Turn around time "+" Waiting time ");
		// Calculating total turnaround time
		for (int i = 0; i < n; i++) {
			totalTT += tT[i];
			System.out.println(" " + process[i].pid+"\t\t "+tT[i]+"\t\t"+wT[i]);
		}
		avgTT= totalTT / (double)n;
		for(int i=0;i<n;i++) {
			v+=Math.pow(tT[i]-avgTT,2);
		}
		System.out.println("Average turn around time = " + avgTT);
		System.out.println("Standard deviation for average turn around time = "+Math.pow(v / (double)n, 0.5));
		}
}
