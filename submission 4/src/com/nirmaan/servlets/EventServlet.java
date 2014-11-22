package com.nirmaan.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nirmaan.database.Database;
import com.nirmaan.others.Event;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	final String USER = "tempUser";
	final String PASS = "abc";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db = new Database(USER, PASS);
		int s_year = Integer.parseInt(request.getParameter("s_year"));
		int s_month = Integer.parseInt(request.getParameter("s_month"));
		int s_date = Integer.parseInt(request.getParameter("s_date"));
		int e_year = Integer.parseInt(request.getParameter("e_year"));
		int e_month = Integer.parseInt(request.getParameter("e_month"));
		int e_date = Integer.parseInt(request.getParameter("e_date"));
		Date sd = new Date(s_year, s_month, s_date);
		Date ed = new Date(e_year, e_month, e_date);
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id == 0){
			Event e = new Event(request.getParameter("name"), sd, ed, db);
		}else if (id == 1){
			Event e = new Event();
			e.printEvents(db);
		}
	}

}
