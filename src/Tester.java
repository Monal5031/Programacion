
import fcfs.FCFS;
import roundrobin.RoundRobin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import presjf.PreSJF;
import roundrobin.Process;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fsociety
 */
public class Tester {


	public void callSJF()throws Exception {
			presjf.Process[] process = new presjf.Process[10];
		Scanner sc = new Scanner(System.in);
		int len = 0,relativeArrivalTime;
		System.out.println("Enter a file name(.txt)");
				String inp = sc.next();
		String file = "/home/fsociety/Desktop/Programacion/src/data/" + inp;

		// creating an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(file));
		// read the first line from the text file
		String line = br.readLine();
		// 'to keep the relative arrival time of the first process
		String[] pD2 = line.split("\t");
		// equal to its actual arrival time'
		relativeArrivalTime = Integer.parseInt(pD2[1]);
		// loop until all lines are read
		while (line != null) {
			// using split() to load string to array, separated by ','
			String[] pD = line.split("\t");
			process[len] = new presjf.Process(pD, relativeArrivalTime);
			// saving relative arrival time for next process
			relativeArrivalTime = process[len].arrivalTime;
			len++;
			line = br.readLine();
		}
				PreSJF ob = new PreSJF();

		ob.getAvgTime(process, len);
			   // System.out.print("yeye\n");
		}
		public ArrayList<roundrobin.Process> readData(String inp)throws Exception {
			ArrayList<roundrobin.Process> lc = new ArrayList();
			String path = "/home/fsociety/Desktop/Programacion/src/data/";
			BufferedReader br = new BufferedReader( new FileReader (path+inp));
			String input;
			float currentTime=0;
			roundrobin.Process p;
			while((input=br.readLine()) != null){
					String in[]=input.split("\t");
					int at=Integer.parseInt(in[1]);
					float bt=Float.parseFloat(in[2]);
					float wt=Float.parseFloat(in[4]);
					int prio=Integer.parseInt(in[5]);
					float rem_bt=Float.parseFloat(in[2]);
					p = new roundrobin.Process(in[0],at,bt,wt,prio,rem_bt);
					if(lc.isEmpty()){
							currentTime=p.arrivalTime;
					}
					p.relTime=currentTime + p.arrivalTime;
					//System.out.println(p.relTime + "$");
					currentTime+=p.arrivalTime;
					lc.add(p);
			}
			br.close();
			return lc;
		}
	public void callRR()throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file name(.txt)");
		String inp = sc.next();
				PrintWriter writer = new PrintWriter("/home/fsociety/Desktop/Programacion/output.txt","UTF-8");
				for (int i = 0; i < 10; ++i) {
					System.out.println("Enter "+(i+1)+"th quantum");
					int quantum = sc.nextInt();
					RoundRobin obj = new RoundRobin();
					ArrayList<roundrobin.Process> temp;
					temp = readData(inp);
					obj.findIdleTime(temp,quantum);
					obj.findavgTime(temp, quantum);
					writer.println(quantum+" "+obj.waitTime+" "+obj.turnAroundTime);
				}
				writer.close();
	}

	public void callFCFS()throws Exception {
		fcfs.Process[] process = new fcfs.Process[10];
		Scanner sc = new Scanner(System.in);
		int len = 0,relativeArrivalTime;
		System.out.println("Enter a file name(.txt)");
		String inp = sc.next();
		String file = "/home/fsociety/Desktop/Programacion/src/data/" + inp;

		// creating an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(file));
		// read the first line from the text file
		String line = br.readLine();
		// 'to keep the relative arrival time of the first process
		String[] pD2 = line.split("\t");
		// equal to its actual arrival time'
		relativeArrivalTime = Integer.parseInt(pD2[1]);
		// loop until all lines are read
		while (line != null) {
				// using split() to load string to array, separated by ','
				String[] pD = line.split("\t");
				process[len] = new fcfs.Process(pD, relativeArrivalTime);
				// saving relative arrival time for next process
				relativeArrivalTime = process[len].arrivalTime;
				len++;
				line = br.readLine();
		}
		FCFS ob = new FCFS();
		ob.getAvgTime(process, len);
	}
	/**
	 * @param args the command line arguments
	 * @throws java.lang.Exception
	 */
	public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);

			/* ---Algorithm selection and execution--- */
			System.out.println("Choose an algorithm:");
			System.out.println("1. First-Come, First-Served Scheduling");
			System.out.println("2. Shortest-Job-First(Preemptive) Scheduling");
			System.out.println("3. Round-Robin Scheduling");
			Tester test = new Tester();
			switch (sc.nextInt()) {
					case 1:
							test.callFCFS();
							break;
					case 2:
							test.callSJF();
							break;
					case 3:
							test.callRR();
							break;
					default:
							System.out.println("Invalid option.");
			}
	}

}
