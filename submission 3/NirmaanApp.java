import java.sql.ResultSet;

public class NirmaanApp {

	public static void main(String[] args) {
		executeScript("create_database.sh");
		final boolean signup;
		ResultSet result;

		// Database user credentials
		final String USER = "tempUser";
		final String PASS = "";

		Coordinator cod1 = new Coordinator("abc", "efg", "hij", "klm");
		cod1.signup("cod1_nirmaan", "cod1_pass");
		

		Database db = new Database(USER, PASS);
		db.runQuery("SELECT ", "*", " FROM ", "userData", "");
		// db.runQuery("INSERT", "INTO", "userData", tables, lastPart)

		System.out.println("Bye, Bye!!!!");
	}

	public static void executeScript(String path) {
		try {
			ProcessBuilder pb = new ProcessBuilder(path);
			Process p = pb.start(); // Start the process.
			p.waitFor(); // Wait for the process to finish.
			System.out.println("Script executed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}