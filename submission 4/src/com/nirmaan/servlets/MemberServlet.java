package com.nirmaan.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nirmaan.database.Database;
import com.nirmaan.others.Event;
import com.nirmaan.others.Registration;
import com.nirmaan.people.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	final String USER = "tempUser";
	final String PASS = "abc";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String[] str = request.getParameterValues("category");
		
		int cat_int = Integer.parseInt(str[0]);
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/memberFinal.jsp");
		//Perform different tasks based on different categories
		if (cat_int == 0){
			Database db = new Database(USER, PASS);
			Event e = new Event();
			String events = e.printEvents(db);
			request.setAttribute("events", events);
		}else if (cat_int == 1){
			Database db = new Database(USER, PASS);
			Event e = new Event();
			String activities = e.printActivities(db);
			request.setAttribute("activities", activities);
		}else if (cat_int == 2){
			Database db = new Database(USER, PASS);
			Member m = new Member();
			String schedule;
			try {
				schedule = m.seeSchedule(db);
				request.setAttribute("schedule", schedule);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (cat_int == 3){
			Database db = new Database(USER, PASS);
			
		}else if (cat_int == 4){
			Database db = new Database(USER, PASS);
			
		}else if (cat_int == 5){
			Database db = new Database(USER, PASS);
			Member m = new Member();
			Event event = new Event();
			String promote = m.promote(event);
			request.setAttribute("promote", promote);
		}
		
		rd.forward(request, response);
	}

}
