import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tester {

	public static void main(String[] args) throws IOException {
		/* ---Reading from file and process creation--- */
		Process[] process = new Process[10];
		Scanner sc = new Scanner(System.in);
		int len = 0,relativeArrivalTime;
		System.out.println("Enter a file name(.txt)");
		String file = "data/" + sc.next();

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

		/* ---Algorithm selection and execution--- */
		System.out.println("Choose an algorithm:");
		System.out.println("1. First-Come, First-Served Scheduling");
		System.out.println("2. Shortest-Job-First(Preemptive) Scheduling");
		System.out.println("3. Round-Robin Scheduling");
		switch (sc.nextInt()) {
			case 1:
				break;
			case 2:
				PreSJF ob = new PreSJF();
				ob.getAvgTime(process, len);
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid option.");
		}
	}
}
