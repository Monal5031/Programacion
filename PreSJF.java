public class PreSJF {

	// Method to find the waiting time for all processes
	void getWaitingTime(Process[] process, int n, double[] waitingTime) {
		int[] remainingTIme = new int[n];
		int complete = 0, t = 0, min = Integer.MAX_VALUE;
		int shortest = 0, finishTime;
		boolean check = false;

		// Copy the burst time into remainingTime array
		for (int i = 0; i < n; i++) {
			remainingTIme[i] = process[i].bT;
		}

		// Process until all processes get completed
		while (complete != n) {
			// Finding process with min remaining time, among arrived processes till now
			for (int j = 0; j < n; ++j) {
				if ((process[j].aT <= t) && (remainingTIme[j] < min) && remainingTIme[j] > 0) {
					min = remainingTIme[j];
					shortest = j;
					check = true;
				}
			}

			if (check == false) {
				t++;
				continue;
			}

			// Reducing remaining time by one and updating min
			min = --remainingTIme[shortest];
			if (min == 0) {
				min = Integer.MAX_VALUE;
			}

			// If a process gets executed completely
			if (remainingTIme[shortest] == 0) {
				complete++;
				// Find finish time of current process
				finishTime = t+1;
				//Galvin Pg.107, 265
				waitingTime[shortest] =  finishTime
							-process[shortest].aT
							-process[shortest].bT
							+process[shortest].iI
							+process[shortest].iP;
				if (waitingTime[shortest] < 0) {
					waitingTime[shortest] = 0;
				}
			}
			// Incrementing time
			t++;
		}
	}

	// Method to calculate turn around time
	void getTurnAroundTime(Process process[], int n, double[] waitingTime, double[] turnAroundTime) {
		for (int i = 0; i < n; i++) {
			turnAroundTime[i] = process[i].bT + waitingTime[i];
		}
	}

	// Method to calculate average time
	void getAvgTime(Process[] process, int n) {
		double[] waitingTime = new double[n];
		double[] turnAroundTime = new double[n];
		double totalWT = 0, totalTT = 0;
		double avgTT, v = 0;
		// Function to find waiting time of all processes
		getWaitingTime(process, n, waitingTime);

		// Function to find turn around time for all processes
		getTurnAroundTime(process, n, waitingTime, turnAroundTime);

		System.out.println("Process name " + " Turn around time " + " Waiting time ");
		// Calculating total turnaround time
		for (int i = 0; i < n; ++i) {
			totalTT += turnAroundTime[i];
			System.out.println(" " + process[i].pid + "\t\t " + turnAroundTime[i] + "\t\t" + waitingTime[i]);
		}
		avgTT= totalTT / (double)n;
		for(int i = 0; i < n; ++i) {
			v += Math.pow(turnAroundTime[i] - avgTT, 2);
		}
		System.out.println("Average turn around time = " + avgTT);
		System.out.println("Standard deviation for average turn around time = " + Math.pow(v / (double)n, 0.5));
		}
}

