<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Volunteer's Page</title>
<style type="text/css">
body {
	background-color: #f4f4f4;
}

fieldset.elist,input[type="text"],textarea,select,option,fieldset.elist ul,fieldset.elist>legend,fieldset.elist input[type="text"],fieldset.elist>legend:after
	{
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

input[type="text"] {
	padding: 0 20px;
}

textarea {
	width: 500px;
	height: 200px;
	padding: 20px;
}

textarea,input[type="text"],fieldset.elist ul,select,fieldset.elist>legend
	{
	border: 2px #cccccc solid;
	border-radius: 10px;
}

input[type="text"],fieldset.elist,select,fieldset.elist>legend {
	height: 32px;
	font-family: Tahoma;
	font-size: 14px;
}

input[type="text"]:hover,textarea:hover,select:hover,fieldset.elist:hover>legend
	{
	background-color: #ddddff;
}

select {
	padding: 4px 20px;
}

option {
	height: 30px;
	padding: 5px 4px;
}

option:not            (:checked            ),textarea:focus {
	background-color: #ffcccc;
}

fieldset.elist>legend:after,fieldset.elist label {
	height: 28px;
}

input[type="text"],fieldset.elist {
	width: 316px;
}

input[type="text"]:focus {
	background: #ffcccc
		url("data:image/gif;base64,R0lGODlhEAAQANU5APnoxuvr6+uxPdvb2+rq6ri4uO7qxunp6dPT06SHV+/rx8vLy+nezLO0sbe3t9Ksas+qaaCEV8rKyp2dnf39/QAAAK6ursifZHFxcc/Qzu3mxYyMjExCJnV1dc6maO7u7o+Pj2tXNoaGhtfDpKCDVu3lxM+tcaKEV9bW1qOFVWNjY8KrisTExNra2nBbObGxsby8vO/mu7Kyso9ZAuzs7MSgAIiKhf///8zMzP///wAAAAAAAAAAAAAAAAAAAAAAACH5BAEAADkALAAAAAAQABAAAAaXwJxwSCwOYzWkMpkkZmoAqDQaJdpqAqw2m53NRjlboAarFczomcE0C99o8DgNMVM8Tm3bbYDr9x11DwkzDG5yc2oQJIRCenx/MxoeETM2Q3pxATMlF4MYlo17OAsdLispMyAioIY0BzMcITMTKBasjgssFTMqGxItMjYUoTQBBAQHxgE0wZcfMtDRMi/QrA022NnaNg1CQQA7")
		no-repeat 2px center !important;
}

input[type="text"]:focus,textarea:focus,select:focus,fieldset.elist>legend
	{
	border: 2px #ccaaaa solid;
}

fieldset {
	border: 2px #af3333 solid;
	border-radius: 10px;
}

/* Editable [pseudo]select (i.e. fieldsets with [class=elist]) */
fieldset.elist {
	display: inline-block;
	position: relative;
	vertical-align: middle;
	overflow: visible;
	padding: 0;
	margin: 0;
	border: none;
}

fieldset.elist ul {
	position: absolute;
	width: 100%;
	max-height: 320px;
	padding: 0;
	margin: 0;
	overflow: hidden;
	background-color: transparent;
}

fieldset.elist:hover ul {
	background-color: #ffffff;
	border: 2px #af3333 solid;
	left: 2px;
	overflow: auto;
}

fieldset.elist ul>li {
	list-style-type: none;
	background-color: transparent;
}

fieldset.elist label {
	display: none;
	width: 100%;
}

fieldset.elist input[type="text"] {
	width: 100%;
	height: 30px;
	line-height: 30px;
	border: none;
	background-color: transparent;
	border-radius: 0;
}

fieldset.elist>legend {
	display: block;
	margin: 0;
	padding: 0 0 0 5px;
	position: absolute;
	width: 100%;
	cursor: default;
	background-color: #ccffcc;
	line-height: 30px;
	font-style: italic;
}

fieldset.elist:hover>legend {
	position: relative;
	overflow: hidden;
}

fieldset.elist>legend:after {
	width: 20px;
	content: "\2335";
	float: right;
	text-align: center;
	border-left: 2px #cccccc solid;
	font-style: normal;
	cursor: default;
}

fieldset.elist:hover>legend:after {
	background-color: #99ff99;
}

fieldset.elist ul input[type="radio"] {
	display: none;
}

fieldset.elist input[type="radio"]:checked             ~ label {
	display: block;
	width: 292px;
	background-color: #ffffff;
}

fieldset.elist:hover input[type="radio"]:checked             ~ label {
	width: 100%;
}

fieldset.elist:hover label {
	display: block;
	height: 100%;
}

fieldset.elist label:hover {
	background-color: #3333ff !important;
}

fieldset.elist:hover input[type="radio"]:checked             ~ label {
	background-color: #aaaaaa;
}

.container {
	width: 500px;
	clear: both;
}

.container input {
	width: 100%;
	clear: both;
}

body {
	background-color: #f4f4f4;
	color: #5a5656;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	font-size: 16px;
	line-height: 1.5em;
}

a {
	text-decoration: none;
}

h1 {
	font-size: 1em;
}

h1,p {
	margin-bottom: 10px;
}

strong {
	font-weight: bold;
}

.uppercase {
	text-transform: uppercase;
}

/* ---------- LOGIN ---------- */
#login {
	margin: 50px auto;
	width: 300px;
}

form fieldset input[type="text"],input[type="password"] {
	background-color: #e5e5e5;
	border: none;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #5a5656;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	font-size: 14px;
	height: 50px;
	outline: none;
	padding: 0px 10px;
	width: 280px;
	-webkit-appearance: none;
}

form fieldset input[type="submit"] {
	background-color: #008dde;
	border: none;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #f4f4f4;
	cursor: pointer;
	font-family: 'Open Sans', Arial, Helvetica, sans-serif;
	height: 50px;
	text-transform: uppercase;
	width: 200px;
	-webkit-appearance: none;
}

form fieldset a {
	color: #5a5656;
	font-size: 10px;
}

form fieldset a:hover {
	text-decoration: underline;
}

.btn-round {
	background-color: #5a5656;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	color: #f4f4f4;
	display: block;
	font-size: 12px;
	height: 50px;
	line-height: 50px;
	margin: 30px 125px;
	text-align: center;
	text-transform: uppercase;
	width: 50px;
}
}
</style>
</head>
<body>
	<center>
		<b style="color: teal;"><em><font size="6">Welcome Member, <%
			String username = session.getAttribute("username").toString();
			out.println(username);
			HttpSession session1 = request.getSession(false);
			session1.setAttribute("username", username);
		%>!
			</font></em></b> <br> <br> <br>
		<p>
			<font color="navy" size="4">What would you like to do?</font>
		</p>
	</center>
	<div id="login">
		<form action="MemberServlet" method="post">
			<fieldset>
				<p>
					<input type="radio" name="category" value="0" checked>See Events<br>  
					<input type="radio" name="category" value="1">See Activites<br>
					<input type="radio" name="category" value="2">See Schedule<br>
					<input type="radio" name="category" value="3">Enroll for Event<br>
					<input type="radio" name="category" value="4">Subscribe to Feed<br>
					<input type="radio" name="category" value="5">Promote<br>
				</p>
				<p>
					<input type="submit" value="Go!">
				</p>
			</fieldset>
		</form>
	</div>
	<br>
	<br>
	<center>
		<a href="login.jsp" shape="rect"><font color="red" size="4">Logout</font></a>
	</center>
</body>
</html>