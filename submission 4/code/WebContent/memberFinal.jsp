<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<b style="color: teal;"><font size="4"><%
			if(request.getParameter("events") != null){
				String attr = request.getParameter("events");
				out.println(attr);
			}
			else if(request.getParameter("activities") != null){
				String attr = request.getParameter("activities");
				out.println(attr);
			}
			else if(request.getParameter("schedule") != null){
				String attr = request.getParameter("schedule");
				out.println(attr);
			}
			else if(request.getParameter("promote") != null){
				String attr = request.getParameter("promote");
				out.println(attr);
			}
			else {
				out.println("OOPS!");
			}
		%>
		</font>
		</b>
		</center>
	</div>
</body>
</html>