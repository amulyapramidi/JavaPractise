import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/*")
public class HttpServletClass extends HttpServlet{
	
	// If you add any additional arguments to this, user gets error that GET not supported.
	// We must follow parent's method signature

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("Inside get");		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("Inside POST"); 
		try {
			res.getWriter().append("Hi "+req.getParameter("Hello"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
