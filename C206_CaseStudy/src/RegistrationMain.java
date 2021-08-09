
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ravichandran_Sunthereswaran, 4 Aug 2021 10:12:46 am
 */
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
public class RegistrationMain {
	private static final int OPTION_QUIT = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Registration> registrationList=new ArrayList<Registration>();
		int option=0;
		while(option!=OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");
			if(option==1) {
				//Add New Registration 
				RegistrationMain.setHeader("ADD NEW Registration");
				Registration r1 = inputRegistration();
				RegistrationMain.addNewRegistration(registrationList,r1);
			}
			if(option==2) {
				//View ALL Registration
				RegistrationMain.setHeader("VIEW ALL REGISTRATION");
				RegistrationMain.viewAllRegistration(registrationList);
			}
			if(option==3) {
				//Delete Registration
				RegistrationMain.setHeader("DELETE REGISTRATION");
				RegistrationMain.deleteRegistration(registrationList);
			}
			if(option==4) {
				RegistrationMain.setHeader("SEARCH REGISTRATION");
				int regid=Helper.readInt("Enter Registration ID > ");
				RegistrationMain.viewSearchedRegistration(registrationList, regid);
			}
			else if(option!=1&&option!=2&&option!=3&&option!=4) {
				System.out.println("Invalid option entered!");
				Helper.line(80, "-");
			}
		}
	}
	
	//--------------------------------------------------------------------------------
	public static void menu() {
		System.out.println("1. Register for a tuition timetable");
		System.out.println("2. View all Registrations");
		System.out.println("3. Delete Registration");
		System.out.println("4. Search Registration");
		System.out.println("5. Quit");
	}
	public static String obscure(String inStr) {
		String rtnVal = "";
		int letters=inStr.length();
		String first=String.valueOf(inStr.charAt(0));
		if (inStr.length() <= 5) {
			rtnVal = inStr;
		}
		else {
			rtnVal = inStr.substring(0,3) +  String.format("%" + (inStr.length()-5) + "s", " ").replaceAll(" ", "X")  + inStr.substring(inStr.length()-(letters-5));
		}
		return rtnVal;
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//======= Option 1: Add New Registration ==========
	public static void addNewRegistration(ArrayList<Registration>registrationList,Registration r1) {
		registrationList.add(r1);
		System.out.println("New Registration added!");
	}
	public static Registration inputRegistration() {
		int regid=Helper.readInt("Enter Registration ID > ");
		int timeid=Helper.readInt("Enter Timetable ID > ");
		LocalDate date=LocalDate.now();
		String datestring=String.valueOf(date);
		String email=Helper.readString("Enter your email > ");
		Registration r1=new Registration(regid,timeid,email,datestring);
		return r1;
	}
	
	//======= Option 2: View Registration =============
	public static String retrieveRegistration(ArrayList<Registration> registrationList) {
		String output = "";
		
		for (int i = 0; i < registrationList.size(); i++) {
			output += String.format("%-25d %-20d %-40s %-15s %s\n",
					registrationList.get(i).getRegistrationid()
					,registrationList.get(i).getTuitiontimetableid(),
					obscure(registrationList.get(i).getStudentemail())
					,registrationList.get(i).getStatus(),
					registrationList.get(i).getRegistrationdate());
		}
		return output;
	}
	public static void viewAllRegistration(ArrayList<Registration> registrationList) {
		
		RegistrationMain.setHeader("Registration List");
		String output = String.format("%-25s %-20s %-40s %-15s %s\n","Registration ID"
				,"Timetable ID",
				"Email","Status","Date");
		 output += retrieveRegistration(registrationList);
		System.out.println(output);
	}
	
	//======= Option 3: Delete Registration ============
	public static boolean doDeletionRegistration(ArrayList<Registration> registrationList, int regid, String email) {
		boolean isDeleted = false;

		for (int i = 0; i < registrationList.size(); i++) {
			
			int id = registrationList.get(i).getRegistrationid();
			String emailconfirmation=registrationList.get(i).getStudentemail();
			
			if (regid==id && email.equalsIgnoreCase(emailconfirmation)) {
				registrationList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	
	
	public static void deleteRegistration(ArrayList<Registration> registrationList) {
		RegistrationMain.viewAllRegistration(registrationList);
		int regid = Helper.readInt("Enter Registration ID to delete > ");
		String email = Helper.readString("Enter email to confirm > ");
		
		Boolean isDeleted = doDeletionRegistration(registrationList, regid, email);
		if (isDeleted == false) {
			System.out.println("Invalid Registraion ID!");
		} else {
			System.out.println("Registration ID "+regid+" is deleted");
		}
	}
	
	//======= Option 4: Search Registration ============
	public static String retrieveSearchRegistration(ArrayList<Registration> registrationList, int id) {
		String output = "";
		boolean found=false;
			for (int i=0; i<registrationList.size(); i++) {
				if(registrationList.get(i).getRegistrationid()==id) {
					output += String.format("%-25d %-20d %-40s %-15s %s\n",
							registrationList.get(i).getRegistrationid()
							,registrationList.get(i).getTuitiontimetableid(),
							obscure(registrationList.get(i).getStudentemail())
							,registrationList.get(i).getStatus(),
							registrationList.get(i).getRegistrationdate());
					found=true;
				}
			}
			if(found==false) {
				output="Registration ID not found";
			}
		
		return output;
	}
	public static void viewSearchedRegistration(ArrayList<Registration> registrationList, int regid) {
		
		RegistrationMain.setHeader("Registration List");
		String output = String.format("%-25s %-20s %-40s %-15s %s\n","Registration ID"
				,"Timetable ID",
				"Email","Status","Date");
		output += retrieveSearchRegistration(registrationList, regid);
		System.out.println(output);
	}

}
