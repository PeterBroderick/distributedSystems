package ie.gmit;

import java.rmi.*;
import java.rmi.registry.*;

public class FibonacciService {
	public static void main(String[] args) throws Exception{
		RemoteFibonacci ms = new FibonacciImpl();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("howdayService", ms);
		System.out.println("Server ready.");
	}
}

