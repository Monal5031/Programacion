/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoundRobin;

/**
 *
 * @author fsociety
 */
class Process{
	String name;
	int arrivalTime;
	float totalExecutionTime;
	float waitingTime;
	int priority;
	float rem_bt;
	float tat;
	float relTime;

	Process(String name, int arrivalTime,float burstTime,
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

