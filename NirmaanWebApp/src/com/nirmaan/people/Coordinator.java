package com.nirmaan.people;

import java.sql.Time;
import java.util.*;
import com.nirmaan.database.Database;
import com.nirmaan.others.Event;
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

	// public boolean scheduleMeeting(Date date, Time startTime, Time endTime,
	// String venue) {
	//
	// boolean flagmeet = true;
	//
	// Date dt;
	// Time st;
	// Time et;
	// String vnu;
	//
	// // while(run tru the database for date)
	// {
	// if (dt == date) {
	//
	// // while(run tru the database for time)
	// {
	// if ((st >= startTime && st <= endTime)
	// || (et <= endTime && et >= starttime)) {
	// flagmeet = false;
	// return flagmeet;
	// break;
	// }
	//
	// }
	// }
	//
	// }
	//
	// Meeting meetnext = new Meeting(venue, date, startTime, endTime);
	// return flagmeet;
	// }

	public boolean scheduleEvent(String name, Date startDate, Date endDate) {
		return false;
	}

	public boolean scheduleActivity(String name, Date startDate, Date endDate,
			Time startTime, Time endTime) {
		return false;

	}

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
