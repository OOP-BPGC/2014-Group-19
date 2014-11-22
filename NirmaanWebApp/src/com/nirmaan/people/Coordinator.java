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

//	

//	public boolean scheduleEvent(String name, Date startDate, Date endDate, Database db) {
//
//		boolean flagdate = true;
//		Date strd;
//		Date endd;
//
//		// while(run tru the database)
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs1 = null;
//		try {
//			while (rs1.next()) {
//				// Retrieve by column name
//				// int id = rs1.getInt("id");
//				// int age = rs1.getInt("age");
//				strd = rs1.getDate("startdate");
//				endd = rs1.getDate("enddate");
//
//				if ((strd.after(startDate) && strd.before(endDate))
//						|| (endd.before(endDate) && endd.after(startDate))) {
//					flagdate = false;
//					return flagdate;
//
//				}
//
//			}
//			if (flagdate == true) {
//				Event next = new Event(name, startDate, endDate);
//				return flagdate;
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			return flagdate;
//		}
//
//	}

	public boolean scheduleActivity(String name, Date startDate, Date endDate,
			Time startTime, Time endTime) {
		return false;

	}

	public boolean postFeed(String head, String body, Database db) {
		Feed feed = new Feed(head, body, db);
		return true;
	}

	public boolean openRegistration(Event evt) {
		return false;

	}

	public boolean closeRegistration(Event evt) {
		return false;

	}

}
