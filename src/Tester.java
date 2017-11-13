
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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            /* ---Algorithm selection and execution--- */
		System.out.println("Choose an algorithm:");
		System.out.println("1. First-Come, First-Served Scheduling");
		System.out.println("2. Shortest-Job-First(Preemptive) Scheduling");
		System.out.println("3. Round-Robin Scheduling");
                switch (sc.nextInt()) {
			case 1:
				break;
			case 2:
				// Run PreSJFTester
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid option.");
		}
	}

}
