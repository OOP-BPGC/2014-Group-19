import java.sql.Time;
import java.util.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coordinator extends Student {

	public Coordinator(String n, String id, String e, String p) {
		super(n, id, e, p);
	}

	public boolean scheduleMeeting(Date date, Time startTime, Time endTime,
			String venue) {

	}

	public boolean scheduleEvent(String name, Date startDate, Date endDate) {

	}

	public boolean postFeed(String msg) {

	}

	public boolean openRegistration(Event evt) {

	}

	public boolean closeRegistration(Event evt) {

	}
	
	
	public void promote(Event event) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Nirmaan Event!!! --" + event.name);
			System.out.println("Starts on " + event.startDate + "\t Ends on "+ event.endDate);
			System.out.println("Do attend the event!!!!");	
		}	
	}
	
	public String search(String key) {

		Pattern pat;
		Matcher mat;
		String result = "";
		pat = Pattern.compile(".*" + key + ".*");

		try {
			FileInputStream fstream = new FileInputStream("file.txt");
			DataInputStream ind = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(ind));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				mat = pat.matcher(strLine);
				boolean found = mat.matches();
				if (found) {
					result +=('\n'+strLine);
				}
			}
			ind.close();
		} catch (IOException  e) {
			return "Error: " + e.getMessage();
		}
		return result;
	}
	
}
