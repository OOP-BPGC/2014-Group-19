package com.nirmaan.main;

import java.sql.Time;
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
		
//		
		
		
//		Feed f = new Feed("Test Feed", "This feed is only for testing purpose!!!", db);
//		
//		Student s = new Student();
//		System.out.println(s.search("varsheeth"));
	//	Event e = new Event("Joy of coding", new Date("2015-11-13"),  new Date("2015-11-20"), db);

		Coordinator cod1 = new Coordinator("abc", 245, "hij", "klm");
		cod1.scheduleEvent("Demo13", new Date(2015,2,16), new Date(2015,2,17), db);
		
//		boolean  temp = cod1.scheduleMeeting(new Date(2014,11,13), new Time(20,10,00), "B-Dome", db);
//		System.out.println(temp);
		
//		Member m1 = new Member();
//		m1.login("cod1_nirmaan", "cod1_pass", db);

//		db.runQuery("SELECT ", "*", " FROM ", "userData", "");
//		db.runUpdate("INSERT ", "INTO ",
//				"userData(name,id,email,phone,username,passowrd) ",
//				"VALUES('abc',242,'abc@gmail.com','9876543210','phoenix','inspiron') ","");

		System.out.println("Bye, Bye!!!!");
	}

}