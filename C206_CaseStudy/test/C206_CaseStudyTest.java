import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * We declare that this code was written by us.
 * We will not copy or allow others to copy our code.
 * We understand that copying code is considered as plagiarism.
 *
 * C206 Team 5, 2 Aug 2021 4:54:58 pm
 */

public class C206_CaseStudyTest {
	//nicole
	private Tuition ntt1;
	private Tuition ntt2;
	private Tuition ntt3;
	private Tuition ntt4;
	private ArrayList<Tuition> tuitionList;
	
	//nehla
	private Enquiry en1; 
	private Enquiry en2; 
	private ArrayList<Enquiry> enquiryList;
	
	//ravi
	private Registration r1;
	private Registration r2;
	private ArrayList<Registration> registrationList;
	
	//zu er
	private StudentAccount sa1;
	private StudentAccount sa2;
	private ArrayList<StudentAccount> StudentList;
	
	private TuitionFeedback tf1;
	private TuitionFeedback tf2;
	private ArrayList<TuitionFeedback> TFeedback;
	
	private UpcomingTuition ut1;
	private UpcomingTuition ut2;
	private ArrayList<UpcomingTuition> UTuition;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// nicole - prepare test data (Tuition - Administrator)
		ntt1 = new Tuition("TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "HBL");
		ntt2 = new Tuition("TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "School");
		ntt3 = new Tuition("TT03", "Health", "GroupC", "Nutrition", "2 hour", "basic science", "f2f", "f2f");
		ntt4 = new Tuition("TT04", "Technology", "GroupD", "techy", "5 hour", "java", "online", "online");
		tuitionList= new ArrayList<Tuition>();
		
		//nehla - prepare test data
		en1 = (new Enquiry(1,"How to register", "2021-7-20", "09.15", "Email","Pending",""));
		en2 = (new Enquiry(2,"Tuition Fee", "2021-7-5", "13.15", "Email","Completed",""));
		enquiryList = new ArrayList<Enquiry>();
	 
		//ravi - prepare test data
		LocalDate date=LocalDate.now();
		String stringdate=String.valueOf(date);
		r1 = new Registration(1,1,"ravi@gmail.com",stringdate);
		r2 = new Registration(2,2,"ravichandran@gmail.com",stringdate);
		registrationList= new ArrayList<Registration>();
		
		//zu er - prepare test data
		sa1 = new StudentAccount("Alice", "F", 85478569, "alice123@gmail.com", "29JUL04", "SG");
		sa2 = new StudentAccount("Benny", "M", 96585478, "benny098@gmail.com", "26APR06", "SG");
		StudentList = new ArrayList<StudentAccount>();
		
		tf1 = new TuitionFeedback("Alice", "C1", "English Language", "Quite Fun!");
		tf2 = new TuitionFeedback("Benny", "C2", "History", "Slide can be more in detailed");
		TFeedback = new ArrayList<TuitionFeedback>();
		
		ut1 = new UpcomingTuition("Alice", "C1", "English Language", "25 Aug 2021");
		ut2 = new UpcomingTuition("Benny", "C2", "History", "31 Aug 2021");
		UTuition = new ArrayList<UpcomingTuition>();
	
	}

	
//GOH SIM YNG, NICOLE (20014867)
//============== NICOLE TEST START =====================
	@Test
	public void addNewTuition() {
		// Tuition list is not null, so that can add a new tuition - boundary
		assertNotNull("Check if there is valid Tuition arraylist to add to", tuitionList);
		
		//Given an empty Tuition list, after adding 1 new tuition, the size of the list is 1 - normal
		//The tuition just added is as same as the first tuition of the list
		C206_CaseStudy.addNewTuition(tuitionList, ntt1);
		assertEquals("Check that Tuition arraylist size is 1", 1, tuitionList.size());
		assertSame("Check that Tuition is added", ntt1, tuitionList.get(0));
		
		//Add another new tuition, test the size of the list is 2? -normal
		//The new tuition just added is as same as the second tuition of the list
		C206_CaseStudy.addNewTuition(tuitionList, ntt2);
		assertEquals("Check that Tuition arraylist size is 2", 2, tuitionList.size());
		assertSame("Check that Tuition is added", ntt2, tuitionList.get(1));
	}
	
	
	@Test
	public void retrieveTuition() {
		// Test if Tuition list is not null but empty -boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve tuition", tuitionList);
		
		//test if the list of tuitions retrieved from the SourceCentre is empty - boundary
		String allTuition = C206_CaseStudy.retrieveTuition(tuitionList);
		String testOutput = "";
		assertEquals("Check that ViewAllTuition", testOutput, allTuition);
		
		//Given an empty Tuition list, after adding 2 tuitions, test if the size of the list is 2 - normal
		C206_CaseStudy.addNewTuition(tuitionList, ntt1);
		C206_CaseStudy.addNewTuition(tuitionList, ntt2);
		assertEquals("Test that Tuition arraylist size is 2", 2, tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the SourceCentre	
		allTuition = C206_CaseStudy.retrieveTuition(tuitionList);
		testOutput = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n","TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "HBL");
		testOutput += String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n","TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "School");
	
		assertEquals("Test that ViewAllTuition", testOutput, allTuition);
		
	}
	

