package com.nirmaan.main;

import com.nirmaan.database.Database;
import com.nirmaan.people.Coordinator;
import com.nirmaan.people.Member;

public class NirmaanApp {

	public static void main(String[] args) {
		executeScript("./create_database.sh");

		// Database user credentials
		final String USER = "tempUser";
		final String PASS = "";
		
		Database db = new Database(USER, PASS);

//		Coordinator cod1 = new Coordinator("abc", 243, "hij", "klm");
//		cod1.signup("cod1_nirmaan", "cod1_pass", db);
		
//		Member m1 = new Member();
//		m1.login("cod1_nirmaan", "cod1_pass", db);

//		db.runQuery("SELECT ", "*", " FROM ", "userData", "");
//		db.runUpdate("INSERT ", "INTO ",
//				"userData(name,id,email,phone,username,passowrd) ",
//				"VALUES('abc',242,'abc@gmail.com','9876543210','phoenix','inspiron') ","");

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