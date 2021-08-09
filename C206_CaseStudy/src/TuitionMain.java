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
		
		tuitionList.add(new Tuition("TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "online"));
		tuitionList.add(new Tuition("TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "f2f"));
		tuitionList.add(new Tuition("TT03", "Health", "GroupC", "Nutrition", "2 hour", "basic science", "f2f", "f2f"));
		tuitionList.add(new Tuition("TT04", "Technology", "GroupD", "techy", "5 hour", "java", "online", "online"));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			TuitionMain.mainTMMenu();
			option = Helper.readInt("Enter an option > ");
		
			if (option == 1) {
				//Tuition Administrator
				int tuitionOption = 0;

				while (tuitionOption != 6) {
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
						//Update Tuition mode and add remarks
						TuitionMain.setHeader("UPDATE TUITION MODE");
						String tuitionCode = Helper.readString("Enter tuition code: ");
						String mode = Helper.readString("Mode for tuition (F2F/Online): ");
						String remark = Helper.readString("Please indicated in the remarks\n(F2F/Online):");
						TuitionMain.updateTuition(tuitionList, tuitionCode, mode, remark);
					}
					else if (tuitionOption == 5) {
						//View tuition by modes
						TuitionMain.setHeader("VIEW TUITION BY MODE");
						TuitionMain.SearchByModeMenu();
						int tModeOption = 0;
						
						while (tModeOption != 3) {
							tModeOption = Helper.readInt("Enter an option > ");
							
							if(tModeOption == 1) {
								//Face-to-Face mode
								TuitionMain.viewSearchedTuition(tuitionList,1);
							}
							else if(tModeOption == 2) {
								//Online mode
								TuitionMain.viewSearchedTuition(tuitionList,2);
							}
							else if(tModeOption == 3) {
								System.out.println("Bye!");
							}
						}
					}
					else if (tuitionOption == 6) {
						System.out.println("Bye!");
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
		System.out.println("4. Update Tuition");
		System.out.println("5. Search Tuition by Modes");
		System.out.println("6. Back to Home Page");
	}
	
	public static void SearchByModeMenu() {
		TuitionMain.setHeader("Tuition modes:");
		System.out.println("1. By Face-to-Face(F2F)");
		System.out.println("2. Online");
		System.out.println("3. Quit");
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
		String mode = Helper.readString("Mode for tuition (F2F/Online): ");
		
		
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
	
	//======= Option 4: Update Tuition ============ Sprint 2
		public static boolean doUpdateTuition(ArrayList<Tuition> tuitionList, String tuitionCode, String mode, String remark) {
			boolean isUpdated = false;

			for (int i=0; i< tuitionList.size(); i++) {
				String tCode = tuitionList.get(i).getTuitionCode();
				String modeU = mode.toLowerCase();
				
				if (tuitionCode.equalsIgnoreCase(tCode)				
						&& modeU.equals("online")) {
					tuitionList.get(i).setMode("online");
					tuitionList.get(i).setRemark(remark);
					isUpdated = true;
				}
				else if(tuitionCode.equalsIgnoreCase(tCode)				
						&& modeU.equals("f2f")) {
					tuitionList.get(i).setMode("online");
					tuitionList.get(i).setRemark(remark);
					isUpdated = true;
				}
				
			}
			return isUpdated;
		}

		public static void updateTuition(ArrayList<Tuition> tuitionList, String tuitionCode, String mode, String remark) {
			TuitionMain.viewAllTuition(tuitionList);
			
			Boolean isUpdated = doUpdateTuition(tuitionList, tuitionCode, mode, remark);
			if (isUpdated == false) {
				System.out.println("Invalid tuition code");
			} else {
				System.out.println("Tuition (" + tuitionCode + ") is updated");
			}
		}
		
		//======= Option 5: Search Tuition By Modes ============ Sprint 2
		public static String retrieveSearchTuition(ArrayList<Tuition> tuitionList, int tModeOption) {
			String output = "";
			
			if(tModeOption == 1) {
				for (int i=0; i<tuitionList.size(); i++) {
					if(tuitionList.get(i).getMode().equalsIgnoreCase("f2f")) {
						output += String.format("%-145s", tuitionList.get(i).toString2());
					}
				}
			}
			else if (tModeOption == 2) {
				for (int i=0; i<tuitionList.size(); i++) {
					if(tuitionList.get(i).getMode().equalsIgnoreCase("online")) {
						output += String.format("%-145s", tuitionList.get(i).toString2());
					}
				}
			}
			
			return output;
		}
		public static void viewSearchedTuition(ArrayList<Tuition> tuitionList, int tModeOption) {
			
			TuitionMain.setHeader("TUITION LIST");
			String output = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s %-25s\n", 
					"TUITION CODE", "TITLE", "GROUP NAME", "DESCRIPTION",
					"DURATION", "PRE-REQUISITE", "MODE", "REMARKS");
			output += retrieveSearchTuition(tuitionList, tModeOption);
			System.out.println(output);
		}
	
//============================================= NICOLE - END =================================================


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