	@Test
	public void doDeletionTuition() {
		//boundary
		assertNotNull("test if there is valid Tuition arraylist to delete from", tuitionList);
		C206_CaseStudy.addNewTuition(tuitionList, ntt1);
		// normal
		Boolean ok = C206_CaseStudy.doDeletionTuition(tuitionList, "TT01", 'Y');
		assertTrue("Test if an available item is ok to be deleted?", ok);
		//error condition
		ok = C206_CaseStudy.doDeletionTuition(tuitionList, "TT03", 'Y');
		assertFalse("Test if an invalid/non-existing tuition code is able to delete?", ok);	
		//normal condition
		ok = C206_CaseStudy.doDeletionTuition(tuitionList, "TT02", 'N');
		assertFalse("Test that not confirm is NOT ok to delete?", ok);
	}
	
	@Test
	//Sprint 2
	public void doUpdateTuition() {
		//Test if there is valid Tuition arraylist to update to - normal
		assertNotNull("test if there is valid Tuition arraylist to update to", tuitionList);
		C206_CaseStudy.updateTuition(tuitionList, "TT01", "f2f", "f2f");
		//Test if an available item is ok to be updated - normal
		C206_CaseStudy.addNewTuition(tuitionList, ntt2);
		Boolean ok = C206_CaseStudy.doUpdateTuition(tuitionList, "TT02", "online", "online");
		assertTrue("Test if an available item is ok to be updated?", ok);
		//Test if an invalid/non-existing tuition code is able to update - error
		ok = C206_CaseStudy.doUpdateTuition(tuitionList, "TT05", "f2f", "f2f");
		assertFalse("Test if an invalid/non-existing tuition code is able to update?", ok);	
	}
	
