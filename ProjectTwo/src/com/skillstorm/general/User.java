package com.skillstorm.general;
/*
 * Users should have:
 * ID
 * Email
 * Phone Number
 * Resume as a .txt file
 * 
 * Be able to create a new account.
 * 
 * Application should allow multiple user accounts and should persist info on the user
 * and their resume across application runs
 * 
 * 		- User info needs to be persisted to and read from a csv file called "Users.csv"
 * 
 * 		- The Users.csv file needs to live in a folder called "Users"
 * 
 * 		- User resumes should be their own file on the file system inside of a folder called:
 * "Users/<user name>" (Take them through the prompts every time they want to create a resume
 * and overwrite the file)
 * 
 * 		- Users should have a password, and users should not be able to "sign in" to an account if their
 * password is entered incorrectly
 * 
 * 		- Users should not be able to access other user's information
 * 
 * Users should be able edit their own info
 */

import java.io.File;

public class User {

	/*
	 * Users should have:
	 * ID
	 * Email
	 * Phone Number
	 * Resume as a .txt file
	 */

	private String id;
	private String email;
	private String phoneNum; // phone number
	private File resume; // this may be incorrect
	
	// Constructor
	public User(String id, String email, String phoneNum) {
		this.id = id;
		this.email = email;
		this.phoneNum = phoneNum;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////METHODS//////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void createAcct() {
		// I want this to allow users to make a new account
	}
	
	public static void editInfo() {
		// I want this to allow users to edit their own info
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////SETTERS N GETTERS/////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getPhoneNum() {
		return this.phoneNum;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
}//class
