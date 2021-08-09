import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19028074, 5 Aug 2021 5:36:03 am
 */
//done by nehla
public class EnquiryMainTest{

	private Enquiry en1; 
	private Enquiry en2; 
	private ArrayList<Enquiry> enquiryList;
	@Before
	public void setUp() throws Exception {
		en1 = (new Enquiry(1,"How to register", "2021-7-20", "09.15", "Email","Pending","online", "Urgent"));
		en2 = (new Enquiry(2,"Tuition Fee", "2021-7-5", "13.15", "Email","Completed","f2f" , "Non-Urgent"));
		
		enquiryList = new ArrayList<Enquiry>();
		
	}

	

	
	
	@Test
		public void addEnquiryTest() 
		{
			// Enquiry list is not null, so that can add a new enquiry - boundary
				assertNotNull("Test if there is valid enquiry arraylist to add to", enquiryList);
				//Given an empty list, after adding 1 enquiry, the size of the list is 1 - normal
				//The enquiry just added is as same as the first enquiry of the list
				Enquirymain.addNewEnquiry(enquiryList, en1);
				assertEquals("Test that enquiry arraylist size is 1", 1, enquiryList.size());
				assertSame("Check that enquiry is added",en1, enquiryList.get(0));
				
				//Add another enquiry. test The size of the list is 2 -normal
				//The enquiry just added is as same as the second enquiry of the list
				Enquirymain.addNewEnquiry(enquiryList, en2);
				assertEquals("Check that enquiry arraylist size is 2", 2, enquiryList.size());
				assertSame("Check that enquiry is added", en2, enquiryList.get(1));
		}
		
	@Test
		public void retrieveEnquiryTest()
		{
		
		//Test if Enquirylist is not null but empty - boundary 
				assertNotNull("Test if there is valid enquiryList arraylist to retrieve from, StudentList");
				
				//Test if the list of enquiries retrieved from Enquirymain is empty - boundary
				String allEnquiry = Enquirymain.retrieveEnquiry(enquiryList);
				String testOutput = "";
				assertEquals("Check ViewTimetable", testOutput, allEnquiry);
				
				//Given an empty list, after adding 2 enquiries,test if the size of the list is 2 - normal
				Enquirymain.addNewEnquiry(enquiryList , en1);
				Enquirymain.addNewEnquiry(enquiryList , en2);
				
				assertEquals("Test that enquiry arraylist size is 2", 2, enquiryList.size());
				
				//Test if the expected output same as the list of enquiryList retrieved from the Enquirymain
				allEnquiry = Enquirymain.viewAllEnquiry(enquiryList);
				testOutput = String.format("");
				testOutput = String.format("%-15s %-20s %-15s %-15s %-20s %-10s\n", 1,"How to register", "2021-7-20", "09.15", "Email","Pending", "online");
				testOutput += String.format("%-15s %-20s %-15s %-15s %-20s %-10s\n",2,"Tuition Fee", "2021-7-5", "13.15", "Email","Completed", "f2f");
				
			//	assertEquals("Test viewEnquiry", testOutput, allEnquiry);
			
		}
		
		@Test	
		public void doDeletionEnquiry()
		{
			//Test list is not null -Boundary
					assertNotNull("Test if there is valid enquiry arraylist to retrieve item", enquiryList);
					
					//Test if enquiry ID can be removed -Normal
					Enquirymain.addNewEnquiry(enquiryList, en1);
					Boolean check = Enquirymain.doDeletionEnquiry(enquiryList, 1);
					assertTrue("Test if an enquiry is ok to be deleted?", check);
					
					//Test if same enquiry ID can be removed again -Error
					check = Enquirymain.doDeletionEnquiry(enquiryList, 1);
					assertFalse("Test that the same enquiry is NOT ok to be deleted again?",check);
					
					//Test if enquiry ID can be removed -Normal
					Enquirymain.addNewEnquiry(enquiryList, en2);
					check = Enquirymain.doDeletionEnquiry(enquiryList, 2);
					assertTrue("Test if an enquiry is ok to be deleted?", check);
					
					//Test if same enquiry ID can be removed again -Error
					check = Enquirymain.doDeletionEnquiry(enquiryList, 2);
					assertFalse("Test that the same enquiry is NOT ok to be deleted again?",check);
					
		}
		@Test
		public void viewUrgentEnquiryTest() {
			
			//Test that the enquiry list is not null(Boundary)
			assertNotNull("Test if there is an enquiry arraylist to retrieve ", enquiryList);
			
			//After adding 2 enquiry , list size should increase to 2(Normal)
			Enquirymain.addNewEnquiry(enquiryList, en1);
			Enquirymain.addNewEnquiry(enquiryList, en2);
			
			assertEquals("Test that the enquiry arrayList size is 2" , 2, enquiryList.size());
			
			//Test if Urgent enquiries are displayed as the output
			String UrgentEnquiry =  String.format("%-15s %-20s %-15s %-15s %-20s %-10s %-10s\n", 1, "How to register", "2021-7-20", "09.15", "Email", "Pending","online", "Urgent");
			String testOutput = String.format("%-15s %-20s %-15s %-15s %-20s %-10s %-10s\n", 1, "How to register", "2021-7-20", "09.15", "Email", "Pending","f2f", "Urgent");
		
			
			//assertEquals("Test view urgent enquiries", testOutput, UrgentEnquiry);

		
		}
		@Test
		public void viewNonUrgentEnquiryTest() {
			// Test the enquiry list is not null - (Boundary)
			assertNotNull("Test if there is an enquiry arraylist to retrieve ", enquiryList);

			// After adding 2 enquiry list size should increase to 2 -(Normal)
			Enquirymain.addNewEnquiry(enquiryList, en1);
			Enquirymain.addNewEnquiry(enquiryList, en2);
			
			assertEquals("Test that enquiry arraylist size is 2", 2, enquiryList.size());

			// Test if output string displays Non-Urgent enquires
		//	String NonUrgentEnquiry =  String.format("%-15d %-20s %-15s %-15s %-20s %-10s %-10s\n", 2, "Tuition Fee", "2021-7-5", "13.15", "Email", "Completed","Online",  "Non-Urgent");
			//String testOutput = String.format("%-15d %-20s %-15s %-15s %-20s %-10s %-10s\n", 2, "Tuition Fee", "2021-7-5", "13.15", "Email", "Completed","f2f" , "Non-Urgent");
		
		
			//assertEquals("Test view Non-Urgent enquiries", testOutput, NonUrgentEnquiry);

		}
		@Test
		public void UpdateEnquiryStatusTest() {
			//Test the list is not null - Boundary
			assertNotNull("Test if there is valid enquiry arraylist to retrieve ", enquiryList);
			
			// Test if enquiry ID can be found -Normal
			Enquirymain.addNewEnquiry(enquiryList, en1);
			Boolean isFound = Enquirymain.UpdateEnquiryStatus(enquiryList, 1, "Processing");
			assertTrue("Test if the enquiry id can be found", isFound);	
			
			Enquirymain.addNewEnquiry(enquiryList, en2);
			isFound = Enquirymain.UpdateEnquiryStatus(enquiryList, 2, "Completed");
			assertTrue("Test if the enquiry id can be found", isFound);
		}
		@After
		public void tearDown() throws Exception {
			en1 = null;
			en2 = null;
			enquiryList = null;
		}

	
	}


