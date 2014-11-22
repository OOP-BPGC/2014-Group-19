<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nirmaan.database.Database,com.nirmaan.others.Event"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/css/styles.css" type="text/css">
<link href="/css/styles2.css" type="text/css">
</head>
<body>
	<div>
		<center>
			<b style="color: teal;"><font size="4"> 
			<%!
			final String USER = "tempUser";
			final String PASS = "abc";
			Database db = null;
			Event e = new Event();
			%> 
			<%
				db = new Database(USER, PASS);
 				out.println(e.printEvents(db));
 			%>
			</font> </b>
		</center>
	</div>
</body>
</html>