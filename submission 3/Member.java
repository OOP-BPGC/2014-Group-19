import java.util.Date;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member extends Student {
	protected String username;
	protected String password;
	protected Date tillWhen;

	public Member() {
		super();
	}

	public Member(String n, String id, String e, String p) {

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

	public void promote(Event event) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Nirmaan Event!!! --" + event.name);
			System.out.println("Starts on " + event.startDate + "\t Ends on "
					+ event.endDate);
			System.out.println("Do attend the event!!!!");
		}
	}

	public boolean subscribeToFeed() {
		if (this.feedVariable == false) {
			this.feedVariable = true;
			System.out.println("Thanks for Subscribing!!!");
			return true;
		} else
			return false;
	}

	public String seeSchedule() {
		return "Done";

	}

	public boolean enrollforEvent(Event evt) {
		return false;

	}
}
