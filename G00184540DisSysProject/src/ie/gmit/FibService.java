package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FibService {
	
	private static LinkedList<FibRequest> inqueue = new LinkedList<FibRequest>();
	private Map<Integer, String> outqueue = new HashMap<Integer, String>();
	
	public static int add(int max){
		
		int number = (int)(Math.random()*(900 -1) +1);
		
		//Object random;
		inqueue.addLast(new FibRequest(number, max));
		return number;
	}
	
	public String getResult(int jobNumber){
		if(outqueue.containsKey(jobNumber)){
			String fibCall = outqueue.get(jobNumber);
			outqueue.remove(jobNumber);
			return fibCall;
			
		}
		else{
			return null;
		}
	}

	
}
