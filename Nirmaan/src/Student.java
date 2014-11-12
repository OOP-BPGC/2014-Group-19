public class Student {
	protected String name;
	protected String email;
	protected String id;
	protected String phone;

	public Student() {
	}

	public Student(String n, String id, String e, String p) {
		this.name = n;
		this.id = id;
		this.email = e;
		this.phone = p;
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
}
