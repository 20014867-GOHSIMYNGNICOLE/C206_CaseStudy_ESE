import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Goh Sim Yng, Nicole 20014867, 4 Aug 2021 12:30:12 am
 */

public class TuitionMain {
	private static final int OPTION_QUIT = 4;
	
	public static void main(String[] args) {
		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		tuitionList.add(new Tuition("TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "HBL"));
		tuitionList.add(new Tuition("TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "School"));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			TuitionMain.mainTMMenu();
			option = Helper.readInt("Enter an option > ");
		
			if (option == 1) {
				//Tuition Administrator
				int tuitionOption = 0;

				while (tuitionOption != OPTION_QUIT) {
					TuitionMain.setHeader("TUITION ADMINISTRATOR");
					TuitionMain.TuitionMenu();
					tuitionOption = Helper.readInt("Enter the option: ");
					
					if(tuitionOption == 1) {
						//Add New Tuition
						TuitionMain.setHeader("ADD NEW TUITION");
						Tuition ntt = inputTuition();
						TuitionMain.addNewTuition(tuitionList, ntt);
					}
					else if (tuitionOption == 2) {
						//View Tuition
						TuitionMain.setHeader("VIEW TUITION");
						TuitionMain.viewAllTuition(tuitionList);
					}
					else if (tuitionOption == 3) {
						//Delete Tuition
						TuitionMain.setHeader("DELETE TUITION");
						TuitionMain.deleteTuition(tuitionList);
					}
					else if (tuitionOption == 4) {
						TuitionMain.mainTMMenu();
						option = Helper.readInt("Enter an option > ");
					}
					else {
						System.out.println("Invalid option entered");
					}
				}
				
			}
			else if (option == 2) {
				//Tuition Manager
			}
			else if (option == 3) {
				//Student
			}
			else if(option == OPTION_QUIT) {
				//Say goodbye
				System.out.println("Bye!");
			}
			else {
				System.out.println("Invalid option");
			}
		}
	}
	
//=================================      NICOLE - START ================================
	public static void TuitionMenu() {
		TuitionMain.setHeader("Tuition Menu");
		System.out.println("1. Add New Tuition");
		System.out.println("2. View Tuition");
		System.out.println("3. Delete Tuition");
		System.out.println("4. Back to Home Page");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//======= Option 1: Add New Tuition ==========
	public static Tuition inputTuition() {
		String tCode = Helper.readString("Enter unique tuition code: ");
		String title = Helper.readString("Enter tuition title: ");
		String gName =  Helper.readString("Enter the group name: ");
		String description = Helper.readString("Enter the description of the tuition: ");
		String duration = Helper.readString("Enter the tuition duration: ");
		String pRequisite = Helper.readString("Any Pre-Requisite?: ");
		String mode = Helper.readString("Mode for tuition: ");
		
		Tuition ntt = new Tuition(tCode, title, gName, description, duration, pRequisite, mode);
		return ntt;
	}
	public static void addNewTuition(ArrayList<Tuition>tuitionList, Tuition ntt) {
		tuitionList.add(ntt);
		System.out.println("New tuition added!");
	}
	
	//======= Option 2: View Tuition =============
	public static String retrieveTuition(ArrayList<Tuition> tuitionList) {
		String output = "";
		
		for (int i = 0; i < tuitionList.size(); i++) {
			output += String.format("%-120s", tuitionList.get(i).toString());
		}
		return output;
	}
	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		
		TuitionMain.setHeader("TUITION LIST");
		String output = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n", 
				"TUITION CODE", "TITLE", "GROUP NAME", "DESCRIPTION",
				"DURATION", "PRE-REQUISITE", "MODE");
		 output += retrieveTuition(tuitionList);
		System.out.println(output);
	}
	
	//======= Option 3: Delete Tuition ============
	public static boolean doDeletionTuition(ArrayList<Tuition> tuitionList, String tuitionCode, char confirmDeletion) {
		boolean isDeleted = false;

		for (int i = 0; i < tuitionList.size(); i++) {
			
			String tCode = tuitionList.get(i).getTuitionCode();
			
			if (tuitionCode.equalsIgnoreCase(tCode)				
					&& (confirmDeletion == 'y' || confirmDeletion == 'Y')) {
				tuitionList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteTuition(ArrayList<Tuition> tuitionList) {
		TuitionMain.viewAllTuition(tuitionList);
		String tuitionCode = Helper.readString("Enter tuition code: ");
		char confirmDeletion = Helper.readChar("Confirm deletion?[Y/N]: ");
		
		Boolean isDeleted = doDeletionTuition(tuitionList, tuitionCode, confirmDeletion);
		if (isDeleted == false) {
			System.out.println("Invalid tuition code");
		} else {
			System.out.println("Tuition (" + tuitionCode + ") is deleted");
		}
	}
//============================================= NICOLE - END ======================================
	
	public static void mainTMMenu() {
		TuitionMain.setHeader("TUITION MANAGEMENT APP");
		System.out.println("Login via:");
		System.out.println("1. Tuition Administrator");
		System.out.println("2. Tuition Manager");
		System.out.println("3. Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

}
