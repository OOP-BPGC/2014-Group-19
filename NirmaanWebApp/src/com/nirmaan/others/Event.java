package com.nirmaan.others;

import java.sql.Time;
import java.util.*;

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

	/**
	 * @return memberList
	 */
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

	/**
	 * @param n name
	 * @param sd startDate
	 * @param ed endDate
	 */
	public Event(String n, Date sd, Date ed) {
		this.name = n;
		this.startDate = sd;
		this.endDate = ed;
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

	/**
	 * @param n name
	 * @param v venue
	 * @param d date
	 * @param st startDate
	 * @param et endDate
	 */
	public Activity(String n, String v, Date d, Time st, Time et) {
		this.name = n;
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}
}
