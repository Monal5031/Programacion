public class PreSJF
{   
    void getWaitingTime(Process proc[], int n, double wT[]) // Method to find the waiting time for all processes
    {
        int rT[] = new int[n];
        int complete = 0, t = 0, min = Integer.MAX_VALUE;
        int shortest = 0, finishTime;
        boolean check = false;
     
        for (int i = 0; i < n; i++) rT[i] = proc[i].bT; // Copy the burst time into rT[]            
        while (complete != n)
        {		                		// Process until all processes get completed
            for (int j = 0; j < n; j++) 		// Finding process with min remaining time, among arrived processes till now
            {
                if ((proc[j].aT <= t) && (rT[j] < min) && rT[j] > 0) 
                {
                    min = rT[j];
                    shortest = j;
                    check = true;
                }
            }     
            if (check == false)
            {
                t++;
                continue;
            }            				         
            min = --rT[shortest];			// Reducing remaining time by one and updating min
            if (min == 0) min = Integer.MAX_VALUE;           
            if (rT[shortest] == 0) 
            {						// If a process gets executed completely             
                complete++;				               
                finishTime = t+1;			// Find finish time of current process                
                wT[shortest] = finishTime-(proc[shortest].aT)-(proc[shortest].bT)+
                	                  (proc[shortest].iI)+(proc[shortest].iP);           //Galvin Pg.107,265             
                if (wT[shortest] < 0) wT[shortest] = 0;
            }            
            t++;					// Incrementing time
        }
    }
        
    void getTurnAroundTime(Process proc[], int n, double wT[], double tT[])	// Method to calculate turn around time
    {
        for (int i = 0; i < n; i++) tT[i] = proc[i].bT + wT[i];
    } 
       
    void getAvgTime(Process proc[], int n)		// Method to calculate average time
    {
        double wT[] = new double[n], tT[] = new double[n];
        double  totalWT = 0, totalTT = 0; 
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
        System.out.println("Standard deviation for average turn around time = "+Math.pow(v/(double)n, 												      0.5));                            
    }
}

