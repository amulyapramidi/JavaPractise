<%@page import="com.util.LoginConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loggedIn</title>
</head>
<body>
<%
out.print(LoginConstants.LOGIN_SUCCESS);
boolean cookieFound = false;
try{
Cookie[] cookies = request.getCookies();

if(cookies != null)
{
	for(Cookie cookie: cookies)
	{
		System.out.println("Cookie : "+cookie.getName()+" value : "+cookie.getValue());
		if(cookie.getName().equals(LoginConstants.LOGIN_COOKIE) && cookie.getValue().equals("true"))
			cookieFound = true;
			break;
		}
	}
}
catch(Exception e)
{
	
}
if(!cookieFound)
{
	System.out.println("Cookie not found so redirecting to login");
	response.sendRedirect("index.jsp");	
}
%>

<form action="LogoutPageServlet" method="post">
<input type="submit" value="Logout"/>
</form>
</body>
</html>