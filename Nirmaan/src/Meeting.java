import java.sql.Time;
import java.util.Date;

public class Meeting {
	private Time startTime;
	private Time endTime;
	private Date date;
	private String venue;

	public Meeting(String v, Date d, Time st, Time et) {
		this.venue = v;
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}
}
