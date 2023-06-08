import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PS {
	
	private int burst = 0, arrival = 0, priority = 0, pID = 0;		//private instance variables 
	
	public PS(int burst, int arrival, int priority, int pID) {		//process constructor
		this.burst = burst;
		this.arrival = arrival;
		this.priority = priority;
		this.pID = pID;
	}
	
	public int getArr() {		//get methods for each attribute
		return arrival;	
	}
	
	public int getBurst() {
		return burst;
	}
	
	public int getID() {
		return pID;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public static double avgWait(ArrayList <PS> list) {
		double avgWait1 = 0;
		int [] wait = new int[list.size()];	//create a wait time array that has the size of the burst array
		int fwait = 0;
		wait[0] = 0;		 			//first process wait time is 0
		wait[1] = list.get(0).getBurst();	//second process wait time is the burst time of the first
		
		for(int i = 2; i < list.size(); i++) {		//calculate the rest by adding the wait time of the previous with the burst of the previous
			    wait[i] += wait[i-1] + list.get(i-1).getBurst();
		}
		for (int i =0; i < list.size(); i++) {		//add all the wait times to a single integer variable
			fwait += wait[i];
		}				
		avgWait1 = fwait / list.size();		//find average 
		
		return avgWait1;
	}
	
	public static double avgTAT(ArrayList <PS> list) {
		double avgTAT = 0;
		int tat = 0;
		int [] turn = new int[list.size()];	//create a turn around time array with the same size as the burst times array
		turn[0] = list.get(0).getBurst();						//first turn around time is the same as the first burst time
		for(int i = 1; i < list.size(); i++) {
			turn[i] = Math.abs((turn[i-1] + list.get(i).getBurst()) - list.get(i).getArr());	   //turn around time is time taken to complete 
		}
		for(int i =0; i<list.size(); i++) {	//add all the turn around times
			tat += turn[i];
		}
		avgTAT = tat / list.size();		     //find average
		return avgTAT;
	}
  
  public static void main(String [] args) {
		
		Random rand = new Random();
		int arr1 = rand.nextInt(101), arr2 = rand.nextInt(101), arr3 = rand.nextInt(101), arr4 =rand.nextInt(101), arr5 =rand.nextInt(101);
		
		PS p1 = new PS(20,arr1,2,1);
		PS p2 = new PS(25,arr2,4,2);		//declare the processes with the correct 
		PS p3 = new PS(25,arr3,3,3);
		PS p4 = new PS(15,arr4,3,4);
		PS p5 = new PS(10,arr5,1,5);
		
		ArrayList<PS> list = new ArrayList<PS>(5);		//process ArrayList
			list.add(p1);
			list.add(p2);			//append processes
			list.add(p3);
			list.add(p4);
			list.add(p5);
			
		Collections.sort(list, new CustomComparator());		//sort the list based on arrival times

System.out.println("PS:");
System.out.println("T"+list.get(0).getID()+"[0"+"-"+list.get(0).getBurst()+"]");
System.out.println("T"+list.get(1).getID()+"["+list.get(0).getBurst()+"-"+(list.get(0).getBurst()+list.get(1).getBurst())+"]");
System.out.println("T"+list.get(2).getID()+"["+(list.get(0).getBurst()+list.get(1).getBurst())+"-"+(list.get(0).getBurst()+list.get(1).getBurst()+list.get(2).getBurst())+"]");
System.out.println("T"+list.get(3).getID()+"["+(list.get(0).getBurst()+list.get(1).getBurst()+list.get(2).getBurst())+"-"+(list.get(0).getBurst()+list.get(1).getBurst()+list.get(2).getBurst()+list.get(3).getBurst())+"]");
System.out.println("T"+list.get(4).getID()+"["+(list.get(0).getBurst()+list.get(1).getBurst()+list.get(2).getBurst()+list.get(3).getBurst())+"-"+(list.get(0).getBurst()+list.get(1).getBurst()+list.get(2).getBurst()+list.get(3).getBurst()+list.get(4).getBurst())+"]");
System.out.println("Avg wait time: "+ avgWait(list));
System.out.println("Avg. turnaround time: "+avgTAT(list));
			
		}
}