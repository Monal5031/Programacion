class Process
{
    String pid;   // Process ID
    int aT,bT,p;  // arrival, burst, priority 
    double iI,iP; // I/O interrupt, I/O processing(waiting)
    
    public Process(String[] metadata, int rAT)
    {   
        this.pid = metadata[0];
        this.aT = rAT+Integer.parseInt(metadata[1]);	//calculating actual arrival time from relative arrival time
        this.bT = Integer.parseInt(metadata[2]);
        this.iI = Double.parseDouble(metadata[3]);
        this.iP = Double.parseDouble(metadata[4]);
        this.p = Integer.parseInt(metadata[5]);
    }
}
