import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20036497, 7 Aug 2021 10:47:37 pm
 */

public class ManageStudentTuition {

	public static final int OPTION_QUIT = 4;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TuitionFeedback> TFeedback = new ArrayList <TuitionFeedback>();
		ArrayList<UpcomingTuition> UTuition = new ArrayList <UpcomingTuition>();
		
		UTuition.add(new UpcomingTuition("Alice", "C1", "Englisg Language", "25 Aug 2021"));
		UTuition.add(new UpcomingTuition("Benny", "C2", "History", "31 Aug 2021"));
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			
			ManageStudentTuition.menu();
			option = Helper.readInt("Enter an option> ");
			
			
			if (option == 1) {
				//Update student account
				TuitionFeedback tf = tuition();
				ManageStudentTuition.updateStudentFeedback(TFeedback, tf);
			}
			
			
			else if (option == 2 ) {
				//Update student upcoming tuition
				UpcomingTuition ut = Upcomingtuition();
				ManageStudentTuition.updateStudentUpcomingTuition(UTuition, ut);
			}
			
			else if (option == 3 ) {
				TuitionManagementSystem.setHeader("VIEW");
				System.out.println("1. View Student Feedback");
				System.out.println("2. View Upcoming Tuition");
				
				int choice = Helper.readInt("Enter option to select your choice > ");
				
				if (choice==1) {
					ManageStudentTuition.viewFeedback(TFeedback);
				}
				else if (choice == 2) {
					ManageStudentTuition.retrieveStudentUpcomingTuition(UTuition);
				}
				
				else {
					System.out.println("Invalid type");
				}
				
			}
			
			else if (option == 4 ) {
				System.out.println("Bye!");
			}
			
			else {
				System.out.println("Invalid option");
			}
		}
		
		

	}
	
	public static void menu() {
		TuitionManagementSystem.setHeader("Manage Student Tuition");
		System.out.println("1. Update Student Feedback");
		System.out.println("2. Update Upcoming Tuition");
		System.out.println("3. View");
		System.out.println("4. Quit for System");
		Helper.line(170, "-");
		
	}
	
	public static void setHeader(String header) {
		Helper.line(170, "-");
		System.out.println(header);
		Helper.line(170, "-");
	}
	
	public static TuitionFeedback tuition() {
		String name = Helper.readString("Enter name: ");
		String tuitioncode = Helper.readString("Enter Tuition Code: ");
		String tuitionTitle = Helper.readString("Enter Tuition Title: ");
		String feedback = Helper.readString("Enter feedback: ");
		
		TuitionFeedback tf = new TuitionFeedback(name, tuitioncode, tuitionTitle, feedback);
		return tf;
	
	}
	
	public static void updateStudentFeedback (ArrayList<TuitionFeedback> TFeedback, TuitionFeedback tf ) {
		
		
		TFeedback.add(tf);
		System.out.println("***Updated Successfully");

	}
	
	public static String retrieveFeedback (ArrayList<TuitionFeedback> TFeedback) {
		String output = "";
		
		for (int i = 0; i < TFeedback.size(); i ++) {
			output += String.format("%-110s\n", TFeedback.get(i).toString());
		}
		return output;
	}
	
	public static void viewFeedback (ArrayList<TuitionFeedback> TFeedback ) {
		String output = String.format("%-10s %-20s %-20s %-60s\n", "Name", "Tuition Code", "Tuition Title", "Feedback");
		output += retrieveFeedback(TFeedback);
		System.out.println(output);
	} 
	
	
	public static UpcomingTuition Upcomingtuition() {
		String name = Helper.readString("Enter name: ");
		String tuitioncode = Helper.readString("Enter Tuition Code: ");
		String tuitionTitle = Helper.readString("Enter Tuition Title: ");
		String date = Helper.readString("Enter date: ");
		
		UpcomingTuition ut = new UpcomingTuition(name, tuitioncode, tuitionTitle, date);
		return ut;
	
	}
	
	public static void updateStudentUpcomingTuition(ArrayList<UpcomingTuition> UTuition, UpcomingTuition ut ) {
		
		
		UTuition.add(ut);
		System.out.println("***Updated Successfully");

	}
	
	public static String viewUpcomingTuition (ArrayList<UpcomingTuition> UTuition) {
		String output = "";
		
		for (int i = 0; i < UTuition.size(); i ++) {
			output += String.format("%-70s\n", UTuition.get(i).toString());
		}
		return output;
	}
	
	public static void retrieveStudentUpcomingTuition (ArrayList<UpcomingTuition> UTuition ) {
		String output = String.format("%-10s %-20s %-20s %-20s\n", "Name", "Tuition Code", "Tuition Title", "Date");
		output += viewUpcomingTuition(UTuition);
		System.out.println(output);
	} 

}
