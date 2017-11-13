/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoundRobin;

import static RoundRobin.RoundRobin.findIdleTime;
import static RoundRobin.RoundRobin.findavgTime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author fsociety
 */
public class RRTester {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Process> lc = new ArrayList<>();
        float currentTime=0;
        String path = "/home/fsociety/Desktop/Programacion-local/src/data/";
    	BufferedReader br = new BufferedReader( new FileReader (path+"pTest.txt"));
    	String input;
    	
    	Process p;
    	while((input=br.readLine()) != null){
    		String in[]=input.split(" ");
    		int at=Integer.parseInt(in[1]);
    		float bt=Float.parseFloat(in[2]);
    		float wt=Float.parseFloat(in[4]);
    		int prio=Integer.parseInt(in[5]);
    		float rem_bt=Float.parseFloat(in[2]);
    		p = new Process(in[0],at,bt,wt,prio,rem_bt);
    		if(lc.isEmpty()){
    			currentTime=p.arrivalTime;
    		}
    		p.relTime=currentTime + p.arrivalTime;
    		System.out.println(p.relTime + "$");
    		currentTime+=p.arrivalTime;
    		lc.add(p);
        }
        int quantum = 1;
        findIdleTime(lc,quantum);
        findavgTime(lc, quantum);
    }
    
}
