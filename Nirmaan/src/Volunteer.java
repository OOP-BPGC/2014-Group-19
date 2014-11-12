public class Volunteer extends Student {
	private String username;
	private String password;

	public Volunteer() {
		super();
	}

	public Volunteer(String n, String id, String e, String p) {
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

	public boolean login(String user, String pass) {

	}

	public boolean logout() {

	}

	public void promote(Event event) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Nirmaan Event!!! --" + event.name);
			System.out.println("Starts on " + event.startDate + "\t Ends on "
					+ event.endDate);
			System.out.println("Do attend the event!!!!");
		}
	}

	public String search(String str) {

	}

	public boolean subscribeToFeed() {

	}

	public String seeSchedule() {

	}

	public boolean enrollforEvent(Event evt) {

	}
}
