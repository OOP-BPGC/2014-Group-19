import java.sql.Time;
import java.util.*;

public class Event {

	protected String name;
	protected Date startDate;
	protected Date endDate;
	protected ArrayList<Activity> activityList;
	protected ArrayList<Member> memberList;
	protected ArrayList<Volunteer> volunteerList;

	public Event(String n, Date sd, Date ed) {
		this.name = n;
		this.startDate = sd;
		this.endDate = ed;
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