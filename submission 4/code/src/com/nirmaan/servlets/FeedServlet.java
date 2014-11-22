package com.nirmaan.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nirmaan.database.Database;
import com.nirmaan.others.Feed;

/**
 * Servlet implementation class FeedServlet
 */
@WebServlet("/FeedServlet")
public class FeedServlet extends HttpServlet {
	final String USER = "tempUser";
	final String PASS = "abc";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db = new Database(USER, PASS);
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id == 0){
			Feed f = new Feed(request.getParameter("FeedHead"), request.getParameter("FeedBody"), db);
		}
		else if (id == 1){
			Feed f = new Feed();
			String sub = User.getName();
			f.addSubscriber(sub);
		}
	}

}
