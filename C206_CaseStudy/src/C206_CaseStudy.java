import java.time.LocalDate;
import java.util.ArrayList;

/**
 * We declare that this code was written by us.
 * We will not copy or allow others to copy our code.
 * We understand that copying code is considered as plagiarism.
 *
 * C206 Team 5, 2 Aug 2021 4:54:58 pm
 */

public class C206_CaseStudy {
	//final options:
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_TADMINISTRATOR = 1;
	private static final int OPTION_TMANAGER = 2;
	private static final int OPTION_STUDENT = 3;
	
	//nicole - tuitionList
	private static ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
	//nehla - enquiryList
	private static ArrayList<Enquiry> enquiryList = new ArrayList<Enquiry>();
	//ravi - registrationList
	private static ArrayList<Registration> registrationList=new ArrayList<Registration>();
	//zu er - studentList
	private static ArrayList <StudentAccount> StudentList = new ArrayList <StudentAccount>();
	
	public static void main(String[] args) {
		//nicole - test data 
		tuitionList.add(new Tuition("TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "HBL"));
		tuitionList.add(new Tuition("TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "School"));
		tuitionList.add(new Tuition("TT03", "Health", "GroupC", "Nutrition", "2 hour", "basic science", "f2f", "f2f"));
		tuitionList.add(new Tuition("TT04", "Technology", "GroupD", "techy", "5 hour", "java", "online", "online"));
		
		//nehla - test data
		enquiryList.add(new Enquiry(1,"How to register", "2021-7-20", "09.15", "Email","Pending", ""));
		enquiryList.add(new Enquiry(2,"Tuition Fee", "2021-7-5", "13.15","Email","Completed", ""));
	
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.mainTMMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_TADMINISTRATOR) {
				//Tuition Administrator
				int taOption = 0;
				
				while (taOption != 3) {
					C206_CaseStudy.menuTA();
					taOption = Helper.readInt("Enter the option: ");
					
					//nicole - Tuition (manage)
					if(taOption == 1) {
						int tuitionOption = 0;
						while (tuitionOption != OPTION_QUIT) {
							C206_CaseStudy.setHeader("TUITION ADMINISTRATOR");
							C206_CaseStudy.TuitionMenu();
							tuitionOption = Helper.readInt("Enter the option: ");
								
							if(tuitionOption == 1) {
								//Add New Tuition
								C206_CaseStudy.setHeader("ADD NEW TUITION");
								Tuition ntt = inputTuition();
								C206_CaseStudy.addNewTuition(tuitionList, ntt);
							}
							else if (tuitionOption == 2) {
								//View Tuition
								C206_CaseStudy.setHeader("VIEW TUITION");
								C206_CaseStudy.viewAllTuition(tuitionList);
							}
							else if (tuitionOption == 3) {
								//Delete Tuition
								C206_CaseStudy.setHeader("DELETE TUITION");
								C206_CaseStudy.deleteTuition(tuitionList);
							}
							else if (tuitionOption == 4) {
								//Update Tuition mode and add remarks
								C206_CaseStudy.setHeader("UPDATE TUITION MODE");
								String tuitionCode = Helper.readString("Enter tuition code: ");
								String mode = Helper.readString("Mode for tuition (F2F/Online): ");
								String remark = Helper.readString("Please indicated in the remarks\n(F2F/Online):");
								C206_CaseStudy.updateTuition(tuitionList, tuitionCode, mode, remark);
							}
							else if (tuitionOption == 5) {
								//View tuition by modes
								C206_CaseStudy.setHeader("VIEW TUITION BY MODE");
								C206_CaseStudy.SearchByModeMenu();
								int tModeOption = 0;
								
								while (tModeOption != 3) {
									tModeOption = Helper.readInt("Enter an option > ");
									
									if(tModeOption == 1) {
										//Face-to-Face mode
										C206_CaseStudy.viewSearchedTuition(tuitionList,1);
									}
									else if(tModeOption == 2) {
										//Online mode
										C206_CaseStudy.viewSearchedTuition(tuitionList,2);
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
					//zu er - Students (manage)
					else if (taOption == 2) {
						int optionTMS = 0;
						while (optionTMS != OPTION_QUIT) {
							
							C206_CaseStudy.menuTMS();
							optionTMS = Helper.readInt("Enter an option> ");
							
							if(optionTMS == 1) {
							//Register student account
							StudentAccount sa = registerAcc();
							C206_CaseStudy.registerStudentAccount(StudentList, sa);
								
							}
							
							else if (optionTMS == 2) {
							//View student account
							C206_CaseStudy.viewStudentAccount(StudentList);
								
							}
							
							else if (optionTMS == 3) {
							//Delete student account
							C206_CaseStudy.deleteStudentAcc(StudentList);
								
							}
							
							else if (optionTMS == 4) {
								System.out.println("Bye!");
							}
							
							else {
								System.out.println("Invalid option");
							}
							
						}	
					}
					else if (taOption == 3) {
						System.out.println("Bye!");
					}
					else {
						System.out.println("Invalid option");
					}
				}

						
			}
			
		//nehla	- enquiry
		else if (option == OPTION_TMANAGER) {
			//Tuition Manager
			int enquiryOption = 0;
			while (enquiryOption != OPTION_QUIT) {
				C206_CaseStudy.enquiryMenu();
				enquiryOption = Helper.readInt("Enter the option> ");
				Helper.line(80, "-");
					
				if(enquiryOption == 1) {
					//View Enquiry
					C206_CaseStudy.setHeader("VIEW ENQUIRY");
					C206_CaseStudy.viewAllEnquiry(enquiryList);
				}

				else if (enquiryOption == 2) {	
					//Add New Enquiry
					C206_CaseStudy.setHeader("ADD NEW ENQUIRY");
					Enquiry en = inputEnquiry();
					C206_CaseStudy.addNewEnquiry(enquiryList, en);
				}

				else if (enquiryOption == 3) {
					//Delete Enquiry
					C206_CaseStudy.setHeader("DELETE ENQUIRY");
					C206_CaseStudy.doDeletionEnquiry(enquiryList, enquiryOption);
				}
					
				else if (enquiryOption == OPTION_QUIT) {
					System.out.println("Bye!");
				}
				else {
					System.out.println("Invalid option entered");
				}	
			}	
		}
		
		//ravi - register timetable
		else if (option == OPTION_STUDENT) {
			//Student
			int regisOption=0;
			while(regisOption!=OPTION_QUIT) {
				menu();
				option = Helper.readInt("Enter an option > ");
				if(regisOption==1) {
					//Add New Registration 
					C206_CaseStudy.setHeader("ADD NEW Registration");
					Registration r1 = inputRegistration();
					C206_CaseStudy.addNewRegistration(registrationList,r1);
				}
				if(regisOption==2) {
					//View ALL Registration
					C206_CaseStudy.setHeader("VIEW ALL REGISTRATION");
					C206_CaseStudy.viewAllRegistration(registrationList);
				}
				if(regisOption==3) {
					//Delete Registration
					C206_CaseStudy.setHeader("DELETE REGISTRATION");
					C206_CaseStudy.deleteRegistration(registrationList);
				}
				if(regisOption!=1&&regisOption!=2&&regisOption!=3) {
					System.out.println("Invalid option entered!");
					Helper.line(80, "-");
				}
			}
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

//TEAM COLLABORATE - EVERYONE	
//===================================================================================================================
	//MAIN MAIN MENU (TUITION MANAGEMENT SYSTEM - LOGIN MENU)
	public static void mainTMMenu() {
		C206_CaseStudy.setHeader("TUITION MANAGEMENT APP");
		System.out.println("Login via:");
		System.out.println("1. Tuition Administrator");
		System.out.println("2. Tuition Manager");
		System.out.println("3. Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	//Set Header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//TuitionAdministrator - Nicole & ZuEr collab
	public static void menuTA() {
		C206_CaseStudy.setHeader("TUITION ADMINISTRATOR");
		System.out.println("1. Manage Tuitions");
		System.out.println("2. Manage Students");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}
//====================================================================================================================

//GOH SIM YNG, NICOLE (20014867)
//================================= NICOLE - START =========================================================
	//======= Tuition Menu =========
	public static void TuitionMenu() {
		C206_CaseStudy.setHeader("Tuition Menu");
		System.out.println("1. Add New Tuition");
		System.out.println("2. View Tuition");
		System.out.println("3. Delete Tuition");
		System.out.println("4. Back to Home Page");
	}
	
	//======= Search Tuition Mode Menu ========= Sprint 2
	public static void SearchByModeMenu() {
		C206_CaseStudy.setHeader("Tuition modes:");
		System.out.println("1. By Face-to-Face(F2F)");
		System.out.println("2. Online");
		System.out.println("3. Quit");
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
			
			C206_CaseStudy.setHeader("TUITION LIST");
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
			C206_CaseStudy.viewAllTuition(tuitionList);
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
			C206_CaseStudy.viewAllTuition(tuitionList);
					
			Boolean isUpdated = doUpdateTuition(tuitionList, tuitionCode, mode, remark);
			if (isUpdated == false) {
				System.out.println("Invalid tuition code");
			} 
			else {
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
					
			C206_CaseStudy.setHeader("TUITION LIST");
			String output = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s %-25s\n", 
					"TUITION CODE", "TITLE", "GROUP NAME", "DESCRIPTION",
					"DURATION", "PRE-REQUISITE", "MODE", "REMARKS");
			output += retrieveSearchTuition(tuitionList, tModeOption);
			System.out.println(output);
		}
		
//============================================= NICOLE - END =================================================	

//NEHLA FATHIMA (19028074)
//============================================= NEHLA - START ================================================
	public static void enquiryMenu() {
		C206_CaseStudy.setHeader("Enquiry Menu");
		System.out.println("1.View Enquiry");
		System.out.println("2.Add Enquiry ");
		System.out.println("3.Delete Enquiry ");
		System.out.println("4. Back to Home Page ");
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
		C206_CaseStudy.setHeader("ENQUIRY LIST");
		String output = String.format("%-15s %-20s %-20s %-15s %-20s %-10s %-15s\n", "ENQUIRYID","TITLE","DATE", "TIME",
				"ENQUIRY_METHOD","STATUS", "MODE");	
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
			
		Enquiry en = new Enquiry(id, title, date, time, enquiryMethod, status, mode);
		return en;
		}
		public static void addNewEnquiry(ArrayList<Enquiry>enquiryList, Enquiry en) {
			enquiryList.add(en);
			System.out.println("New Enquiry added!");
		}
	//Option3: Delete
	public static boolean doDeletionEnquiry(ArrayList<Enquiry> enquiryList,int enquiryId) {
		boolean isDeleted = false;
		for (int i = 0; i < enquiryList.size(); i++) {
			int E_id = enquiryList.get(i).getEnquiryId();
			if (enquiryId == E_id)	{			
				enquiryList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteEnquiry(ArrayList<Enquiry> enquiryList) {
		C206_CaseStudy.viewAllEnquiry(enquiryList);
		int delEn = Helper.readInt("Enter Enquiry ID: ");
			
		Boolean isDeleted = doDeletionEnquiry(enquiryList,delEn);
		if (isDeleted == false) {
		System.out.println("ID does not exist");
		} else {
			System.out.println("Enquiry " + delEn + " is deleted");
		}
	}	
//============================================= NEHLA - END ================================================	

//RAVICHANDRAN SUNTHERESWARAN (20026389)
//============================================= RAVI - START ================================================
	public static void menu() {
		System.out.println("1. Register for a tuition timetable");
		System.out.println("2. View all Registrations");
		System.out.println("3. Delete Registration");
		System.out.println("4. Quit");
	}
	public static String obscure(String inStr) {
		String rtnVal = "";
		int letters=inStr.length();
		String first = String.valueOf(inStr.charAt(0));
		if (inStr.length() <= 5) {
			rtnVal = inStr;
		}
		else {
			rtnVal = inStr.substring(0,3) +  String.format("%" + (inStr.length()-5) + "s", " ").replaceAll(" ", "X")  + inStr.substring(inStr.length()-(letters-5));
		}
		return rtnVal;
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
			output += String.format("%-25d %-20d %-40s %-15s %s\n", registrationList.get(i).getRegistrationid(),registrationList.get(i).getTuitiontimetableid(),
					obscure(registrationList.get(i).getStudentemail()),registrationList.get(i).getStatus(),registrationList.get(i).getRegistrationdate());
		}
		return output;
	}
	public static void viewAllRegistration(ArrayList<Registration> registrationList) {
		
		C206_CaseStudy.setHeader("Registration List");
		String output = String.format("%-25s %-20s %-40s %-15s %s\n","Registration ID","Timetable ID",
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
		C206_CaseStudy.viewAllRegistration(registrationList);
		int regid = Helper.readInt("Enter Registration ID to delete > ");
		String email = Helper.readString("Enter email to confirm > ");
		
		Boolean isDeleted = doDeletionRegistration(registrationList, regid, email);
		if (isDeleted == false) {
			System.out.println("Invalid Registraion ID!");
		} else {
			System.out.println("Registration ID "+regid+" is deleted");
		}
	}
//============================================= RAVI - END ================================================	

//TAN ZU ER (20036497)
//============================================= ZU ER - START =============================================		
	public static void menuTMS() {
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Register Student Account");
		System.out.println("2. View Student Account");
		System.out.println("3. Delete Student Account");
		System.out.println("4. Quit for System");
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

		StudentAccount sa = new StudentAccount(name, gender, mobile, email, dob, cor);
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
		C206_CaseStudy.viewStudentAccount(StudentList);
		String Name = Helper.readString("Enter name: ");
		Boolean isDeleted = doDeleteStudentAcc(StudentList, Name);
		if (isDeleted == false) {
			System.out.println("***Failed to delete");
		}else {
			System.out.println("***" + Name + " is deleted!");
		}
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
//============================================= ZU ER - END =============================================		
	
}

	

	

