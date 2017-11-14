
import fcfs.FCFS;
import roundrobin.RoundRobin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import presjf.PreSJF;

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


		public static void callSJF()throws Exception {
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

	public static void callRR()throws Exception {
		ArrayList<roundrobin.Process> lc = new ArrayList<>();
		float currentTime=0;
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter a file name(.txt)");
		String path = "/home/fsociety/Desktop/Programacion/src/data/";
				String inp = sc.next();
		BufferedReader br = new BufferedReader( new FileReader (path+inp));
		String input;

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
		int quantum = 1;
				RoundRobin obj = new RoundRobin();
		obj.findIdleTime(lc,quantum);
		obj.findavgTime(lc, quantum);
	}

	public static void callFCFS()throws Exception {
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
			switch (sc.nextInt()) {
				case 1:
					callFCFS();
					break;
		case 2:
					// Run PreSJFTester
					callSJF();
					break;
		case 3:
					callRR();
					break;
		default:
					System.out.println("Invalid option.");
		}
	}

}
