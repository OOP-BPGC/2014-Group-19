import java.sql.ResultSet;

public class NirmaanApp {

	public static void main(String[] args) {
		final boolean signup;
		ResultSet result;

		// Database user credentials
		final String USER = "tempUser";
		final String PASS = "";

//		Coordinator cod1 = new Coordinator("abc", "efg", "hij", "klm");
//		cod1.signup("cod1_nirmaan", "cod1_pass");

		Database db = new Database(USER, PASS);
		db.runQuery("SELECT ", "username,passowrd", " FROM ", "userData", "");
		
		System.out.println("Bye, Bye!!!!");
	}

}