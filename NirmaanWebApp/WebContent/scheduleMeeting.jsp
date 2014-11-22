<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Meeting</title>
<style type="text/css">
	body {
	background-color: #f4f4f4;
	}
	
	fieldset.elist, input[type="text"], textarea, select, option, fieldset.elist ul, fieldset.elist > legend, fieldset.elist input[type="text"], fieldset.elist > legend:after {
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
	
	textarea, input[type="text"], fieldset.elist ul, select, fieldset.elist > legend {
	  border: 2px #cccccc solid;
	  border-radius: 10px;
	}
	
	input[type="text"], fieldset.elist, select, fieldset.elist > legend {
	  height: 32px;
	  font-family: Tahoma;
	  font-size: 14px;
	}
	
	input[type="text"]:hover, textarea:hover, select:hover, fieldset.elist:hover > legend {
	  background-color: #ddddff;
	}
	
	select {
	  padding: 4px 20px;
	}
	
	option {
	  height: 30px;
	  padding: 5px 4px;
	}
	
	option:not(:checked), textarea:focus {
	  background-color: #ffcccc;
	}
	
	fieldset.elist > legend:after, fieldset.elist label {
	  height: 28px;
	}
	
	input[type="text"], fieldset.elist {
	  width: 316px;
	}
	
	input[type="text"]:focus {
	  background: #ffcccc url("data:image/gif;base64,R0lGODlhEAAQANU5APnoxuvr6+uxPdvb2+rq6ri4uO7qxunp6dPT06SHV+/rx8vLy+nezLO0sbe3t9Ksas+qaaCEV8rKyp2dnf39/QAAAK6ursifZHFxcc/Qzu3mxYyMjExCJnV1dc6maO7u7o+Pj2tXNoaGhtfDpKCDVu3lxM+tcaKEV9bW1qOFVWNjY8KrisTExNra2nBbObGxsby8vO/mu7Kyso9ZAuzs7MSgAIiKhf///8zMzP///wAAAAAAAAAAAAAAAAAAAAAAACH5BAEAADkALAAAAAAQABAAAAaXwJxwSCwOYzWkMpkkZmoAqDQaJdpqAqw2m53NRjlboAarFczomcE0C99o8DgNMVM8Tm3bbYDr9x11DwkzDG5yc2oQJIRCenx/MxoeETM2Q3pxATMlF4MYlo17OAsdLispMyAioIY0BzMcITMTKBasjgssFTMqGxItMjYUoTQBBAQHxgE0wZcfMtDRMi/QrA022NnaNg1CQQA7") no-repeat 2px center !important;
	}
	
	input[type="text"]:focus, textarea:focus, select:focus, fieldset.elist > legend {
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
	
	fieldset.elist ul > li {
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
	
	fieldset.elist > legend {
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
	
	fieldset.elist:hover > legend {
	  position: relative;
	  overflow: hidden;
	}
	
	fieldset.elist > legend:after {
	  width: 20px;
	  content: "\2335";
	  float: right;
	  text-align: center;
	  border-left: 2px #cccccc solid;
	  font-style: normal;
	  cursor: default;
	}
	
	fieldset.elist:hover > legend:after {
	  background-color: #99ff99;
	}
	
	fieldset.elist ul input[type="radio"] {
	  display: none;
	}
	
	fieldset.elist input[type="radio"]:checked ~ label {
	  display: block;
	  width: 292px;
	  background-color: #ffffff;
	}
	
	fieldset.elist:hover input[type="radio"]:checked ~ label {
	  width: 100%;
	}
	
	fieldset.elist:hover label {
	  display: block;
	  height: 100%;
	}
	
	fieldset.elist label:hover {
	  background-color: #3333ff !important;
	}
	
	fieldset.elist:hover input[type="radio"]:checked ~ label {
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

</style>
</head>
<body>
	<div class="container">
	<form action="MeetingServlet" method="post" name="0">
		<fieldset>
			<legend> <b><font size="4" style="color: olive;">Schedule new Meeting</font></b> </legend>
			
			<label>Start Time:</label><input type="text" value="HH" name="startTimeHour">: 
			<input type="text" value="mm" name="startTimeMin"><br>
			<p>Date: <input type="text" value="YYYY" name="year">:<input type="text" value="MM" name="month">:<input type="text" value="DD" name="date"></p>
			<p>Venue: <input type="text" name="venue"></p>
			<p><input type="submit" value="Schedule"></p>
		</fieldset>
		
	</form>
	</div>
</body>
</html>