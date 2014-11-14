import java.sql.Time;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coordinator extends Member {

	public Coordinator(String n, String id, String e, String p) {
		super(n, id, e, p);
	}

	public boolean signup(String name, String email, String id, String phone,
			String user, String pass) {
		try {
			this.name = name;
			this.id = id;
			this.email = email;
			this.phone = phone;
			this.username = user;
			this.password = pass;
		} catch (Exception e) {
			System.out.println("Signup Failed due to error : ");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean signup(String user, String pass) {
		try {
			this.username = user;
			this.password = pass;
		} catch (Exception e) {
			System.out.println("Signup Failed due to error : ");
			e.printStackTrace();
			return false;
		}
		System.out.println("Sign Up successful!!!");
		return true;
	}

	public boolean login(String user, String pass) {
		pass = this.encryptPassword(pass);
		return false;
	}

	public boolean logout() {
		return false;

	}

	public boolean scheduleMeeting(Date date, Time startTime, Time endTime,
			String venue) {
				return false;

	}

	public boolean scheduleEvent(String name, Date startDate, Date endDate) {
		return false;

	}
	
	public boolean scheduleActivity(String name, Date startDate, Date endDate, Time startTime, Time endTime) {
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

	public void promote(Event event) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Nirmaan Event!!! --" + event.name);
			System.out.println("Starts on " + event.startDate + "\t Ends on "
					+ event.endDate);
			System.out.println("Do attend the event!!!!");
		}
	}

}
