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
	    // reading the user input
		  int max = Integer.valueOf(request.getParameter("max"));
		  int jobNumber = FibService.add(max);
		  
		  FibClient fib = new FibClient();
		  try {
			fib.rmiCall(max);
			
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		  
		  
	   String result= "null"; 
	   
	   try {
		result = fib.rmiCall(max);
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   		response.setIntHeader("Refresh", 5);
		    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    response.getWriter().write(String.valueOf("\nJob Number is: " +String.valueOf(jobNumber)));
		    response.getWriter().write(String.valueOf("\nResult is: " +String.valueOf(result)));
		    
	    //PrintWriter out = response.getWriter();
	    //out.println ( "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + "<html> \n" + "<head> \n" + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" + "<title> My first jsp</title> \n" + "</head> \n" + "<body> \n" + "<font size=\"12px\" color=\"" + max + "\">" + "Hello World" + "</font> \n" + "</body> \n" + "</html>" );
	  }  
	  public void setIntHeader(String header, int headerValue){
		  
	  }
	  
	  
	  
	}