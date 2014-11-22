package com.nirmaan.others;
import java.sql.Time;
import java.util.Date;

/**
 * @author Group-19
 *
 */
public class Meeting {
	private Time startTime;
	private Time endTime;
	private Date date;
	private String venue;

	/**
	 * @param v venue
	 * @param d date
	 * @param st start time
	 * @param et end time
	 */
	public Meeting(String v, Date d, Time st, Time et) {
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}
}
