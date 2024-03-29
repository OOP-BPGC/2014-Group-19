import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/nirmaan";

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pStmt = null;

	public Database(String user, String pass) {
		if (this.createConnection(user, pass) != null) {
			System.out.println("Connection to database successfull!!!");
		}
	}

	public Connection createConnection(String user, String pass) {

		try {
			// Register for JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a Connection
			System.out.println("Opening a connection......");
			conn = DriverManager.getConnection(DB_URL, user, pass);
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
		return conn;
	}

	public PreparedStatement prepStatement(String query) {
		String sql = query;
		// Executing a query
		System.out.println("Creating a statement.....");
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Statement prepared successfully!!!");
		return pStmt;
	}

	public void displayResults(ResultSet result) {
		try {
			while (result.next()) {
				// Retrieve by column name
				String name = result.getString("name");
				String id = result.getString("id");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String username = result.getString("username");
				String password = result.getString("passowrd");

				// Display values
				System.out.print("Name: " + name);
				System.out.print(", ID: " + id);
				System.out.print(", E-Mail: " + email);
				System.out.print(", Contact: " + phone);
				System.out.print(", Login name: " + username);
				System.out.println(", Password: " + password);
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertTouser(String name, String id, String email,
			String phone, String username, String password) {
		ResultSet rst;
		PreparedStatement tempStmt;
		tempStmt = prepStatement("INSERT INTO userData VALUES(?,?,?,?,?,?)");
		// bind values to parameters
		try {
			tempStmt.setString(1, name);
			tempStmt.setString(2, id);
			tempStmt.setString(3, email);
			tempStmt.setString(4, phone);
			tempStmt.setString(5, username);
			tempStmt.setString(6, password);
			tempStmt.executeUpdate();

			rst = tempStmt.executeQuery("SELECT * from userData");
			displayResults(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean runQuery(String firstPart, String columns,
			String secondPart, String tables, String lastPart) {
		String query = firstPart;
		int count = 0;
		ResultSet tempRs;
		Statement tempStmt = null;
		// making query from arguments
		query += columns;
		query += secondPart;
		query += tables;
		query += lastPart;
		try {
			System.out.println(query);
			tempStmt = conn.createStatement();
			tempRs = tempStmt.executeQuery(query);
			displayResults(tempRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean closeConnections() {
		try {
			if (this.stmt != null)
				this.stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		try {
			if (this.conn != null)
				this.conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		System.out.println("Database Connections cloased successfully.");
		return true;
	}

}
