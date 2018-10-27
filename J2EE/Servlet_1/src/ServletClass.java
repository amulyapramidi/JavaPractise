import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BasicServlet")
public class ServletClass implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {

		String httpReq = ((HttpServletRequest) arg0).getMethod();
		System.out.println("Inside Service");
		/*if(httpReq.equalsIgnoreCase("GET"))
			doGet(((HttpServletRequest) arg0), ((HttpServletResponse) arg1));			
		else if(httpReq.equalsIgnoreCase("POST"))
			doPost(((HttpServletRequest) arg0), ((HttpServletResponse) arg1));*/	
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("Get Received");
		res.getWriter().write("Inside Get");
		//res.getOutputStream().print("<html><body><h1>Inside POST</h1><body></html>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("Post Received");
		res.getWriter().write("<html><body><h1>Inside POST</h1><body></html>");
	}

}
