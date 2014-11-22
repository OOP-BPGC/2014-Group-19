package com.nirmaan.others;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.*;

import com.nirmaan.database.Database;
import com.nirmaan.people.Member;
import com.nirmaan.people.Volunteer;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}

	public void setActivityList(Activity act) {
		this.activityList.add(act);
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
	public void setVolunteerList(Volunteer v) {
		this.volunteerList = volunteerList;
	}

	public Activity createact(String name, String venue, Date date, Time startTime,
			Time endTime, Database db) {
		Activity act_var = new Activity(name, venue, date, startTime, endTime);
		this.setActivityList(act_var);
		return act_var;
	}
	
	public void getEvents(Database db)	{
		Activity tempAct = new Activity();
		tempAct.printActivities(db);
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

class Activity {

	private String name;
	private Time startTime;
	private Time endTime;
	private Date date;
	private ArrayList<Member> memberList;
	private ArrayList<Volunteer> volunteerList;
	private String venue;

	public Activity()	{
	}
	public Activity(String n, String v, Date d, Time st, Time et) {
		this.name = n;
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}

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