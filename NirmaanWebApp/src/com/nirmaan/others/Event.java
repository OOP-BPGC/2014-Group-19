package com.nirmaan.others;

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

	public Event(String name, Date sd, Date ed, Database db) {
		this.name = name;
		this.startDate = sd;
		this.endDate = ed;

		db.runUpdate("INSERT INTO ", "events(event_name, startDate, endDate)",
				"VALUES('" + this.getStartDate().toString() + "','"
						+ this.getEndDate().toString() + "')", "", "");
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
}

class Activity {

	private String name;
	private Time startTime;
	private Time endTime;
	private Date date;
	private ArrayList<Member> memberList;
	private ArrayList<Volunteer> volunteerList;
	private String venue;

	public Activity(String n, String v, Date d, Time st, Time et) {
		this.name = n;
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}
}