

import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20036497, 31 Jul 2021 7:55:33 pm
 */

public class TuitionManagementSystem {
	
	public static final int OPTION_QUIT = 5;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <StudentAccount> StudentList = new ArrayList <StudentAccount>();

		int option = 0;
		while (option != OPTION_QUIT) {
			
			TuitionManagementSystem.menu();
			option = Helper.readInt("Enter an option> ");
			
			if(option == 1) {
			//Register student account
			StudentAccount sa = registerAcc();
			TuitionManagementSystem.registerStudentAccount(StudentList, sa);
				
			}
			
			else if (option == 2) {
			//View student account
			TuitionManagementSystem.viewStudentAccount(StudentList);
				
			}
			
			else if (option == 3) {
			//Delete student account
			TuitionManagementSystem.deleteStudentAcc(StudentList);
				
			}
			
			else if (option == 4) {
				//Update student account
				TuitionManagementSystem.updateStudentAcc(StudentList);
			}
			
			else if (option == 5 ) {
				System.out.println("Bye!");
			}
			
			else {
				System.out.println("Invalid option");
			}
			
		}

	}
	
	public static void menu() {
		TuitionManagementSystem.setHeader("Tuition Management System");
		System.out.println("1. Register Student Account");
		System.out.println("2. View Student Account");
		System.out.println("3. Delete Student Account");
		System.out.println("4. Update Student Account");
		System.out.println("5. Quit for System");
		Helper.line(100, "-");
		
	}
	
	public static void setHeader(String header) {
		Helper.line(100, "-");
		System.out.println(header);
		Helper.line(100, "-");
	}
	
	public static StudentAccount registerAcc() {
		String name = Helper.readString("Enter your name> ");
		String gender = Helper.readString("Enter your gender (M/F)> ");
		int mobile = Helper.readInt("Enter your mobile number> ");
		String email = Helper.readString("Enter your email> ");
		while (isValid(email) == false)
		{
			System.out.println("Invalid email entered.");
			email = Helper.readString("Enter email > ");
		}
		String dob = Helper.readString("Enter your dob (Format(ddMMMyy))> ");
		String cor = Helper.readString("Enter your country of Residence> ");
		String feedback = "";

		StudentAccount sa = new StudentAccount(name, gender, mobile, email, dob, cor, feedback);
		return sa;
	}
	
	public static void registerStudentAccount (ArrayList<StudentAccount> StudentList, StudentAccount sa ) {
		
		
		StudentList.add(sa);
		System.out.println("***Register Sucessfully");

	}

	public static String retrieveAllStudentAccount(ArrayList<StudentAccount> StudentList) {
		String output = "";
		
		for (int i = 0; i < StudentList.size(); i ++) {
			output += String.format("%-80s\n", StudentList.get(i).toString());
		}
		return output;
	}
	
	public static void viewStudentAccount (ArrayList<StudentAccount> StudentList ) {
		String output = String.format("%-10s %-10s %-10s %-20s %-20s %-20s\n", "Name", "Gender", "Mobile No", "Email", "Date of Birth", "Country of Residence");
		output += retrieveAllStudentAccount(StudentList);
		System.out.println(output);
	}
	

	
	public static boolean doDeleteStudentAcc(ArrayList<StudentAccount> StudentList, String name) {
		boolean isDelete = false;
		
		for(int i = 0; i < StudentList.size(); i++) {
			String Name = StudentList.get(i).getName();
			
			if(name.equalsIgnoreCase(Name) == true) {
				StudentList.remove(i);
				isDelete = true;
			}
		}
		return isDelete;
	}
	
	public static void deleteStudentAcc(ArrayList<StudentAccount> StudentList) {
		TuitionManagementSystem.viewStudentAccount(StudentList);
		String Name = Helper.readString("Enter name: ");
		Boolean isDeleted = doDeleteStudentAcc(StudentList, Name);
		if (isDeleted == false) {
			System.out.println("***Failed to delete");
		}else {
			System.out.println("***" + Name + " is deleted!");
		}
	}
	
	public static StudentAccount doUpdateStudentAccount() {
		String feedback = Helper.readString("Give your feedback: ");
		
		
		StudentAccount

		
	}
	
	public static void updateStudentAccount (ArrayList<StudentAccount> StudentList) {
		
	}
	 
	
	private static boolean isValid(String email)
	{
		if (email.contains("@") && email.contains("."))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

