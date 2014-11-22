package com.nirmaan.others;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

<<<<<<< HEAD
import com.nirmaan.database.Database;

=======
/**
 * @author Group-19
 *
 */
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
public class Meeting {
	private Time startTime;
	private Date date;
	private String venue;

<<<<<<< HEAD
	public Meeting(String v, Date d, Time st, Database db) {
=======
	/**
	 * @param v venue
	 * @param d date
	 * @param st start time
	 * @param et end time
	 */
	public Meeting(String v, Date d, Time st, Time et) {
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
		this.venue = v;
		this.date = d;
		this.startTime = st;
		
		String time_query = st.getHours() + ":" + st.getMinutes() + ":" + st.getSeconds();
		String date_query = d.getYear() + "-" + d.getMonth() + "-" + d.getDate();

		db.runUpdate("INSERT INTO ", "meeting(meet_venue, meet_date, meet_time)",
				"VALUES('" + this.venue + "','"+ date_query + "','"
						+ time_query + "')", "", "");
	}

	public Meeting() {
		// TODO Auto-generated constructor stub
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public void printMeetings(Database db) {
		ResultSet tempRs;
		tempRs = db.runQuery("select * from meeting", "", "", "", "");
		try {
			while (tempRs.next()) {
				String id = tempRs.getString("meet_id");
				String venue = tempRs.getString("meet_venue");
				Date date = tempRs.getDate("meet_date");
				Time time = tempRs.getTime("meet_time");

				System.out.println(id + "," + venue + "," + date.toString() + "," + time.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
