package com.nirmaan.servlets;

public class User {
	
	public static String name;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		User.name = name;
	}
	
	private User(){
		
	}
	
}
