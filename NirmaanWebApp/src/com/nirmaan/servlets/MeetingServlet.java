package com.nirmaan.servlets;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nirmaan.database.Database;
import com.nirmaan.others.Meeting;

/**
 * Servlet implementation class MeetingServlet
 */
@WebServlet("/MeetingServlet")
public class MeetingServlet extends HttpServlet {
	final String USER = "tempUser";
	final String PASS = "abc";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db = new Database(USER, PASS);
		int sth = Integer.parseInt(request.getParameter("startTimeHour"));
		int stm = Integer.parseInt(request.getParameter("startTimeMin"));
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		Time st = new Time(sth, stm, 0);
		Date d = new Date(year, month, date);
		Meeting m = new Meeting(request.getParameter("venue"), d, st, db);
	}

}
