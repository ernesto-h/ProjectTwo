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
		String fileType;
		String slash = "\\\\";
		String txt = ".txt";
		String md = ".md";

		String resName;
		String resEmail;
		String resPhoneNum;
		String resLocation;
		String persStmnt;
		String ynChoice;
		String ynChoice2;
		String langs;
		String hardSkills;
		String softSkills;
		String jobTitle;
		String coName;
		String tPeriod;
		String jobDescr;
		String schoolName;
		String degree;
		String gradYr;





		do { // do this until user inputs t or m when prompted
			System.out.println("Hi, " + getName() + ". Let's build your resume!");
			System.out.println();
			System.out.println("For starters, lets create a file.");
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

				System.out.println("Thanks!");
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
			System.out.println("Now, lets put that resume somewhere easily accessible.");
			System.out.println("We'll create a new folder for you named Users.");
			System.out.println("You'll be able to find your resume in this folder.");
			System.out.println();
			System.out.println("Now we just need one more thing before we move on.");
			System.out.println("Please enter the file directory to your Documents folder.");
			System.out.println("You can follow the format in the example below, and remember to use two backslashes.");
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

			System.out.println("Whew, now that that's taken care of, lets start filling in your resume!");
			System.out.println("We'll begin with some contact info.");
			System.out.println("");
			System.out.println("What's your full name?");
			resName = in.nextLine();
			bw.write(resName.trim());
			bw.newLine();

			System.out.println("What's your email?");
			resEmail = in.nextLine();
			bw.write(resEmail);
			bw.newLine();

			System.out.println("Phone number?");
			System.out.println("We recommend using the xxx-xxx-xxxx format.");
			resPhoneNum = in.nextLine();
			bw.write(resPhoneNum);
			bw.newLine();

			System.out.println("What city and state do you live in?");
			resLocation = in.nextLine();
			bw.write(resLocation);
			bw.newLine();

			System.out.println("Great, now we'll add your personal statement.");
			System.out.println("This should be a brief, engaging text about yourself.");
			System.out.println("Try to add a short description of an important achievement and some key ");
			System.out.println("information about your education, experience, and skills relative to the job");
			System.out.println("you're applying for. Overall, the personal statement should be around 3 to 5 sentences long.");
			System.out.println();
			System.out.println("Enter your personal statement.");
			persStmnt = in.nextLine();
			bw.write(persStmnt);

			System.out.println("Nice!");
			System.out.println("Lets put some of your skills on display.");
			System.out.println("Do you know any languages?");
			do { // do this until user enters yes or no or y or n
				System.out.println("Enter yes or no.");
				ynChoice = in.nextLine();
			}while (!(ynChoice.equalsIgnoreCase("yes") &&
					!(ynChoice.equalsIgnoreCase("y") &&
							!(ynChoice.equalsIgnoreCase("no") &&
									!(ynChoice.equalsIgnoreCase("n")
											)))));
			if(ynChoice.equalsIgnoreCase("y") || ynChoice.equalsIgnoreCase("yes")) {
				System.out.println("Impressive!");
				System.out.println("Enter the languages you know separated by commas.");
				langs = in.nextLine();
				bw.write("Languages:");
				bw.newLine();
				bw.write(langs);
				bw.newLine();
			}else if (ynChoice.equalsIgnoreCase("n") || ynChoice.equalsIgnoreCase("no")) {
				System.out.println("No worries! Lets move on to the next section.");
			}
			
			System.out.println("Do you have any technical skills?");
			do { // do this until user enters yes or no or y or n
				System.out.println("Enter yes or no.");
				ynChoice = in.nextLine();
			}while (!(ynChoice.equalsIgnoreCase("yes") &&
					!(ynChoice.equalsIgnoreCase("y") &&
							!(ynChoice.equalsIgnoreCase("no") &&
									!(ynChoice.equalsIgnoreCase("n")
											)))));
			if(ynChoice.equalsIgnoreCase("y") || ynChoice.equalsIgnoreCase("yes")) {
				System.out.println("Enter your skills separated by commas.");
				hardSkills = in.nextLine();
				bw.write("Technical Skills:");
				bw.newLine();
				bw.write(hardSkills);
				bw.newLine();
				System.out.println("Very nice!");
			}else if (ynChoice.equalsIgnoreCase("n") || ynChoice.equalsIgnoreCase("no")) {
				System.out.println("No worries! Lets move on to the next section.");
			}
			
			System.out.println("Everyone has some soft skills, so take some time to add some of yours!");
			System.out.println("Soft skills are skills like \"Leadership\" or \"Adaptable\".");
			System.out.println("Enter a few soft skills separated by commas.");
			softSkills = in.nextLine();
			bw.write("Soft Skills:");
			bw.newLine();
			bw.write(softSkills);
			bw.newLine();
			System.out.println("Well done!");
			
			System.out.println("Alright, we're almost done! Lets get down to the meat and potatoes of your resume.");
			System.out.println("These are your Education and Work histories.");
			System.out.println("Lets knock out your Work History first.");
			System.out.println("Do you have any previous or current employment history you'd like to add?");
			System.out.println("Remember to keep it relative to the job you're applying for.");
			System.out.println();
			do { // do this until user enters yes or no or y or n
				System.out.println("Enter yes or no.");
				ynChoice = in.nextLine();
			}while (!(ynChoice.equalsIgnoreCase("yes") &&
					!(ynChoice.equalsIgnoreCase("y") &&
							!(ynChoice.equalsIgnoreCase("no") &&
									!(ynChoice.equalsIgnoreCase("n")
											)))));
			if(ynChoice.equalsIgnoreCase("y") || ynChoice.equalsIgnoreCase("yes")) {
				
				do {
				System.out.println("Enter the job title.");
				jobTitle = in.nextLine();
				bw.write("Job History:");
				bw.newLine();
				bw.write(jobTitle);
				bw.newLine();
				System.out.println("Enter the name of the company that employed you.");
				coName = in.nextLine();
				bw.write(coName);
				bw.newLine();
				System.out.println("Enter the time period you were employed.");
				System.out.println("We recommend the following format: mm/yyyy - mm/yyyy");
				tPeriod = in.nextLine();
				bw.write(tPeriod);
				bw.newLine();
				System.out.println("Write one to three sentences describing your roles and responsibilities.");
				jobDescr = in.nextLine();
				bw.write(jobDescr);
				bw.newLine();
				System.out.println("Very nice!");
				System.out.println("Would you like to enter another job?");
				ynChoice2 = in.nextLine();
				}while(ynChoice2.equalsIgnoreCase("y") || ynChoice2.equalsIgnoreCase("yes"));
				
				if (ynChoice2.equalsIgnoreCase("n") || ynChoice2.equalsIgnoreCase("no")) {
					System.out.println("No worries! Lets move on to the next section.");
				}
				
			}else if (ynChoice.equalsIgnoreCase("n") || ynChoice.equalsIgnoreCase("no")) {
				System.out.println("No worries! Lets move on to the next section.");
			}
			
			
			
			
			System.out.println("Time to add your Education History!");
			System.out.println("Do you have any previous or current education history you'd like to add?");
			System.out.println();
			do { // do this until user enters yes or no or y or n
				System.out.println("Enter yes or no.");
				ynChoice = in.nextLine();
			}while (!(ynChoice.equalsIgnoreCase("yes") &&
					!(ynChoice.equalsIgnoreCase("y") &&
							!(ynChoice.equalsIgnoreCase("no") &&
									!(ynChoice.equalsIgnoreCase("n")
											)))));
			if(ynChoice.equalsIgnoreCase("y") || ynChoice.equalsIgnoreCase("yes")) {
				
				do {
				System.out.println("Enter the school's name.");
				schoolName = in.nextLine();
				bw.write("Education History:");
				bw.newLine();
				bw.write(schoolName);
				bw.newLine();
				System.out.println("Enter degree earned or total credit hours earned if incomplete.");
				degree = in.nextLine();
				bw.write(degree);
				bw.newLine();
				System.out.println("Enter your gradation year.");
				gradYr = "Graduation date: ";
				gradYr += in.nextLine();
				bw.write(gradYr);
				bw.newLine();
				System.out.println();
				System.out.println("Very nice!");
				System.out.println("Would you like to enter another educational institution?");
				ynChoice2 = in.nextLine();
				}while(ynChoice2.equalsIgnoreCase("y") || ynChoice2.equalsIgnoreCase("yes"));
				
				if (ynChoice2.equalsIgnoreCase("n") || ynChoice2.equalsIgnoreCase("no")) {
					System.out.println("No worries!");
				}
				
			}else if (ynChoice.equalsIgnoreCase("n") || ynChoice.equalsIgnoreCase("no")) {
				System.out.println("No worries!");
			}
			
			System.out.println("Congratulations, " + getName() + ", you've succesfully created your resume.");
			System.out.println("You'll be working at your dream job in no time!");
			

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