	@Test
	//Sprint 2
	public void retrieveSearchTuition() {
		// Test if Tuition list is not null but empty -boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve tuition", tuitionList);
		
		//test if the list of tuitions retrieved from the SourceCentre is empty - boundary
		String f2fTuition = C206_CaseStudy.retrieveSearchTuition(tuitionList,1);
		String testOutput2 = "";
		assertEquals("Check that ViewF2FTuition", testOutput2, f2fTuition);
		
		//Given an empty Tuition list, after adding 1 tuitions, test if the size of the list is 1 - normal
		C206_CaseStudy.addNewTuition(tuitionList, ntt3);
		assertEquals("Test that Tuition arraylist size is 1", 1, tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the SourceCentre	
		f2fTuition = C206_CaseStudy.retrieveSearchTuition(tuitionList,1);
		testOutput2 = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s %-25s\n","TT03", "Health", "GroupC", 
				"Nutrition", "2 hour", "basic science", "f2f", "f2f");
	
		assertEquals("Test that ViewF2FTuition", testOutput2, f2fTuition);
		
		//test if the list of tuitions retrieved from the SourceCentre is empty - boundary
		String onlineTuition = C206_CaseStudy.retrieveSearchTuition(tuitionList,2);
		String testOutput3 = "";
		assertEquals("Check that ViewOnlineTuition", testOutput3, onlineTuition);
				
		//Given the Tuition list, after adding more 1 tuitions, test if the size of the list is 2 - normal
		C206_CaseStudy.addNewTuition(tuitionList, ntt4);
		assertEquals("Test that Tuition arraylist size is 2", 2, tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the SourceCentre	
		onlineTuition = C206_CaseStudy.retrieveSearchTuition(tuitionList,2);
		testOutput3 = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s %-25s\n","TT04", "Technology", "GroupD", 
				"techy", "5 hour", "java", "online", "online");
			
		assertEquals("Test that ViewOnlineTuition", testOutput3, onlineTuition);

	}
//============== NICOLE TEST END =====================	

	
//NEHLA FATHIMA (19028074)
//============== NEHLA TEST START =====================	
	@Test
	public void addEnquiryTest()
	{
		// Item list is not null, so that can add a new enquiry - boundary
			assertNotNull("Test if there is valid enquiry arraylist to add to", enquiryList);
			//Given an empty list, after adding 1 enquiry, the size of the list is 1 - normal
			//The enquiry just added is as same as the first enquiry of the list
			C206_CaseStudy.addNewEnquiry(enquiryList, en1);
			assertEquals("Test that enquiry arraylist size is 1", 1, enquiryList.size());
			assertSame("Check that enquiry is added",en1, enquiryList.get(0));
			
			//Add another enquiry. test The size of the list is 2 -normal
			//The enquiry just added is as same as the second enquiry of the list
			C206_CaseStudy.addNewEnquiry(enquiryList, en2);
			assertEquals("Check that enquiry arraylist size is 2", 2, enquiryList.size());
			assertSame("Check that enquiry is added", en2, enquiryList.get(1));
	}
	
@Test
	public void retrieveEnquiryTest()
	{
	
	//Test if Enquirylist is not null but empty - boundary 
			assertNotNull("Test if there is valid enquiryList arraylist to retrieve from, StudentList");
			
			//Test if the list of enquiries retrieved from C206_CaseStudy is empty - boundary
			String allEnquiry = C206_CaseStudy.retrieveEnquiry(enquiryList);
			String testOutput = "";
			assertEquals("Check ViewTimetable", testOutput, allEnquiry);
			
			//Given an empty list, after adding 2 enquiries,test if the size of the list is 2 - normal
			C206_CaseStudy.addNewEnquiry(enquiryList , en1);
			C206_CaseStudy.addNewEnquiry(enquiryList , en2);
			
			assertEquals("Test that enquiry arraylist size is 2", 2, enquiryList.size());
			
			//Test if the expected output same as the list of enquiryList retrieved from the C206_CaseStudy
			allEnquiry = C206_CaseStudy.viewAllEnquiry(enquiryList);
			testOutput = String.format("");
			testOutput = String.format("%-15s %-20s %-15s %-15s %-20s %-10s\n", 1,"How to register", "2021-7-20", "09.15", "Email","Pending", "");
			testOutput += String.format("%-15s %-20s %-15s %-15s %-20s %-10s\n",2,"Tuition Fee", "2021-7-5", "13.15", "Email","Completed", "");
			
		//	assertEquals("Test viewEnquiry", testOutput, allEnquiry);
		
	}
	
	@Test	
	public void doDeletionEnquiry()
	{
		//Test list is not null -Boundary
				assertNotNull("Test if there is valid enquiry arraylist to retrieve item", enquiryList);
				
				//Test if enquiry ID can be removed -Normal
				C206_CaseStudy.addNewEnquiry(enquiryList, en1);
				Boolean check = C206_CaseStudy.doDeletionEnquiry(enquiryList, 1);
				assertTrue("Test if an enquiry is ok to be deleted?", check);
				
				//Test if same enquiry ID can be removed again -Error
				check = C206_CaseStudy.doDeletionEnquiry(enquiryList, 1);
				assertFalse("Test that the same enquiry is NOT ok to be deleted again?",check);
				
				//Test if enquiry ID can be removed -Normal
				C206_CaseStudy.addNewEnquiry(enquiryList, en2);
				check = C206_CaseStudy.doDeletionEnquiry(enquiryList, 2);
				assertTrue("Test if an enquiry is ok to be deleted?", check);
				
				//Test if same enquiry ID can be removed again -Error
				check = C206_CaseStudy.doDeletionEnquiry(enquiryList, 2);
				assertFalse("Test that the same enquiry is NOT ok to be deleted again?",check);
				
	}
//============== NEHLA TEST END =====================	

	
//RAVICHANDRAN SUNTHERESWARAN (20026389)
//============== RAVI TEST START =====================
	@Test
	public void addNewRegistration() {
		assertNotNull("Check if there is valid Registration arraylist to add to", registrationList);
		
		C206_CaseStudy.addNewRegistration(registrationList,r1);
		assertEquals("Check that Registration arraylist size is 1", 1, registrationList.size());
		assertSame("Check that Registration is added", r1, registrationList.get(0));

		C206_CaseStudy.addNewRegistration(registrationList,r2);
		assertEquals("Check that Registration arraylist size is 2", 2, registrationList.size());
		assertSame("Check that Registration is added", r2, registrationList.get(1));
	}
	
	
	@Test
	public void retrieveRegistration() {
		assertNotNull("Test if there is valid Registration arraylist to retrieve registration", registrationList);
		String allRegistration = C206_CaseStudy.retrieveRegistration(registrationList);
		String testOutput = "";
		assertEquals("Check that ViewAllRegistration", testOutput, allRegistration);
		C206_CaseStudy.addNewRegistration(registrationList, r1);
		C206_CaseStudy.addNewRegistration(registrationList, r2);
		assertEquals("Test that Registration arraylist size is 2", 2, registrationList.size());
		
		allRegistration= C206_CaseStudy.retrieveRegistration(registrationList);
		LocalDate date=LocalDate.now();
		String datestring=String.valueOf(date);
		testOutput = String.format("%-25d %-20d %-40s %-15s %s\n",1,1,C206_CaseStudy.obscure("ravi@gmail.com"),"Pending",datestring);
		testOutput += String.format("%-25d %-20d %-40s %-15s %s\n",2,2,C206_CaseStudy.obscure("ravichandran@gmail.com"),"Pending",datestring);
	
		assertEquals("Test that ViewAllRegistration", testOutput, allRegistration);
	}
	

