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
 * 4/25 E.H.
 * added a static scanner to the class
 * writeResume() is mostly complete
 * fixed the do while loops
 * I made it able to create .txt and .md files.
 * need to add a couple try catch blocks
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
import java.util.regex.Matcher;
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
	private String name;
	private String email;
	private String phoneNum; // phone number
	private String resume; // this may be incorrect




	// Constructor
	public User() {

	}
	public User(String id, String name, String email, String phoneNum) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
	}



	public static void main(String[] args) {

		User u = new User("123", "Don Pickle",  "123@gmail", "956-444-4444");
		User du = new User();



		du.writeResume();
		//System.out.println(du.createFolder("C:\\\\Users\\\\Owner\\\\Documents"));

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////METHODS//////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	// needs work
	public static void createAcct() {
		// I want this to allow users to make a new account
	}

	// needs work
	public static void editInfo() {
		// I want this to allow users to edit their own info
	}

	public boolean createFolder(String s) {

		String str = s;
		File folder = new File(s.concat("\\\\").concat("Users"));
		if(folder.mkdir() == false) {
			return false;
		}else {
			return true;
		}
	}



	public void writeResume() {
		//incomplete
		//			file.mkdirs();  <- this will create a new folder
		//			\t in a string is like using tab (inserts space
		//			ex: "\texample" <-> "	example"
		String f;
		String d;
		String fileName;
		String directory;
		File file;
		File folder = new File("Users");
		String fileType;
		String slash = "\\\\";
		String txt = ".txt";
		String md = ".md";



		do { // do this until user inputs t or m when prompted
			System.out.println("Hi, " + getName() + ". Let's build your resume!");
			System.out.println();
			System.out.println("Enter t to create a .txt file, or m to create a .md file.");
			fileType = in.nextLine();

			do { 
				// needs work
				// can keep this option to name the file, or delete this
				// loop and set the file name to getName()

				// do this until user inputs a valid file name
				System.out.println();
				System.out.println("-----------------------------------------------------------------");
				System.out.println("Enter a name for your file.");
				System.out.println("File names cannot include the following characters:");
				System.out.println("< : \" / \\ | ? *");
				fileName = slash.concat(in.nextLine().trim());
			}while( 
					fileName.contains("<") &&
					fileName.contains(":")	&&
					fileName.contains("\"") &&
					fileName.contains("/") &&
					fileName.contains("\\") &&
					fileName.contains("|") &&
					fileName.contains("?") &&
					fileName.contains("*")
					);


			// this if else statement concatenates .txt to the end of fileName if user chooses t
			// or .md if the user chooses m
			if (fileType.equalsIgnoreCase("t")) {
				fileName += txt;
				//fileName = slash.concat(getName().trim()).concat(txt);
			}else {
				fileName += md;
				//fileName = slash.concat(getName().trim().concat(md));
			}
		}while( (!fileType.equalsIgnoreCase("m") && !fileType.equalsIgnoreCase("t")) );



		do { // do this while d is null or empty, or while file isn't a directory
			// needs work
			System.out.println();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("A new folder named Users will be created and will store your resume file.");
			System.out.println();
			System.out.println("Please enter the file directory to your Documents folder.");
			System.out.println("Use two backslashes and follow the format in the example below.");
			System.out.println("Ex: C:\\\\Users\\\\Owner\\\\Documents");
			// copy this for your input: C:\\Users\\Owner\\Documents
			d = in.nextLine();
			
			createFolder(d);

			//directory = d.trim().concat(fileName);	
			directory = d.trim().concat(slash).concat("Users").concat(fileName);	
			file = new File(directory);

		}while((d == null || d.isEmpty() || file.isDirectory() ));


		// this try-catch block will contain the code that will queue the user
		// to enter info relevant to a resume
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){

			System.out.println("What's your name?");
			name = in.nextLine();
			bw.write(name.trim());
			bw.newLine();

			System.out.println("What's your email?");
			email = in.nextLine();
			bw.write(email);
			bw.newLine();

			System.out.println("What's your phone number?");
			System.out.println("Phone number must be in xxx-xxx-xxxx format.");
			phoneNum = in.nextLine();
			bw.write(phoneNum);
			bw.newLine();

			//this block of code will be where I queue the user to input info
			//that will go on their resume

		}catch (IOException ex) { 
			ex.printStackTrace();}

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
}//class
