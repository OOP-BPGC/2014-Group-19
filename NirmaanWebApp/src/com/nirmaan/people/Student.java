package com.nirmaan.people;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Student {
	protected String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isFeedVariable() {
		return feedVariable;
	}

	public void setFeedVariable(boolean feedVariable) {
		this.feedVariable = feedVariable;
	}

	protected String email;
	protected int id;
	protected String phone;
	protected boolean feedVariable = false;

	public Student() {
	}

	public Student(String n, int id, String em, String ph) {
		this.name = n;
		this.id = id;
		this.email = em;
		this.phone = ph;
	}

	public String search(String s) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		int resultCount = 0;

		File dir = new File("/home/lelouch/temp/"); // path
																				// of
																				// directory
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {

				try {
					br = new BufferedReader(new FileReader(child));
					String line;
					try {
						while ((line = br.readLine()) != null) {

							String lineLower = line.toLowerCase(); // to ignore
																	// case in
																	// search
							// processing the line
							if (lineLower
									.matches(".*" + s.toLowerCase() + ".*")) {
								resultCount++;
								sb.append("Search Result No." + resultCount
										+ "     :	");// may remove this
								sb.append(line);
								sb.append("\n"); // nextLine
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		} else {
			System.out.println("No such directory found");
		}

		return sb.toString();
	}

	public String encryptPassword(String inputPassword) {
		String passwordToHash = inputPassword;
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(generatedPassword);
		return generatedPassword;
	}
}
