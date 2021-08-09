import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19028074, 5 Aug 2021 12:52:18 am
 */

public class Enquirymain {
// done by nehla
	/**
	 * @param args
	 */
	
		// TODO Auto-generated method stub
		private static final int OPTION_QUIT = 4;
		public static void main(String[] args) {

			ArrayList<Enquiry> enquiryList = new ArrayList<Enquiry>();
			enquiryList.add(new Enquiry(1,"How to register", "2021-7-20", "09.15", "Email","Pending", "online" , "Urgent"));
			
			enquiryList.add(new Enquiry(2,"Tuition Fee", "2021-7-5", "13.15",
					 "Email","Completed", "f2f" , "Non-Urgent"));
			
			
			
			int option = 0;

			while (option != OPTION_QUIT) {

				
					// Tuition Manager
	int enquiryOption = 0;
	Enquirymain.setHeader("TUITION MANAGER");
					while (enquiryOption != OPTION_QUIT) {
						
						Enquirymain.EnquiryMenu();
						enquiryOption = Helper.readInt("Enter the option> ");
						Helper.line(80, "-");
						
						if(enquiryOption == 1) {
							//View Enquiry
							Enquirymain.setHeader("VIEW ENQUIRY");
							Enquirymain.viewAllEnquiry(enquiryList);
						}

						else if (enquiryOption == 2) {
							
	                   //Add New Enquiry
							Enquirymain.setHeader("ADD NEW ENQUIRY");
							Enquiry en = inputEnquiry();
							Enquirymain.addNewEnquiry(enquiryList, en);
						}

						else if (enquiryOption == 3) {
							//Delete Enquiry
							Enquirymain.setHeader("DELETE ENQUIRY");
							Enquirymain.deleteEnquiry(enquiryList);
						
						}
						else if( enquiryOption == 4) {//SPRINT 2
							//View Enquiry Type
						 	Enquirymain.setHeader("VIEW ENQUIRY TYPE");
							 int opt =0;
							 while (opt != 3) {
								 viewTypeMenu();
								 opt = Helper.readInt("Enter Option >");
								 if(opt == 1) {
									 //Urgent Enquiry Type
									 viewUrgentEnquiry(enquiryList);
								 }else if(opt == 2) {
									 //Non-Urgent Enquiry Type
									 viewNonUrgentEnquiry(enquiryList);
								 }
							 }
						} else if( enquiryOption == 5) {
							
						UpdateEnquiryStatus1(enquiryList);
						
						}
						else {
							System.out.println("Invalid option entered");
						}
					}
				}
			}
					
				
	//====START=====//			
	public static void EnquiryMenu() {
			Enquirymain.setHeader("Enquiry Menu");
			System.out.println("1.View Enquiry");
			System.out.println("2.Add Enquiry ");
			System.out.println("3.Delete Enquiry ");
			System.out.println("4. View Enquiry Type ");
			System.out.println("5.Update Enquiry Status");
			System.out.println("6. Back to Home Page ");
			
	}
			
		
		public static void setHeader(String header) {
			//Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
		}

	// Option1: viewEnquiry
	public static String retrieveEnquiry(ArrayList<Enquiry> enquiryList) {
			String output = "";
			
			for (int i = 0; i < enquiryList.size(); i++) {
				output += String.format("%-120s\n", enquiryList.get(i).toString());
			}
			return output;
		}
		public static String viewAllEnquiry(ArrayList<Enquiry> enquiryList) {
			
			Enquirymain.setHeader("ENQUIRY LIST");
			String output = String.format("%-15s %-20s %-20s %-15s %-20s %-10s %15s %-10s\n", "ENQUIRYID","TITLE","DATE", "TIME",
					"ENQUIRY_METHOD","STATUS", "MODE","TYPE");	
		 output += retrieveEnquiry(enquiryList);
			System.out.println(output);
			return output;
			
		}
	//Option2: Add new Enquiry
	public static Enquiry inputEnquiry() {
			int id = Helper.readInt("Enter Enquiry id > ");
				String title = Helper.readString("Enter Enquiry Title > ");
				String date = Helper.readString("Enter data in (YYYY-MM-DD) > ");
				String time = Helper.readString("Enter time in (TT.MM) > ");
				String enquiryMethod = Helper.readString("Enter enquiry method > ");
				String status = Helper.readString("Enter enquiry status > ");
	                  String mode = Helper.readString("Mode for enquiry: ");
	                  String Type = Helper.readString("Enter Enquiry Type(Urgent/ Non-Urgent");
			
			Enquiry en = new Enquiry(id, title, date, time, enquiryMethod, status, mode , Type);
			return en;
		}
		public static void addNewEnquiry(ArrayList<Enquiry>enquiryList, Enquiry en) {
			enquiryList.add(en);
			System.out.println("New Enquiry added!");
		}
		//Option 3: delete
	public static boolean doDeletionEnquiry(ArrayList<Enquiry> enquiryList,int enquiryId) {
			
		boolean isDeleted = false;
			for (int i = 0; i < enquiryList.size(); i++) {
				
				int E_id = enquiryList.get(i).getEnquiryId();
				
				if (enquiryId == E_id)	{			
						
					//enquiryList.remove(enquiryList.get(i));
					enquiryList.remove(i);
					isDeleted = true;
				}
				
			}
			return isDeleted;
		}

