<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Nirmaan - Sign Up</title>
<style type="text/css">
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

h1, p {
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

form fieldset input[type="text"], input[type="password"] {
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
	width: 300px;
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
	<div id="login">
		<h1>
			<strong>Welcome,</strong> Please fill the details to Start your
			journey with Nirmaan Organisation
		</h1>
		<form action="MainServlet" method="post">
			<fieldset>
				<p>
					<input type="text" required value="Name" name="name">
				</p>
				<p>
					<input type="text" required value="ID" name="id">
				</p>
				<p>
					<input type="text" required value="EMAIL" name="email">
				</p>
				<p>
					<input type="text" required value="PHONE" name="phone">
				</p>
				<p>
					<input type="text" required value="USERNAME" name="username">
				</p>
				<p>
					<input type="password" required value="PASSWORD" name="password">
				</p>
				<p>
					<input type="radio" name="category" value="1" checked>Member
					<br> <input type="radio" name="category" value="0">Volunteer
				</p>

				<p>
					<input type="submit" value="Start Journey">
				</p>
			</fieldset>
		</form>
		Click <a href="login.jsp">here</a> to Login
	</div>
	<!-- end submit -->
	<center>
		<h2>
			<a href="main.jsp">Home</a>
		</h2>
	</center>
</body>
</html>