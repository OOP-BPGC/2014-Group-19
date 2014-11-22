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

		String sdate_query = startDate.getYear() + "-" + startDate.getMonth()
				+ "-" + startDate.getDate();
		String edate_query = endDate.getYear() + "-" + endDate.getMonth() + "-"
				+ endDate.getDate();

		db.runUpdate("INSERT INTO ", "events(event_name, startDate, endDate)",
				"VALUES('" + this.name + "','" + sdate_query + "','"
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

	public Activity createact(String name, String venue, String evt_name,
			Date date, Time startTime, Time endTime, Database db) {
		Activity act_var = new Activity(name, venue, evt_name, date, startTime,
				endTime, db);
//		this.setActivityList(act_var);
		return act_var;
	}

	public String printActivities(Database db) {
		Activity tempAct = new Activity();
		String temp = tempAct.printActivities(db);
		return temp;
	}

	public String printEvents(Database db) {
		ResultSet tempRs;
		String temp = null;
		tempRs = db.runQuery("select * from events", "", "", "", "");
		try {
			while (tempRs.next()) {
				int id = tempRs.getInt("event_id");
				String name = tempRs.getString("event_name");
				Date sdate = tempRs.getDate("startdate");
				Date edate = tempRs.getDate("enddate");

				String sdate_query = sdate.getYear() + "-" + sdate.getMonth()
						+ "-" + sdate.getDate();
				String edate_query = edate.getYear() + "-" + edate.getMonth()
						+ "-" + edate.getDate();

				temp = id + " " + name;
				temp += "\n";
				temp = temp + sdate_query + "  " + edate_query;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
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

	public Activity() {
	}

	public Activity(String n, String v, String evnt_name, Date d, Time st,
			Time et, Database db) {

		this.name = n;
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;

		String date_query = d.getYear() + "-" + d.getMonth() + "-"
				+ d.getDate();
		String etime_query = et.getHours() + ":" + et.getMinutes() + ":"
				+ et.getSeconds();
		String stime_query = st.getHours() + ":" + st.getMinutes() + ":"
				+ st.getSeconds();

		db.runUpdate(
				"INSERT INTO ",
				"activity(event_name, activity_name, venue, startdate, starttime, endtime)",
				"VALUES('" + evnt_name + "','" + this.name + "','" + this.venue
						+ "','" + date_query + "','" + stime_query + "','"
						+ etime_query + "')", "", "");

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

	public String printActivities(Database db) {
		ResultSet tempRs;
		String temp = null;
		tempRs = db.runQuery("select * from activity", "", "", "", "");
		try {
			while (tempRs.next()) {
				int id = tempRs.getInt("activity_id");
				String event_name = tempRs.getString("event_name");
				String name = tempRs.getString("activity_name");
				Date sdate = tempRs.getDate("startdate");
				Time stime = tempRs.getTime("starttime");
				Time etime = tempRs.getTime("endtime");
				String venue = tempRs.getString("venue");

				String sdate_query = sdate.getYear() + "-" + sdate.getMonth()
						+ "-" + sdate.getDate();
				String stime_query = stime.getHours() + "-" + stime.getMinutes()
						+ "-" + stime.getSeconds();
				String etime_query = etime.getHours() + "-" + etime.getMinutes()
						+ "-" + etime.getSeconds();

				temp = id + " " + name;
				temp += "\n";
				temp = temp + venue;
				temp += "\n";
				temp = temp + sdate_query;
				temp += "\n";
				temp = temp = stime_query + "  " + etime_query;
				temp += "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
}