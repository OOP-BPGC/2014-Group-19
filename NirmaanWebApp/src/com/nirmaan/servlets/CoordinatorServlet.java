package com.nirmaan.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nirmaan.others.Meeting;
import com.nirmaan.others.Registration;

/**
 * Servlet implementation class CoordinatorServlet
 */
@WebServlet("/CoordinatorServlet")
public class CoordinatorServlet extends HttpServlet {
	final String USER = "tempUser";
	final String PASS = "abc";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoordinatorServlet() {
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
		//Perform different tasks based on different categories
		if (cat_int == 0){
			rd = request.getRequestDispatcher("/scheduleMeeting.jsp");
		}else if (cat_int == 1){
			rd = request.getRequestDispatcher("/scheduleEvent.jsp");
		}else if (cat_int == 2){
			rd = request.getRequestDispatcher("/PostFeed.jsp");
		}else if (cat_int == 3){
			rd = request.getRequestDispatcher("/openRegistration.jsp");
			boolean b = true;
			Registration.open(b); //used to make sure that members can register only if registration is open.
		}else if (cat_int == 4){
			rd = request.getRequestDispatcher("/closeRegistration.jsp");
			//to make sure no one can register if registration is closed.
			boolean b = false;
			Registration.open(b);
		}
		rd.forward(request, response);
	}

}
