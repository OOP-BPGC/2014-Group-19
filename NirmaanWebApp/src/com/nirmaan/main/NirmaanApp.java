package com.nirmaan.main;

import java.util.Date;

import com.nirmaan.database.Database;
import com.nirmaan.others.Event;
import com.nirmaan.others.Feed;
import com.nirmaan.people.Coordinator;
import com.nirmaan.people.Member;
import com.nirmaan.people.Student;

public class NirmaanApp {

	public static void main(String[] args) {

		// Database user credentials
		final String USER = "tempUser";
		final String PASS = "abc";
		
		Database db = new Database(USER, PASS);
		db.exportAllData();
		
		Feed f = new Feed("Test Feed", "This feed is only for testing purpose!!!", db);
		
		Student s = new Student();
		System.out.println(s.search("varsheeth"));
//		Event e = new Event("Joy of Enjoying", new Date("2013-11-13"),  new Date("2013-11-14"), db);

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

}