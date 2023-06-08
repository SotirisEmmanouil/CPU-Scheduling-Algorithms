public class RR {
	
	  public static void main(String[] args) {
		   
		    int[] burstTimes = {20, 25, 25, 15, 10};
		    int[] t1 = new int[2], t2 = new int[3], t3 = new int[3], t4 = new int[2], t5 = new int[1];
		    int i = 0, turn1 = 0, turn2 = 0, turn3 = 0, turn4 = 0, turn5 = 0, quant = 10, wait1 =0, wait2 = 0, wait3 =0, wait4 =0, wait5 = 0;
		    double avgTurn = 0, avgWait = 0;
		    
		    if(burstTimes[0] > quant) {				//if the burst time is greater than the time quantum
		    	while(burstTimes[0] > quant) {   	 //while it is true
		    		
		    		t1[i] = quant; 					 // t1[i] becomes the result of bursttime - quant
		    		burstTimes[0]-= quant;			//actually calculate the remaining burst time
		    		i++;							//increment i 
		    		
		    		if(burstTimes[0] <= quant) {		//if the burst time becomes less than the time quantum, append to the array
		    			t1[i] = burstTimes[0];			
		    			burstTimes[0]-= burstTimes[0];			//make the burst time 0
		    			i = 0;									//reset i back to 0
		    		}
		    		if(burstTimes[0] <= 0) {					//if the burst time is less than or equal to 0
		    			break;									//break while loop
		    		}
		    	}
		    }
		    else
		    	t2[i] = burstTimes[1];		//if the burst time is less than the time quantum from the beginning, append to array
		    
		    if(burstTimes[1] > quant) {				
		    	while(burstTimes[1] > quant) {    	
		    		
		    		t2[i] = quant;  				
		    		burstTimes[1]-= quant;			
		    		i++;
		    	
		    		if(burstTimes[1] <= quant) {
		    			t2[i] = burstTimes[1];
		    			burstTimes[1]-= burstTimes[1];	
		    			i = 0;
		    		}
		    		if(burstTimes[1] <= 0) {
		    			break;
		    		}
		    		
		    	}
		    }
		    else
		    	t2[i] = burstTimes[1];
		    
		    
		    if(burstTimes[2] > quant) {				
		    	while(burstTimes[2] > quant) {    
		    		
		    		t3[i] = quant;  				
		    		burstTimes[2]-= quant;			
		    		i++;
		    	
		    		if(burstTimes[2] <= quant) {
		    			t3[i] = burstTimes[2];
		    			burstTimes[2]-= burstTimes[2];	
		    			i = 0;
		    		}
		    		if(burstTimes[2] <= 0) {
		    			 break;
		    		}
		    		
		    	}
		    }
		    else
		    	t3[i] = burstTimes[2];
		    
		    
		    if(burstTimes[3] > quant) {				
		    	while(burstTimes[3] > quant) {   
		    		
		    		t4[i] = quant;  				
		    		burstTimes[3]-= quant;			
		    		i++;
		    	
		    		if(burstTimes[3] <= quant) {
		    			t4[i] = burstTimes[3];
		    			burstTimes[3]-= burstTimes[3];	
		    			i = 0;
		    		}
		    		if(burstTimes[3] <= 0) {
		    			   break;
		    		}
		    		
		    	}
		    }
		    else
		    	t4[i] = burstTimes[3];
		    
		        t5[i] = burstTimes[4];
		 
turn1 = t1[0]+t2[0]+t3[0]+t4[0]+t5[0]+t1[1];		//calculate each process' turn around time
turn2 = turn1 + t2[1]+t3[1]+t4[1]+t2[2];
turn3 = turn2 + t3[2];
turn4 = turn1 + t2[1]+t3[1]+t4[1];
turn5 = t1[0]+t2[0]+t3[0]+t4[0]+t5[0];
avgTurn = (turn1+turn2+turn3+turn4+turn5) / 5;		//calculate average turn around time

wait1 = (t1[0]+t2[0]+t3[0]+t4[0]+t5[0]) - t1[0]; 	//calculate each process' wait time
wait2 = t1[0] + (turn1 - (t1[0]+t2[0]))+ (turn4 - (turn1 + t2[1]));
wait3 = (t1[0]+t2[0])+((turn1 + t2[1]) - (t1[0]+t2[0]+t3[0]))+((turn1 + t2[1]+t3[1]+t4[1]+t2[2]) - (turn1 + t2[1]+t3[1]));
wait4 =(t1[0]+t2[0]+t3[0])+((turn1 + t2[1]+t3[1])- (t1[0]+t2[0]+t3[0]+t4[0]));
wait5 = t1[0]+t2[0]+t3[0]+t4[0];
avgWait = (wait1+wait2+wait3+wait4+wait5)/5;		//calculate average wait time

System.out.println("RR:");
System.out.println("T1[0-"+t1[0]+"], T2["+t1[0]+"-"+(t1[0]+t2[0])+"], T3["+(t1[0]+t2[0])+"-"+(t1[0]+t2[0]+t3[0])+"], T4["+(t1[0]+t2[0]+t3[0])+"-"+wait1+"], T5["+wait1+"-"+turn5+"], T1["+turn5+"-"+turn1+"], T2["+turn1+"-"+wait3+"], T3["+wait3+"-"+(turn1 + t2[1]+t3[1])+"], T4["+(turn1 + t2[1]+t3[1])+"-"+turn4+"], T2["+turn4+"-"+turn2+"], T3["+turn2+"-"+turn3+"]");
System.out.println("Avg. waiting time: "+avgWait+"\nAvg. turnaround time: "+avgTurn);
	 
	  }
}