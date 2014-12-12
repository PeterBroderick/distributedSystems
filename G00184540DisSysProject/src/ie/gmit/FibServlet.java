package ie.gmit;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.NotBoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FibServlet extends HttpServlet {
	
	  public void doGet(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException 
	  {
		  String fibCall= "null";//Variable that will carry the fibonacci sequence to be outputted.
		  String errorMessage= "You need to go back and input a number within the range 1-100";
		   
	      int max = Integer.valueOf(request.getParameter("max"));//Integer typed in by user.
		  int jobNumber = FibService.add(max);
		  
		  FibClient fib = new FibClient();//Calling new instance of the fib client class to assign a job number to the request
		  
		  try 
		  {
			  fib.rmiCall(max);
			  fibCall = fib.rmiCall(max);
		  } 
		  
		  catch (NotBoundException e) 
		  {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }		  
		  
		  if(max>0 && max <101)
		  {
	   		  response.setIntHeader("Refresh", 10);
		      response.setContentType("text/plain");  
		      response.setCharacterEncoding("UTF-8");
		      response.getWriter().write(String.valueOf("\nJob Number: " +String.valueOf(jobNumber)));
		      response.getWriter().write(String.valueOf("\nFinonacci Sequence: " +String.valueOf(fibCall)));
		  }
	   
		  else if(max<1 || max >100)
		  {
		      response.setContentType("text/plain");    
		      response.setCharacterEncoding("UTF-8"); 
		      response.getWriter().write(String.valueOf(String.valueOf(errorMessage)));		 
		  }
	  }  
	  public void setIntHeader(String header, int headerValue)
	  {
		  
	  }
	  
	  
}