package com.nirmaan.others;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.*;

import com.nirmaan.database.Database;
import com.nirmaan.people.Member;
import com.nirmaan.people.Volunteer;

/**
 * @author Group-19
 *Class hsndles the events 
 *Inner class- Activity
 */
public class Event {

	private String name;
	private Date startDate;
	private Date endDate;
	private ArrayList<Activity> activityList;
	private ArrayList<Member> memberList;
	private ArrayList<Volunteer> volunteerList;
	private boolean openclose;

	public Event(String name, Date sd, Date ed, Database db) {
		this.name = name;
		this.startDate = sd;
		this.endDate = ed;
		
		String sdate_query = startDate.getYear() + "-" + startDate.getMonth() + "-" + startDate.getDate();
		String edate_query = endDate.getYear() + "-" + endDate.getMonth() + "-" + endDate.getDate();

		db.runUpdate("INSERT INTO ", "events(event_name, startDate, endDate)",
				"VALUES('"+ this.name+"','" + sdate_query + "','"
						+ edate_query + "')", "", "");
	}

	public Event() {
		
	}

	public void set_openclose(boolean t) {
		openclose = t;
	}

	public boolean get_openclose() {
		return openclose;
	}

	public void set_memberList(Member m) {
		memberList.add(m);
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name setName
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return activityList
	 */
	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	/** 
	 * @param activityList activityList
	 */
	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}

<<<<<<< HEAD
	public void setActivityList(Activity act) {
		this.activityList.add(act);
	}

=======
	/**
	 * @return memberList
	 */
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	/**
	 * @param memberList memberList
	 */
	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}

	/**
	 * @return volunteerList
	 */
	public ArrayList<Volunteer> getVolunteerList() {
		return volunteerList;
	}

	/**
	 * @param volunteerList volunteerList
	 */
	public void setVolunteerList(ArrayList<Volunteer> volunteerList) {
		this.volunteerList = volunteerList;
	}
	public void setVolunteerList(Volunteer v) {
		this.volunteerList = volunteerList;
	}

<<<<<<< HEAD
	public Activity createact(String name, String venue, Date date, Time startTime,
			Time endTime, Database db) {
		Activity act_var = new Activity(name, venue, date, startTime, endTime);
		this.setActivityList(act_var);
		return act_var;
	}
	
	public void getEvents(Database db)	{
		Activity tempAct = new Activity();
		tempAct.printActivities(db);
=======
	/**
	 * @param n name
	 * @param sd startDate
	 * @param ed endDate
	 */
	public Event(String n, Date sd, Date ed) {
		this.name = n;
		this.startDate = sd;
		this.endDate = ed;
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
	}

	public void printEvents(Database db) {
		ResultSet tempRs;
		tempRs = db.runQuery("select * from events", "", "", "", "");
		try {
			while (tempRs.next()) {
				int id = tempRs.getInt("event_id");
				String name = tempRs.getString("event_name");
				Date sdate = tempRs.getDate("event_sdate");
				Date edate = tempRs.getDate("event_edate");

				String sdate_query = sdate.getYear() + "-" + sdate.getMonth()
						+ "-" + sdate.getDate();
				String edate_query = edate.getYear() + "-" + edate.getMonth()
						+ "-" + edate.getDate();

				System.out.println(id + " " + name);
				System.out.println(sdate_query + "  " + edate_query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

/**
 * @author Group-19
 * Inner class of class Event
 */
class Activity {

	private String name;
	private Time startTime;
	private Time endTime;
	private Date date;
	private ArrayList<Member> memberList;
	private ArrayList<Volunteer> volunteerList;
	private String venue;

<<<<<<< HEAD
	public Activity()	{
	}
=======
	/**
	 * @param n name
	 * @param v venue
	 * @param d date
	 * @param st startDate
	 * @param et endDate
	 */
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
	public Activity(String n, String v, Date d, Time st, Time et) {
		this.name = n;
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}
<<<<<<< HEAD

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}

	public ArrayList<Volunteer> getVolunteerList() {
		return volunteerList;
	}

	public void setVolunteerList(ArrayList<Volunteer> volunteerList) {
		this.volunteerList = volunteerList;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public void printActivities(Database db) {
		ResultSet tempRs;
		tempRs = db.runQuery("select * from activity", "", "", "", "");
		try {
			while (tempRs.next()) {
				int id = tempRs.getInt("activity_id");
				String event_name = tempRs.getString("event_name");
				String name = tempRs.getString("activity_name");
				Date sdate = tempRs.getDate("event_sdate");
				Time stime = tempRs.getTime("activity_stime");
				Time etime = tempRs.getTime("activity_etime");

				String sdate_query = sdate.getYear() + "-" + sdate.getMonth()
						+ "-" + sdate.getDate();
				String stime_query = stime.getYear() + "-" + stime.getMonth()
						+ "-" + stime.getDate();
				String etime_query = etime.getYear() + "-" + etime.getMonth()
						+ "-" + etime.getDate();
				
				System.out.println(id + " " + name);
				System.out.println(sdate_query);
				System.out.println(stime_query + "  " + etime_query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
=======
}
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
