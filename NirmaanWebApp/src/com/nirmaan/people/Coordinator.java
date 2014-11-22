package com.nirmaan.people;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nirmaan.database.Database;

import com.nirmaan.others.Event;
import com.nirmaan.others.Feed;
import com.nirmaan.others.Meeting;

/**
 * @author Group-19
 * The class in subclasss of class Member
 */
public class Coordinator extends Member {

	/**
	 * @param n name
	 * @param string id
	 * @param e email
	 * @param p phone no.
	 */
	public Coordinator(String n, int string, String e, String p) {
		super(n, string, e, p);
	}

	/**
	 * @param user username
	 * @param pass password
	 * @return
	 */
	public boolean login(String user, String pass) {
		pass = this.encryptPassword(pass);
		return false;
	}

	/* (non-Javadoc)
	 * @see people.Member#logout()
	 */
	public boolean logout() {
		return false;

	}

<<<<<<< HEAD
	public boolean scheduleMeeting(Date date, Time startTime, String venue,
			Database db) {
=======
	/**
	 * @param date date
	 * @param startTime startTime
	 * @param endTime endTime
	 * @param venue
	 * @param db database
	 * @return true/false
	 */
	public boolean scheduleMeeting(Date date, Time startTime, Time endTime,
			String venue, Database db) {

		boolean flagmeet = true;

>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
		Date dt;
		Time st;
		String vnu;

		boolean flagmeet = true;
		boolean found = false;

		Statement stmt = null;
		ResultSet rs = null;

		FileInputStream fstream = null;
		DataInputStream ind = null;
		BufferedReader br = null;

		Pattern pat;
		Matcher mat;

		String date_query = date.getYear() + "-" + date.getMonth() + "-"
				+ date.getDate();

		pat = Pattern.compile(".*" + date_query + ".*");
		try {

			fstream = new FileInputStream("/home/lelouch/temp/meeting.csv");
			ind = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(ind));
			String strLine;
			rs = db.runQuery("select meet_time from meeting", "", "", "", "");
			while ((strLine = br.readLine()) != null) {
				mat = pat.matcher(strLine);
				found = mat.matches();
				if (found) {

					// while(run tru the database for time)
					while (rs.next()) {
						// Retrieve by column name
						// int id = rs1.getInt("id");
						// int age = rs1.getInt("age");
						st = rs.getTime("meet_time");
						String st_query = st.getHours() + ":" + st.getMinutes()
								+ ":" + st.getSeconds();
						String startTime_query = startTime.getHours() + ":"
								+ startTime.getMinutes() + ":"
								+ startTime.getSeconds();
						if ((st_query.matches(startTime_query))) {
							System.out.println("Wrong");
							flagmeet = false;
						}

					}
				}

			}
			if (flagmeet) {
				Meeting meetnext = new Meeting(venue, date, startTime, db);
				return flagmeet;
			} else {
				System.out.println("Schedule clashing, please re-schedule...");
				return flagmeet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flagmeet;
	}

<<<<<<< HEAD
	public boolean scheduleEvent(String name, Date startDate, Date endDate,
			Database db) {

		boolean flagdate = true;
		Date strd;
		Date endd;

		// while(run tru the database)
		Statement stmt = null;
		ResultSet rs1 = null;

		try {
			rs1 = db.runQuery("select startdate,enddate from events", "", "",
					"", "");
			while (rs1.next()) {
				// Retrieve by column name
				// int id = rs1.getInt("id");
				// int age = rs1.getInt("age");
				strd = rs1.getDate("startdate");
				endd = rs1.getDate("enddate");
				System.out.println(startDate.after(strd)) ;
				System.out.println(endDate.after(endd)) ;
				System.out.println(startDate.before(strd)) ;
				System.out.println(endDate.before(endd)) ;
				if (!((startDate.after(strd) && endDate.after(endd))
						|| (startDate.before(strd) && endDate.after(endd)))) {
					flagdate = false;
					System.out.println("z") ;


				}
				
					

			}
			if (flagdate == true) {
				Event next = new Event(name, startDate, endDate, db);
				return flagdate;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flagdate;
	}

	public boolean scheduleActivity(Event evt, String name, String venue,
			Date date, Time startTime, Time endTime, Database db) {
		boolean flagdate = true;
		Date strd;
		Date endd;

		// while(run tru the database)
		Statement stmt = null;
		ResultSet rs1 = null;
=======
	/**
	 * @param name name
	 * @param startDate startDate
	 * @param endDate endDate
	 * @return boolean
	 */
	public boolean scheduleEvent(String name, Date startDate, Date endDate) {
		return false;
	}

	/**
	 * @param name name
	 * @param startDate startDate
	 * @param endDate endDate
	 * @param startTime startTime
	 * @param endTime endDate
	 * @return boolean
	 */
	public boolean scheduleActivity(String name, Date startDate, Date endDate,
			Time startTime, Time endTime) {
		return false;
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f

		rs1 = db.runQuery("select meet_time from meeting", "", "", "", "");
		try {
			while (rs1.next()) {
				// Retrieve by column name
				// int id = rs1.getInt("id");
				// int age = rs1.getInt("age");
				strd = rs1.getDate("date");
				String venue_query = rs1.getString("venue");

				String date_query = strd.getYear() + "-" + strd.getMonth()
						+ "-" + strd.getDate();
				String date_querycheck = date.getYear() + "-" + date.getMonth()
						+ "-" + date.getDate();

				if (date_query.matches(date_querycheck)) {

					if (venue.matches(venue_query)) {

						flagdate = false;
					}

				}
				if (flagdate == true) {

					evt.createact(name, venue, date, startTime, endTime, db);
					return flagdate;
				} else {
					return flagdate;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flagdate;
	}

<<<<<<< HEAD
	public boolean postFeed(String head, String body, Database db) {
		Feed feed = new Feed(head, body, db);
		return true;
=======
	/**
	 * @param msg string
	 * @return
	 */
	public boolean postFeed(String msg) {
		return false;
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
	}

	public boolean openRegistration(Event evt) {
		evt.set_openclose(true);
		return true;

	}

	public void closeRegistration(Event evt) {
		evt.set_openclose(false);

	}

}
