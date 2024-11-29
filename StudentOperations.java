package com.sms;

import java.sql.*;
import java.util.Scanner;

public class StudentOperations {
	private static Connection con;
	private static PreparedStatement ps,ps2;
	private static ResultSet rs;
	private static int id, age;
	private static String name, email, dob;
	private static float fees;
	private static String sql,insert, delete, update;//for query
	private static int ret;//for return 
	private static Scanner sc = new Scanner (System.in);
	
	public static void getAllStudents() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.getConnection();
		
		sql="Select * from student";
		ps = con.prepareStatement(sql);
		rs =ps.executeQuery();
		
		System.out.printf("%-8s%-20s%-8s%-30s%-10s%-10s","Id","Name","Age","Email","Fees","DOB");
		while(rs.next()) {
			System.out.println();
			id=rs.getInt(1);
			name= rs.getString(2);
			age = rs.getInt(3);
			email = rs.getString(4);
			fees =rs.getFloat(5);
			dob =rs.getString(6);
			System.out.printf("%-8s%-20s%-8s%-30s%-10s%-10s",id,name,age,email,fees,dob);
			
		}
		System.out.println("\n\n");
		
	}
	
	public static void getStudentById() throws ClassNotFoundException, SQLException {
		con =DatabaseConnection.getConnection();
		
		System.out.println("Enter Student Id:");
		id=sc.nextInt();
		
		sql="Select * from student where sid=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		rs=ps.executeQuery();
		
		if(rs.next()) {
			id =rs.getInt(1);
			name = rs.getString(2);
			age = rs.getInt(3);
			email= rs.getString(4);
			fees = rs.getFloat(5);
			dob = rs.getString(6);
			System.out.printf("%-8s%-20s%-8s%-30s%-10s%-10s","Id","Name","Age","Email","Fees","DOB");
			System.out.println();
			System.out.printf("%-8s%-20s%-8s%-30s%-10s%-10s",id,name,age,email,fees,dob);
			System.out.println("\n\n");
		}
		else {
			System.out.println("Id Does not exist!!!\n\n");
		}
		
	}
	
	
	public static void getUpdate() throws ClassNotFoundException, SQLException {
		con =DatabaseConnection.getConnection();
		
		System.out.println("Enter Student Id:");
		id =sc.nextInt();
		
		sql ="select * from student where sid=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		if(rs.next()) {
		
			while(true) {
				System.out.println("-----------Update Options-----------");
				System.out.println("1. Update Name");
				System.out.println("2. Update Age");
				System.out.println("3. Update Email");
				System.out.println("4. Update Fees");
				System.out.println("5. Update DOB");
				System.out.println("----------------------------------");
				
				System.out.println("Enter your choice:");
				int c = sc.nextInt();
				
				switch (c) {
					case 1:
						System.out.println("* Update Name *");
						System.out.println("Enter new Name:");
						name =sc.next();
						
						update ="Update student set sname=? where sid=?";
						ps2 = con.prepareStatement(update);
						ps2.setString(1, name);
						ps2.setInt(2, id);
						
						ret=ps2.executeUpdate();
						if(ret>0) {
							System.out.println("Name Updated Successfully!!!\n\n");
						}
						else {
							System.out.println("Error in Database!!!\n\n");
						}
						break;
					
					case 2:
						System.out.println("* Update Age *");
						System.out.println("Enter new Age:");
						age = sc.nextInt();
						
						update ="Update student set sage=? where sid=?";
						ps2 = con.prepareStatement(update);
						ps2.setInt(1, age);
						ps2.setInt(2, id);
						
						ret = ps2.executeUpdate();
						if(ret>0) {
							System.out.println("Age Updated Successfully!!!\n\n");
						}
						else {
							System.out.println("Error in Database!!!\n\n");
						}
						
						break;
					
					case 3:
						System.out.println("* Update Email *");
						System.out.println("Enter new Email:");
						email = sc.next();
						
						update ="Update student set semail=? where sid=?";
						ps2 = con.prepareStatement(update);
						ps2.setString(1, email);
						ps2.setInt(2, id);
						
						ret = ps2.executeUpdate();
						if(ret>0) {
							System.out.println("Email Updated Successfully!!!\n\n");
						}
						else {
							System.out.println("Error in Database!!!\n\n");
						}						
						break;
				
					case 4:
						System.out.println("* Update Fees *");
						System.out.println("Enter new Fees:");
						fees = sc.nextFloat();
						
						update = "Update student set sfees=? where sid=?";
						ps2 = con.prepareStatement(update);
						ps2.setFloat(1, fees);
						ps2.setInt(2, id);
						
						ret = ps2.executeUpdate();
						if(ret>0) {
							System.out.println("Fees Updated Successfully!!!\n\n");
						}
						else {
							System.out.println("Error in Database!!!\n\n");
						}
						
						break;
					
					case 5:
						System.out.println("* Update DOB *");
						System.out.println("Enter new DOB:");
						dob = sc.next();
						
						update = "Update student set sdob=? where sid=?";
						ps2 = con.prepareStatement(update);
						ps2.setString(1, dob);
						ps2.setInt(2, id);
						
						ret = ps2.executeUpdate();
						if(ret>0) {
							System.out.println("DOB Updated Successfully!!!\n\n");
						}
						else {
							System.out.println("Error in Database!!!\n\n");
						}
						
						break;
						
						default :
							System.out.println("Invalid input!! \n Please enter number between 1 to 5..\n");
							break;
				}
				
				System.out.println("Do you want to continue with update operations?\n if yes please type 'yes' else 'no'\n");
				String upchoice = sc.next().toLowerCase();
				if(upchoice.equals("yes")) {
					continue;
				}
				else {
					break;
				}
				
				
			}//end of while
			
			
		}
		else {
		System.out.println("Id does not exist!!!\n");
	}
		
}
	
	
	
	
	public static void getDelete() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.getConnection();
		
		System.out.println("Enter Student Id");
		id = sc.nextInt();
		
		sql = "select * from student where sid=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		 
		rs = ps.executeQuery();
		if(rs.next()) {
			delete ="Delete from student where sid=?";
			ps2 = con.prepareStatement(delete);
			ps2.setInt(1, id);
			ret = ps2.executeUpdate();
			if(ret>0) {
				System.out.println("Record Deleted Successfully!!!\n\n");
			}
			else {
				System.out.println("Error in Database!!!\n\n");
			}
		}
		else {
			System.out.println("Id Does not exist!!!\n\n");
		}
	}
	
	public static void getInsert() throws ClassNotFoundException, SQLException {
		con =DatabaseConnection.getConnection();
		
//		System.out.println("Enter Student Id:");
//		id=sc.nextInt();
//		sql = "Select * from student where sid=?";
//		ps=con.prepareStatement(sql);
//		ps.setInt(1, id);
//		rs=ps.executeQuery();
//		
//		if(rs.next()) {
//			System.out.println("Invalid Id, Id already exist\n\n");
//		}
//		else {
			insert ="Insert into student(sname, sage, semail,sfees, sdob) values(?,?,?,?,?)";
			ps2 = con.prepareStatement(insert);
			
			System.out.println("Enter Name");
			name = sc.next();
			System.out.println("Enter Age");
			age = sc.nextInt();
			System.out.println("Enter Email");
			email = sc.next();
			System.out.println("Enter Fees");
			fees = sc.nextFloat();
			System.out.println("Enter DOB");
			dob = sc.next();
			
			ps2.setString(1, name);
			ps2.setInt(2, age);
			ps2.setString(3, email);
			ps2.setFloat(4, fees);
			ps2.setString(5, dob);
			
			
			
			ret = ps2.executeUpdate();
			if(ret>0) {
				System.out.println("Record Inserted Successfully!!!\n\n");
			}
			else {
				System.out.println("Error in Database!!!\n\n");
			}
		//}
	}

}
