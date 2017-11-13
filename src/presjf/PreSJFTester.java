package presjf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PreSJFTester {

	public static void main(String[] args) throws IOException {
		/* ---Reading from file and process creation--- */
		Process[] process = new Process[10];
		Scanner sc = new Scanner(System.in);
		int len = 0,relativeArrivalTime;
		System.out.println("Enter a file name(.txt)");
		String file = "/home/fsociety/Desktop/Programacion/src/data/" + "ProInfo.txt";

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
			process[len] = new Process(pD, relativeArrivalTime);
			// saving relative arrival time for next process
			relativeArrivalTime = process[len].arrivalTime;
			len++;
			line = br.readLine();
		}
                PreSJF ob = new PreSJF();
		ob.getAvgTime(process, len);
				
	}
}
