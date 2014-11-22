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

public class Coordinator extends Member {

	public Coordinator(String n, int string, String e, String p) {
		super(n, string, e, p);
	}

	public boolean login(String user, String pass) {
		pass = this.encryptPassword(pass);
		return false;
	}

	public boolean logout() {
		return false;

	}

	public boolean scheduleMeeting(Date date, Time startTime, String venue,
			Database db) {
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

	public boolean scheduleEvent(String name, Date startDate, Date endDate,
			Database db) {
		startDate.setYear(startDate.getYear()-1900);
	//endDate.setYear(endDate.getYear()-1900);
		startDate.setMonth(startDate.getMonth()-1);
	//	endDate.setYear(endDate.getMonth()-1);

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
				
				System.out.println(startDate.toString());
				System.out.println(strd.toString());	
				System.out.println(endDate.toString());
				System.out.println(endd.toString());
				System.out.println(startDate.compareTo(strd)) ;
				System.out.println(endDate.compareTo(endd)) ;
		
				if (!((startDate.compareTo(strd)*endDate.compareTo(endd))==1)) {
					flagdate = false;
					System.out.println("z") ;


				}
				
					

			}
			if (flagdate == true) {
				startDate.setYear(startDate.getYear()+1900);
  		//	endDate.setYear(endDate.getYear());
				startDate.setMonth(startDate.getMonth()+1);
			//	endDate.setYear(endDate.getMonth()+1);
				System.out.println(startDate.toString());
				
				System.out.println("keivn"+endDate.toString());
				Event next = new Event(name, startDate, endDate, db);
				return flagdate;

			}
			else
			{
				System.out.println("Cannot create event ") ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flagdate;
	}

	public boolean scheduleActivity(Event evt, String name,String ent_name, String venue,
			Date date, Time startTime, Time endTime, Database db) {
		boolean flagdate = true;
		Date strd;
		Date endd;

		// while(run tru the database)
		Statement stmt = null;
		ResultSet rs1 = null;

		rs1 = db.runQuery("select date,venue from activity", "", "", "", "");
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

	public boolean postFeed(String head, String body, Database db) {
		Feed feed = new Feed(head, body, db);
		return true;
	}

	public boolean openRegistration(Event evt) {
		evt.set_openclose(true);
		return true;

	}

	public void closeRegistration(Event evt) {
		evt.set_openclose(false);

	}

}
