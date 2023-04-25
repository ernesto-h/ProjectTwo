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



/* ************************CHANGE LOG***********************************
 * 4/24 E.H.
 * class created
 * includes variables, getters/setters, constructor, and two undefined methods
 * 
 * 4/24 E.H.
 * added toString override
 * added main method to test methods locally
 * added a method called writeResume(). The method is incomplete, but mainly just needs
 * print statements with dialogue that will queue the user to input info relevant to a resume. 
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {

	/*
	 * Users should have:
	 * ID
	 * Email
	 * Phone Number
	 * Resume as a .txt file
	 */
	static Scanner in = new Scanner(System.in);

	private String id;
	private String email;
	private String phoneNum; // phone number
	private String resume; // this may be incorrect

	// Constructor
	public User(String id, String email, String phoneNum) {
		this.id = id;
		this.email = email;
		this.phoneNum = phoneNum;
	}

	public static void main(String[] args) {

		User u = new User("123", "123@gmail", "956-444-4444");

		System.out.println(u.toString());
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

	public void writeResume() {
		String f;
		String d;
		String fileName;
		String directory;
		File file;

		// do this while f isn't null or empty
		do {
			System.out.println("Welcome, User " + id + ". Let's build your resume!");
			System.out.println("What would you like to name your resume file?");
			System.out.println("Enter desired file name: ");
			// adding \ to the beginning of the file name so it can be concatenated to d(below)
			// adding 
			// ex: if file name is resume --> \resume
			f = in.nextLine();
			String slash = "\\\\";
			String txt = ".txt";
			fileName = slash.concat(f.trim()).concat(txt);
		} while (!(f == null || f.isEmpty()));


		// do this while d isn't null or empty, or while file isn't a directory
		do {
		System.out.println("Where would you like to save your resume?");
		System.out.println("Please enter a file directory where you would like to save your resume.");
		System.out.println("Ex: C:\\Users\\Owner\\Documents");
		d = in.nextLine();
		directory = d.trim().concat(fileName);
		file = new File(directory);
		}while(!(d == null || d.isEmpty() || file.isDirectory()));
		
		
		// this try-catch block will contain the code that will queue the user
		// to enter info relevant to a resume
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			
			//this block of code will be where I queue the user to input info
			//that will go on their resume
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		

	}

	@Override
	public String toString() {
		return "USER ID: " + id + 
				"\nUSER EMAIL: " + email + 
				"\nUSER PH. NUMBER: " + phoneNum ;
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
