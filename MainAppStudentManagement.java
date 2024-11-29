package com.sms;

import java.sql.SQLException;
import java.util.Scanner;

public class MainAppStudentManagement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int ch;
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("************Student Management System*************");
			System.out.println("1. Get All Record");
			System.out.println("2. Get Student by Id");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student by Id");
			System.out.println("5. Add Student");
			System.out.println("-----Enter your choice:-----");
			ch=sc.nextInt();
			switch (ch){
				case 1:
					StudentOperations.getAllStudents();
					break;
				case 2:
					StudentOperations.getStudentById();
					break;
				case 3:
					StudentOperations.getUpdate();
					break;
				case 4:
					StudentOperations.getDelete();
					break;
				case 5:
					StudentOperations.getInsert();
					break;
				default:
					System.out.println("Invalid Input!!! Please Select numbe from 1 to 5\n");
			}
			System.out.println("Do you want to continue?\nPress y or Y to continue and any other key to stop");
			char choice = sc.next().toLowerCase().charAt(0);
			if(choice !='y') {
				break;
			}
		}
		System.out.println("************Project is Terminated************");
	}

}
