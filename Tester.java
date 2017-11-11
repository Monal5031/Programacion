import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

class Tester
{
	public static void main(String args[])throws IOException
	{
		/* ---Reading from file and process creation--- */
		Process process[]=new Process[10];
		Scanner sc=new Scanner(System.in); 
		int len=0,rAT; 
		System.out.println("Enter a file name(.txt)");  
		String file=sc.next();   
		Path pathToFile = Paths.get(file);
        	BufferedReader br=new BufferedReader(new FileReader(file)); // creating an instance of BufferedReader
        	String line = br.readLine();				  // read the first line from the text file   
        	String[] pD2 = line.split("\t");		  // 'to keep the relative arrival time of the first process 
        	rAT=Integer.parseInt(pD2[1]);       		  // equal to its actual arrival time'
            	while (line != null) {				  // loop until all lines are read
                	String[] pD = line.split("\t");		  // using split() to load string to array, separated by ','
			process[len]= new Process(pD, rAT);	
			rAT=process[len].aT;			  // saving relative arrival time for next process 
			len++;
			line = br.readLine();
            	}
            	/* ---Algorithm selection and execution--- */
            	System.out.println("Choose an algorithm:");
            	System.out.println("1. First-Come, First-Served Scheduling");
            	System.out.println("2. Shortest-Job-First(Preemptive) Scheduling");
            	System.out.println("3. Round-Robin Scheduling");
            	
            	switch(sc.nextInt()){
            		case 1: 
            			break;
            		case 2: PreSJF ob=new PreSJF();
        			ob.getAvgTime(process, len);
        			break;
        		case 3:
        			break;
        		default: 
        			System.out.println("You gotta be kidding me!");
        	}            	
	}
}
