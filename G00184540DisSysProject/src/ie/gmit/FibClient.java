package ie.gmit;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FibClient 
{
	public String rmiCall(int max) throws RemoteException, MalformedURLException, NotBoundException {
		//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instannce of
		//the MessageService object that is bound to the RMI registry with the name howdayService.
		RemoteFibonacci fs = (RemoteFibonacci) Naming.lookup("rmi://localhost:1099/howdayService");
		
		//Make the remote method invocation. This results in the RemoteMessage object being transferred
		//to us over the network in serialized form. 
		String rmitest = fs.getFibonacciSequence(max);
		return rmitest;
		
	}
}