	@Test
	public void doDeletionRegistration() {
		//boundary
		assertNotNull("test if there is valid Registration arraylist to delete from", registrationList);
		
		C206_CaseStudy.addNewRegistration(registrationList, r1);
		// normal
		Boolean ok = C206_CaseStudy.doDeletionRegistration(registrationList,1,"ravi@gmail.com");
		assertTrue("Test if an available item is ok to be deleted?", ok);
		//error condition
		ok = C206_CaseStudy.doDeletionRegistration(registrationList, 3,"ravi@yahoo.com");
		assertFalse("Test if an invalid/non-existing tuition code is able to delete?", ok);	

	}
	
//	@Test
	//Sprint 2
//	public void retrieveSearchRegistration() {
//		assertNotNull("Test if there is valid Registration arraylist to retrieve registration", registrationList);
//		String registration = C206_CaseStudy.retrieveSearchRegistration(registrationList,1);
//		String testOutput2 =String.format("%-25s %-20s %-40s %-15s %s\n","Registration ID"
//				,"Timetable ID",
//				"Email","Status","Date");
//		assertSame("Check that Registration list is empty", testOutput2, registration);
//		C206_CaseStudy.addNewRegistration(registrationList,r1);
//		assertEquals("Test that registration arraylist size is 1", 1, registrationList.size());
//		registration = C206_CaseStudy.retrieveSearchRegistration(registrationList,1);
//		LocalDate date=LocalDate.now();
//		String datestring=String.valueOf(date);
//		testOutput2 = String.format("%-25d %-20d %-40s %-15s %s\n",1,1,C206_CaseStudy.obscure("ravi@gmail.com"),"Pending",datestring);
//		assertEquals("Test that Registration", testOutput2, registration);
//		String onlineregistration = C206_CaseStudy.retrieveSearchRegistration(registrationList,2);
//		String testOutput3 = "";
//		assertEquals("Check that ViewOnlineregistration", testOutput3, onlineregistration);
//		C206_CaseStudy.addNewRegistration(registrationList, r2);
//		assertEquals("Test that registration arraylist size is 2", 2, registrationList.size());
//		onlineregistration = C206_CaseStudy.retrieveSearchRegistration(registrationList,2);
//		testOutput3 = String.format("%-25d %-20d %-40s %-15s %s\n",2,2,C206_CaseStudy.obscure("ravichandran@gmail.com"),"Pending",datestring);
//		assertEquals("Test that ViewOnlineregistration", testOutput3, onlineregistration);
//
//	}
//============== RAVI TEST END =====================

	
//TAN ZU ER (20036497)
//============== ZU ER TEST START =====================
	@Test
	public void registerStudentAccountTest() {
		//StudentList list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid StudentList arraylist to add to", StudentList);
		//Given an empty list, after adding StudentAccount, the size of the list become 1 - normal
		//The StudentAccount just added is as same as the sa1
		C206_CaseStudy.registerStudentAccount(StudentList, sa1);
		assertEquals("Check that StudentAccount arraylist size is 1", 1, StudentList.size());
		assertSame("Check that New Student is added", sa1, StudentList.get(0));
		//Add another StudentAccount. Test the size of the StudentList list is 2? - normal
		//The StudentAccount just added is as same as the sa2
		C206_CaseStudy.registerStudentAccount(StudentList, sa2);
		assertEquals("Check that StudentAccount arraylist size is 2", 2, StudentList.size());
		assertSame("Check that New Student is added", sa2, StudentList.get(1));
		
	}
	
