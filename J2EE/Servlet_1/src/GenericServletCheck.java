import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@SuppressWarnings("serial")
@WebServlet("/GenericServlet")
public class GenericServletCheck extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Inside Service method");
		if(((HttpServletRequest)arg0).getMethod().equalsIgnoreCase("GET"))
			doGet(arg0, arg1,"Reqqwqq");
	}
	// No methods like doGet or doPost in GenericServlet. So no obligation of override the same types
	// for doGet and doPost 
	public void doGet(ServletRequest arg0, ServletResponse arg1, String handleMe)
	{
		System.out.println("Inside GET method with argument : "+handleMe);
		
	}
}

