class Process {
	private String pid;   // Process ID
	private int aT,bT,p;  // arrival, burst, priority 
	private double iI,iP; // I/O interrupt, I/O processing(waiting)

	public Process(String[] metaData, int relativeArrivalTime) {   
		this.pid = metaData[0];
			// Calculating actual arrival time from relative arrival time
		this.aT = relativeArrivalTime + Integer.parseInt(metaData[1]);
		this.bT = Integer.parseInt(metaData[2]);
		this.iI = Double.parseDouble(metaData[3]);
		this.iP = Double.parseDouble(metaData[4]);
		this.p = Integer.parseInt(metaData[5]);
	}
}