	@Test
	public void retrieveAllStudentAccountTest() {
		//Test if StudentAccount list is not null but it is empty - boundary 
		assertNotNull("Test if there is valid StudentList arraylist to retrieve for, StudentList");
		
		//Test if the StudentList list retrived from C206_CaseStudy is empty - boundary
		String allStudentAcc = C206_CaseStudy.retrieveAllStudentAccount(StudentList);
		String testForOutput = "";
		assertEquals("Check that ViewStudentAccount", testForOutput, allStudentAcc);
		
		//Given an empty list, after adding 2 student account, if the size of the list is 2 - normal
		C206_CaseStudy.registerStudentAccount(StudentList,sa1);
		C206_CaseStudy.registerStudentAccount(StudentList, sa2);
		assertEquals("Test that StudentAccount arraylist size is 2", 2, StudentList.size());
		
		//Test if the expected output same as the list of StudentList retrieved from the C206_CaseStudy
		allStudentAcc = C206_CaseStudy.retrieveAllStudentAccount(StudentList);
		testForOutput = String.format("%-10s %-10s %-10s %-20s %-20s %-20s\n", "Alice", "F", 85478569, "alice123@gmail.com", "29JUL04", "SG");
		testForOutput += String.format("%-10s %-10s %-10s %-20s %-20s %-20s\n", "Benny", "M", 96585478, "benny098@gmail.com", "26APR06", "SG");
		
		assertEquals("Test that ViewAllStudentAccount", testForOutput, allStudentAcc);
		
	}
	
	@Test
	public void doDeleteStudentAcc() {
		//Test if the StudentList list is not null - boundary
		assertNotNull("Test if there is valid StudentList arraylist to delete for", StudentList);

		
		C206_CaseStudy.registerStudentAccount(StudentList, sa1);
		C206_CaseStudy.registerStudentAccount(StudentList, sa2);
		
		//Test for the sa1's name can be retrieve and test to delete sa1's name
		String name = sa1.getName();
		
		
		//normal condition
		Boolean isdeleted = C206_CaseStudy.doDeleteStudentAcc(StudentList, name);
		assertTrue("Test if this name is deleted", isdeleted);
		
		
		//error condition
		isdeleted = C206_CaseStudy.doDeleteStudentAcc(StudentList, name);
		assertFalse("Test that the student is fail to delete", isdeleted);
		
	}
	
	@Test
	public void addFeedbackTest() {
		//TFeedback list is not null, so that can add a new feedback - boundary
		assertNotNull("Check if there is valid TFeedback arraylist to add to", TFeedback);
		//Given an empty list, after adding TuitionFeedback, the size of the list become 1 - normal
		//The TuitionFeedback just added is as same as the tf1
		C206_CaseStudy.updateStudentFeedback(TFeedback, tf1);
		assertEquals("Check that StudentAccount arraylist size is 1", 1, TFeedback.size());
		assertSame("Check that New Student's feedback is added", tf1, TFeedback.get(0));
		//Add another TuitionFeedback. Test the size of the TuitionFeedback list is 2? - normal
		//The TuitionFeedback just added is as same as the tf2
		C206_CaseStudy.updateStudentFeedback(TFeedback, tf2);
		assertEquals("Check that StudentAccount arraylist size is 2", 2, TFeedback.size());
		assertSame("Check that New Student's feedback is added", tf2, TFeedback.get(1));
		
	}
	
