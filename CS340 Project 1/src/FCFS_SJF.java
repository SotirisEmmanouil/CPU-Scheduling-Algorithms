import java.util.Arrays;
import java.util.Random;

public class FCFS_SJF {

	public static double avgWait(int [] burst) {
		double avgWait1 = 0;
		int [] wait = new int[burst.length];	//create a wait time array that has the size of the burst array
		int fwait = 0;
		wait[0] = 0;		 //first process wait time is 0
		wait[1] = burst[0];	//second process wait time is the burst time of the first
		
		for(int i = 2; i < burst.length; i++) {		//calculate the rest by adding the wait time of the previous with the burst of the previous
			    wait[i] += wait[i-1] + burst[i-1];
		}
		for (int i =0; i < burst.length; i++) {		//add all the wait times to a single int variable
			fwait += wait[i];
		}				
		avgWait1 = fwait / burst.length;		//find average 
		
		return avgWait1;
	}
	
	public static double avgTAT(int [] burst) {
		double avgTAT = 0;
		int tat =0;
		int [] turn = new int[burst.length];	//create a turn around time array with the same size as the bursttimes array
		turn[0] = burst[0];						//first turn around time is the same as the first burst time
		for(int i = 1; i < burst.length; i++) {
			turn[i] = turn[i-1] + burst[i];	   //turn around time is time taken to complete (all processes arrived at time 0)
		}
		for(int i =0; i<burst.length; i++) {	//add all the turn around times
			tat += turn[i];
		}
		avgTAT = tat / burst.length;		//find average
		return avgTAT;
	}


	public static void main(String [] args) {
		
		int [] burstTimes = {20,25,25,15,10}, SJF = burstTimes.clone();		//clone the burst time array
		Arrays.sort(SJF);	//sort it so the shortest jobs are done first
		int two = burstTimes[0]+burstTimes[1];
		int three =burstTimes[0]+burstTimes[1]+burstTimes[2];
		int four = burstTimes[0]+burstTimes[1]+burstTimes[2]+burstTimes[3];
		int five = burstTimes[0]+burstTimes[1]+burstTimes[2]+burstTimes[3]+burstTimes[4];
		int two2 = SJF[0]+SJF[1],three2 = SJF[0]+SJF[1]+SJF[2],four2 = SJF[0]+SJF[1]+SJF[2]+SJF[3], five2 = SJF[0]+SJF[1]+SJF[2]+SJF[3]+SJF[4];

System.out.println("FCFS:"); //Gantt chart and times
System.out.println("T1[0-"+burstTimes[0]+"], T2["+burstTimes[0]+"-"+two+"], T3["+two+"-"+three+"], T4["+three+"-"+four+"], T5["+four+"-"+five+"]");	
System.out.println("Avg. waiting time: "+ avgWait(burstTimes));
System.out.println("Avg. turnaround time: "+avgTAT(burstTimes)+"\n");

System.out.println("SJF:"); //Gantt chart and times
System.out.println("T5[0-"+SJF[0]+"], T4["+SJF[0]+"-"+two2+"], T1["+two2+"-"+three2+"], T2["+three2+"-"+four2+"], T3["+four2+"-"+five2+"]");
System.out.println("Avg. waiting time: "+ avgWait(SJF));
System.out.println("Avg. turnaround time: "+ avgTAT(SJF));
	}
	
}