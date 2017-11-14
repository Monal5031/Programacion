/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

/**
 *
 * @author fsociety
 */
public class Process{
	public String name;
	public int arrivalTime;
	public float totalExecutionTime;
	public float waitingTime;
	public int priority;
	public float rem_bt;
	public float tat;
	public float relTime;

	public Process(String name, int arrivalTime,float burstTime,
			float waitingTime,int priortiy,float rbt){
		this.tat = 0;
		this.relTime = 0;
		this.name = name;
		this.arrivalTime=arrivalTime;
		this.totalExecutionTime=burstTime;
		this.waitingTime=waitingTime;
		this.priority = priority;
		this.rem_bt=rbt;
	}

}