	@Test
	public void retrieveTuitionFeedbackTest() {
		//Test if TuitionFeedback list is not null but it is empty - boundary 
		assertNotNull("Test if there is valid TFeedback arraylist to retrieve for, TFeedback");
		
		//Test if the TFeedback list retrived from C206_CaseStudy is empty - boundary
		String allFeedback = C206_CaseStudy.retrieveFeedback(TFeedback);
		String testForOutput = "";
		assertEquals("Check that View Tuition Feedback", testForOutput, allFeedback);
		
		//Given an empty list, after adding 2 student's feedback, if the size of the list is 2 - normal
		C206_CaseStudy.updateStudentFeedback(TFeedback,tf1);
		C206_CaseStudy.updateStudentFeedback(TFeedback, tf2);
		assertEquals("Test that TuitionFeedback arraylist size is 2", 2, TFeedback.size());
		
		//Test if the expected output same as the list of TFeedback retrieved from the C206_CaseStudy
		allFeedback = C206_CaseStudy.retrieveFeedback(TFeedback);
		testForOutput = String.format("%-10s %-20s %-20s %-60s\n", "Alice", "C1", "English Language", "Quite Fun!");
		testForOutput += String.format("%-10s %-20s %-20s %-60s\n", "Benny", "C2", "History", "Slide can be more in detailed");
		
		assertEquals("Test that View Tuition Feedback", testForOutput, allFeedback);
		
	}
	
	@Test
	public void addUpcomingTuitionTest() {
		//UTuition list is not null, so that can add a new upcoming tuition - boundary
		assertNotNull("Check if there is valid UTuition arraylist to add to", UTuition);
		//Given an empty list, after adding UpcomingTuition, the size of the list become 1 - normal
		//The UpcomingTuition just added is as same as the ut1
		C206_CaseStudy.updateStudentUpcomingTuition(UTuition, ut1);
		assertEquals("Check that UpcomingTuition arraylist size is 1", 1, UTuition.size());
		assertSame("Check that New Upcoming Tuition is added", ut1, UTuition.get(0));
		//Add another UpcomingTuition. Test the size of the UpcomingTuition list is 2? - normal
		//The UpcomingTuition just added is as same as the ut2
		C206_CaseStudy.updateStudentUpcomingTuition(UTuition, ut2);
		assertEquals("Check that UpcomingTuition arraylist size is 2", 2, UTuition.size());
		assertSame("Check that New Upcoming Tuition is added", ut2, UTuition.get(1));
		
	}
	
	@Test
	public void retrieveUpcomingTuitionTest() {
		//Test if UpcomingTuition list is not null but it is empty - boundary 
		assertNotNull("Test if there is valid UTuition arraylist to retrieve for, UTuition");
		
		//Test if the UpcomingTuition list retrived from C206_CaseStudy is empty - boundary
		String allUpcomingTuition = C206_CaseStudy.viewUpcomingTuition(UTuition);
		String testForOutput = "";
		assertEquals("Check that ViewUpcomingTuition", testForOutput, allUpcomingTuition);
		
		//Given an empty list, after adding 2 student's upcoming tuition, if the size of the list is 2 - normal
		C206_CaseStudy.updateStudentUpcomingTuition(UTuition,ut1);
		C206_CaseStudy.updateStudentUpcomingTuition(UTuition, ut2);
		assertEquals("Test that UpcomingTuition arraylist size is 2", 2, UTuition.size());
		
		//Test if the expected output same as the list of UTuition retrieved from the C206_CaseStudy
		allUpcomingTuition = C206_CaseStudy.viewUpcomingTuition(UTuition);
		testForOutput = String.format("%-10s %-20s %-20s %-20s\n", "Alice", "C1", "English Language", "25 Aug 2021");
		testForOutput += String.format("%-10s %-20s %-20s %-20s\n", "Benny", "C2", "History", "31 Aug 2021");
		
		assertEquals("Test that ViewUpcomingTuition", testForOutput, allUpcomingTuition);
		
	}
	
//============== ZU ER TEST END =====================
	
	@After
	public void tearDown() throws Exception {
		//nicole
		ntt1 = null;
		ntt2 = null;
		ntt3 = null;
		ntt4 = null;
		tuitionList = null;
		
		//nehla
		en1 = null;
		en2 = null;
		enquiryList = null;
		
		//ravi
		r1 = null;
		r2 = null;
		registrationList = null;
		
		//zu er
		sa1 = null;
		sa2 = null;
		StudentList = null;	
		
		tf1 = null;
		tf2 = null;
		TFeedback = null;
		
		ut1 = null;
		ut2 = null;
		UTuition = null;
	}
}
