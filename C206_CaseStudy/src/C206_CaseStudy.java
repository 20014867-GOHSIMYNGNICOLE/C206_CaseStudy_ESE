import java.util.ArrayList;

/**
 * We declare that this code was written by us.
 * We will not copy or allow others to copy our code.
 * We understand that copying code is considered as plagiarism.
 *
 * C206 Team 5, 2 Aug 2021 4:54:58 pm
 */

public class C206_CaseStudy {
	
	public void RegistrationMenu() {
		//ravi
		System.out.println("1.Register for a tuition");
		System.out.println("2.View all registrations");
		System.out.println("3.Delete registration");
	}

	private static final int OPTION_QUIT = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
//		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
			
		int option = 0;

		while (option != OPTION_QUIT) {

			TuitionMain.mainTMMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				//Tuition Administrator
//				int tuitionOption = 0;
//
//				while (tuitionOption != OPTION_QUIT) {
//					TuitionMain.setHeader("TUITION ADMINISTRATOR");
//					TuitionMain.TuitionMenu();
//					tuitionOption = Helper.readInt("Enter the option: ");
//						
//					if(tuitionOption == 1) {
//						//Add New Tuition
//						TuitionMain.setHeader("ADD NEW TUITION");
//						Tuition ntt = inputTuition();
//						TuitionMain.addNewTuition(tuitionList, ntt);
//					}
//					else if (tuitionOption == 2) {
//						//View Tuition
//						TuitionMain.setHeader("VIEW TUITION");
//						TuitionMain.viewAllTuition(tuitionList);
//					}
//					else if (tuitionOption == 3) {
//						//Delete Tuition
//						TuitionMain.setHeader("DELETE TUITION");
//						TuitionMain.deleteTuition(tuitionList);
//					}
//					else if (tuitionOption == 4) {
//						TuitionMain.mainTMMenu();
//						option = Helper.readInt("Enter an option > ");
//					}
//					else {
//						System.out.println("Invalid option entered");
//					}
//				}
					
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
	//MAIN MAIN MENU (TUITION MANAGEMENT SYSTEM - LOGIN MENU)
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
	

	

