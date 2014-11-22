package com.nirmaan.people;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Time;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nirmaan.database.Database;
import com.nirmaan.others.Event;
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

		Date dt;
		Time st;
		Time et;
		String vnu;

		// while(run tru the database for date)

		Pattern pat;
		Matcher mat;
		String result = "";
		pat = Pattern.compile(".*" + date + ".*");
		try {

			FileInputStream fstream = new FileInputStream("file.txt");
			DataInputStream ind = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(ind));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				mat = pat.matcher(strLine);
				boolean found = mat.matches();
				if (found) {

					// while(run tru the database for time)

					while (rs1.next()) {
						// Retrieve by column name
						// int id = rs1.getInt("id");
						// int age = rs1.getInt("age");
						st = rs1.getTime("startdate");
						et = rs1.getTime("enddate");

						if ((st.after(startTime) && st.before(endTime))
								|| (et.before(endTime) && et.after(startTime))) {
							flagmeet = false;
							return flagmeet;
							break;
						}

					}
				}

			}

			Meeting meetnext = new Meeting(venue, date, startTime, endTime);
			return flagmeet;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			return flagmeet;

		}

	}

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

	}

	/**
	 * @param msg string
	 * @return
	 */
	public boolean postFeed(String msg) {
		return false;
	}

	public boolean openRegistration(Event evt) {
		return false;

	}

	public boolean closeRegistration(Event evt) {
		return false;

	}

}
