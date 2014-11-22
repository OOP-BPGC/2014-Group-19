package com.nirmaan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class having all methods to make connection to online localhost H2 database
 */
public class Database {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String DB_URL = "jdbc:h2:tcp://localhost/~/nirmaanTemp";

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pStmt = null;

	/**
	 * Constructor 
	 * @param user the username
	 * @param pass the password
	 */
	public Database(String user, String pass) {
		if (this.createConnection(user, pass) != null) {
			System.out.println("Connection to database successfull!!!");
		}
	}

	/**
	 * @param user the username
	 * @param pass the password
	 * @return
	 */
	public Connection createConnection(String user, String pass) {

		try {
			// Register for JDBC Driver
			Class.forName(JDBC_DRIVER);

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

	/**
	 * @param query the method that executes queries sent to the database engine
	 * @return  PreparedStatement
	 */
	public PreparedStatement prepStatement(String query) {
		PreparedStatement tempStmt = null;
		String sql = query;
		// Executing a query
		System.out.println("Creating a statement.....");
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		tempStmt = pStmt;
		System.out.println("Statement prepared successfully!!!");
		return tempStmt;
	}

	/**
	 * @param result  The method to display all the results
	 */
	public void displayResults(ResultSet result) {
		try {
			while (result.next()) {
				// Retrieve by column name
				String name = result.getString("name");
				String id = result.getString("id");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String username = result.getString("username");
				String password = result.getString("password");

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
			System.exit(0);
		}
	}

	/**
	 * @param name name
	 * @param id id
	 * @param email email
	 * @param phone phone
	 * @param username username
	 * @param password password
	 * @return boolean
	 */
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

	/**
	 * @param firstPart  firstPart
	 * @param columns columns
	 * @param secondPart secondPart
	 * @param tables tables
	 * @param lastPart lastPart
	 * @return ResultSet
	 */
	public ResultSet runQuery(String firstPart, String columns,
			String secondPart, String tables, String lastPart) {
		String query = firstPart;
		ResultSet tempRs = null;
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
			// displayResults(tempRs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return tempRs;
	}

	/**
	 * @param firstPart
	 * @param columns
	 * @param secondPart
	 * @param tables
	 * @param lastPart
	 * @return boolean
	 */
	public boolean runUpdate(String firstPart, String columns,
			String secondPart, String tables, String lastPart) {
		String query = firstPart;
		Statement tempStmt = null;

		// making query from arguments
		query += columns;
		query += secondPart;
		query += tables;
		query += lastPart;

		try {
			System.out.println(query);
			tempStmt = conn.createStatement();
			tempStmt.execute(query);
			System.out.println("Executed runUpdate..");
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getErrorCode() == 23505)	{
				System.out.println("Already Eists!!!");
			}
			System.exit(0);
		}
		return true;
	}

	/**
	 * @return boolean
	 */
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
		System.out.println("Database Connections closed successfully.");
		return true;
	}

	public void exportData(String filename, String tablename) {
		Statement stmt;
		String query = "";
		try {
			// stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			stmt = conn.createStatement();

			// For comma separated file
			query = "call CSVWRITE ( '" + filename + "', 'SELECT * FROM "
					+ tablename + "' ) ";

			stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
			stmt = null;
		}
	}

	public void exportAllData() {
		this.exportData("/home/lelouch/temp/userData.csv", "userData");
		this.exportData("/home/lelouch/temp/events.csv", "events");
		this.exportData("/home/lelouch/temp/activity.csv", "activity");
		this.exportData("/home/lelouch/temp/feed.csv", "feed");
		this.exportData("/home/lelouch/temp/meeting.csv", "meeting");

	}

}
