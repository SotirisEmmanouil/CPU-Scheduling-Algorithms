import java.util.Comparator;

public class CustomComparator implements Comparator<PS> {
	   
		@Override
	    public int compare(PS o1, PS o2) {
			
			if(o1.getArr() == o2.getArr()) {	//if the arrival times are the same, compare the priorities 
				return o1.getPriority() - o1.getPriority(); 
			}
	        return o1.getArr() - o2.getArr();
	    }
   } 