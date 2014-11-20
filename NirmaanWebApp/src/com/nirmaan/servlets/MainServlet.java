package com.nirmaan.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nirmaan.database.Database;
import com.nirmaan.people.Member;
import com.nirmaan.people.Volunteer;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	final String USER = "tempUser";
	final String PASS = "";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] str = request.getParameterValues("category");

		int id_int = Integer.parseInt(id);
		int cat_int = Integer.parseInt(str[0]);

		boolean signup = false;
		RequestDispatcher rd = null;


		// sign up based on the category the person is
		if (cat_int == 1) {
			Database db = new Database(USER, PASS);
			Member m = new Member();
			signup = m.signup(name, id_int, email, phone, username, password,
					db);
		} else if (cat_int == 0) {
			Database db = new Database(USER, PASS);
			Volunteer v = new Volunteer();
			signup = v.signup(name, id_int, email, phone, username, password,
					db);
		}
	
		// page forwarding
		if (signup)
			rd = request.getRequestDispatcher("/thanks.jsp");
		else
			rd = request.getRequestDispatcher("/signup_fail.jsp");

		rd.forward(request, response);
	}

}
