package com.skillstorm.general;

import java.util.Scanner;

public class JobsRUs {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		runApplication();
	}// main method

	public static void runApplication() {
		int choice1;
		int choice2;

		do {
			System.out.println("Welcome to Jobs R Us!");
			System.out.println("Enter 1 if you're a returning customer.");
			System.out.println("Enter 2 to continue as a guest.");
			System.out.println("Enter 3 to create a new account.");
			System.out.println("Please enter your choice.");

			choice1 = in.nextInt();

			if (choice1 == 1) {		
				/*
				 * this needs to be filled in with user's persisted info/account 
				 * need to create a method in Users that does this (or something similar)
				 * account should have a primary resume
				 * account should show jobs that have been applied to
				 */
				do {
					System.out.println("What would you like to do?");
					System.out.println("Enter 1: Search job listings.");
					System.out.println("Enter 2: Edit current resume.");
					System.out.println("Enter 3: Create new resume.");
					System.out.println("Enter 4: Edit account information.");

					choice2 = in.nextInt();

					if(choice2 == 1) {
						// needs work
						// Search job listings
					}
					
					if(choice2 == 2) {
						// needs work
						// Edit current resume
					} 
					
					if(choice2 == 3) {
						// needs work
						// Create new resume
						
					}
					
					if(choice2 == 4) {
						// needs work
						// Edit account info
						
					}

				}while(choice2 != 1 && choice2 != 2 && choice2 != 3 && choice2 != 4);
			}// choice1 == 1

			
			if(choice1 == 2) {
				// needs work
				// this is for guest users
				// guest users can search for jobs but cannot apply for jobs without being signed into an account
			}// choice1 == 2



			if(choice1 == 3) {
				// needs work
				// probably this method, but may need to change this
				User.createAcct();
			}// choice1 == 3

		}while (choice1 != 1 && choice1 != 2 && choice1 != 3);



	}// runApplication()
	
}// class