		public static void deleteEnquiry(ArrayList<Enquiry> enquiryList) {
			Enquirymain.viewAllEnquiry(enquiryList);
			int delEn = Helper.readInt("Enter Enquiry ID: ");
			
			
			Boolean isDeleted = doDeletionEnquiry(enquiryList,delEn);
			if (isDeleted == false) {
				System.out.println("ID does not exist");
			} else {
				System.out.println("Enquiry " + delEn + " is deleted");
			}
		}

	//Option 4: View Enquiry Type (Urgent/ Non-Urgent)

		public static void viewTypeMenu() {
			Enquirymain.setHeader("Enquiry Search Type");
			System.out.println("1.View Urgent Enquiries");
			System.out.println("2.View Non-Urgent Enquiries");
			System.out.println("3.Quit");
			
		}

		public static String viewUrgentEnquiry(ArrayList<Enquiry>enquiryList ) {
			 //int count = 1;
			 String output = String.format("%-15s %-20s %-20s %-15s %-20s %-10s %-15s\n", "TITLE","DATE", "TIME",
						"ENQUIRY_METHOD","STATUS", "MODE","TYPE");
			for( Enquiry e : enquiryList) {
				if (e.getType() == "Urgent") {
					output += String.format(" %-15s %-20s %-20s %-15s %-20s %-10s %-15s\n", e.getTitle() , e.getDate() , e.getTime(), e.getEnquiryMethod() ,e.getStatus(),e.getMode(), e.getType());
					System.out.println(output);	
					
					}
			 }
			return output;	
			 
		}
		public static String viewNonUrgentEnquiry(ArrayList<Enquiry>enquiryList ) {
			 
			 String output = String.format("%-15s %-20s %-20s %-15s %-20s %-10s %-15s\n", "TITLE","DATE", "TIME",
						"ENQUIRY_METHOD","STATUS", "MODE","TYPE");
			for( Enquiry e : enquiryList) {
				if (e.getType() == "Non-Urgent") {
					output += String.format(" %-15s %-20s %-20s %-15s %-20s %-10s %-15s\n", e.getTitle() , e.getDate() , e.getTime(), e.getEnquiryMethod() ,e.getStatus(),e.getMode(), e.getType());
					System.out.println(output);	
					
					}
			 }
			return output;	
			 
		}
		
		//Option 5 : Update Enquiry Status - SPRINT 2
		public static boolean UpdateEnquiryStatus(ArrayList<Enquiry>enquiryList, int uID, String uStatus) {
			boolean isFound = false;
			
			for(int i = 0;i < enquiryList.size();i++) {
				int EnID = enquiryList.get(i).getEnquiryId();
				if(EnID == uID) {
					enquiryList.get(i).setStatus(uStatus);
					int ID = enquiryList.get(i).getEnquiryId();
					System.out.println("Enquiry ID " + ID + " has been changed to " + uStatus);
					isFound = true;
				}
				
			}
			return isFound;
		}
		public static void UpdateEnquiryStatus1(ArrayList<Enquiry> enquiryList  ) {
			Enquirymain.viewAllEnquiry(enquiryList);
			int uId = Helper.readInt("Enter Enquiry ID: ");
			String uStatus = Helper.readString("Enter Enquiry Status:");
			boolean isFound = UpdateEnquiryStatus(enquiryList,  uId,  uStatus);
			if(isFound == false) {
				System.out.println("Enquiry Not Found!");
			}
			else {
				System.out.println("Enquiry updated!");
			}
			
			
		}
		
}