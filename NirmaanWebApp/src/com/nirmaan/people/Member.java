package com.nirmaan.people;

import java.util.Date;
import com.nirmaan.others.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nirmaan.database.Database;
import com.nirmaan.others.Event;
import com.nirmaan.others.Meeting;

/**
 * @author Group-19
 *
 */
public class Member extends Student {
	protected String username;
	protected String password;
	protected Date tillWhen;

	public Member() {
		super();
	}

	/**
	 * @param n name
	 * @param id id
	 * @param e email
	 * @param p phone no.
	 */
	public Member(String n, int id, String e, String p) {

		super(n, id, e, p);
	}

	/**
	 * @param name name
	 * @param id id
	 * @param email email
	 * @param phone phone no.
	 * @param user username
	 * @param pass password
	 * @param db database
	 * @return
	 */
	public boolean signup(String name, int id, String email, String phone,
			String user, String pass, Database db) {
		try {
			this.name = name;
			this.id = id;
			this.email = email;
			this.phone = phone;
			this.username = user;
			this.password = pass;

			db.runUpdate("INSERT ", "INTO ",
					"userData(name,id,email,phone,username,password) ",
					"VALUES('" + this.name + "'," + this.id + ",'" + this.email
							+ "','" + this.phone + "','" + this.username
							+ "','" + this.password + "') ", "");

		} catch (Exception e) {
			System.out.println("Signup Failed due to error : ");
			e.printStackTrace();
			return false;
		}
		System.out.println("Sign Up successful!!!");
		return true;
	}

	/**
	 * @param user username
	 * @param pass password
	 * @param db database
	 * @return boolean
	 */
	public boolean signup(String user, String pass, Database db) {
		try {
			this.username = user;
			this.password = pass;
			this.signup(this.name, this.id, this.email, this.phone,
					this.username, this.password, db);
		} catch (Exception e) {
			System.out.println("Signup Failed due to error : ");
			e.printStackTrace();
			return false;
		}
		System.out.println("Sign Up successful!!!");
		return true;
	}

	/**
	 * @param user username
	 * @param pass password
	 * @param db database
	 * @return boolean
	 */
	public boolean login(String user, String pass, Database db) {
		PreparedStatement tempStmt = null;

		tempStmt = db
				.prepStatement("SELECT username,password from userData where username=? and password=?");
		try {
			// bind values to compare
			tempStmt.setString(1, user);
			tempStmt.setString(2, pass);
			ResultSet tempRs = tempStmt.executeQuery();
			if (tempRs.next()) {
				String fromDB_username = tempRs.getString("username");
				String fromDB_password = tempRs.getString("password");
				if (user.matches(fromDB_username)
						&& pass.matches(fromDB_password)) {
					System.out.println("Login Successful...");
					return true;
				} else {
					System.out.println("Login failed :( :(");
					return false;
				}
			} else {
				System.out.println("Login failed :( :(");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return false;
	}

	/**
	 * @return boolean
	 */
	public boolean logout() {
		return false;
	}

	public void promote(Event event) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Nirmaan Event!!! --" + event.getName());
			System.out.println("Starts on " + event.getStartDate()
					+ "\t Ends on " + event.getEndDate());
			System.out.println("Do attend the event!!!!");
		}
	}

	/**
	 * @return boolean
	 */
	public boolean subscribeToFeed() {
		if (this.feedVariable == false) {
			this.feedVariable = true;
			System.out.println("Thanks for Subscribing!!!");
			return true;
		} else
			return false;
	}


	public void seeSchedule(Database db) throws SQLException // create a member table with name event sd ed  activity date 
	{
			Event evt = new Event();
			evt.printEvents(db);
			Meeting meet = new Meeting();
			meet.printMeetings(db);
			
	}
	
	
public boolean enrollforEvent(Event evt) {
		
		boolean enroll = true;
		
		if(evt.get_openclose() == true)
		{
			
		evt.set_memberList(this) ;
		System.out.println("The member is enrolled for the event");
		}
		else
		{
		System.out.println("The registrations for the event are closed");
		enroll = false;
		}
		
		return enroll;
}
}
