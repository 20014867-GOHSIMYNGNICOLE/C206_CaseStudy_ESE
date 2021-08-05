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

public class EnquiryMainTest{

	private Enquiry en1; 
	private Enquiry en2; 
	private ArrayList<Enquiry> enquiryList;
	@Before
	public void setUp() throws Exception {
		en1 = (new Enquiry(1,"How to register", "2021-7-20", "09.15", "Email","Pending",""));
		en2 = (new Enquiry(2,"Tuition Fee", "2021-7-5", "13.15", "Email","Completed",""));
		
		enquiryList = new ArrayList<Enquiry>();
		
	}

	

	@After
	public void tearDown() throws Exception {
		en1 = null;
		en2 = null;
		enquiryList = null;
	}
	
	@Test
	
		public void viewEnquiryTest()
		{
			//Test if list is not null - Boundary
					assertNotNull("Test if there is valid Tuition Timetable arraylist to retrieve item", enquiryList);
					
					//Test if Timetable List is not empty -Boundary
					String allenquiry = C206_CaseStudy.viewEnquiry(enquiryList);
					String testOutput ="";
					assertEquals("Check ViewTimetable", testOutput, allenquiry);
					
					//After adding 3 items list size should increase to 2 -Normal
					C206_CaseStudy.viewEnquiry(enquiryList);
					C206_CaseStudy.viewEnquiry(enquiryList);
					
					assertEquals("Test that enquiry arraylist size is 2", 2, enquiryList.size());
					
					//Test if output string is same as enquiry list 
					allenquiry = C206_CaseStudy.viewEnquiry(enquiryList);
					testOutput = String.format("");
					testOutput = String.format("%-15s %-20s %-15s %-15s %-20s %-10s\n", 1,"How to register", "2021-7-20", "09.15", "Email","Pending");
					testOutput += String.format("%-15s %-20s %-15s %-15s %-20s %-10s\n",2,"Tuition Fee", "2021-7-5", "13.15", "Email","Completed");
					
					assertEquals("Test viewEnquiry", testOutput, allenquiry);
			
		}
		
		
		public void addEnquiryTest()
		{
			// Item list is not null, so that can add a new item - boundary
					assertNotNull("Check if there is valid Camcorder arraylist to add to", enquiryList);
					//Given an empty list, after adding 1 item, the size of the list is 1 - normal
					//The item just added is as same as the first item of the list
					C206_CaseStudy.addEnquiry(enquiryList, en1);
					assertEquals("Check that enquiry arraylist size is 1", 1, enquiryList.size());
					assertSame("Check that enquiry is added",en1, enquiryList.get(0));
					
					//Add another item. test The size of the list is 2? -normal
					//The item just added is as same as the second item of the list
					C206_CaseStudy.addEnquiry(enquiryList, en2);
					assertEquals("Check that enquiry arraylist size is 2", 2, enquiryList.size());
					assertSame("Check that enquiry is added", en2, enquiryList.get(1));
		}
			
		public void deleteEnquiry()
		{
			//Make sure list is not null -Boundary
					assertNotNull("Test if there is valid enquiry arraylist to retrieve item", enquiryList);
					
					//Test if enquiry ID can be removed -Normal
					C206_CaseStudy.addEnquiry(enquiryList, en1);
					Boolean check = C206_CaseStudy.deleteEnquiry(enquiryList, 1);
					assertTrue("Test if an enquiry is ok to be deleted?", check);
					
					//Test if same enquiry ID can be removed again -Error
					check = C206_CaseStudy.deleteEnquiry(enquiryList, 1);
					assertFalse("Test that the same enquiry is NOT ok to be deleted again?",check);
					
					//Test if enquiry ID can be removed -Normal
					C206_CaseStudy.addEnquiry(enquiryList, en2);
					check = C206_CaseStudy.deleteEnquiry(enquiryList, 2);
					assertTrue("Test if an enquiry is ok to be deleted?", check);
					
					//Test if same enquiry ID can be removed again -Error
					check = C206_CaseStudy.deleteEnquiry(enquiryList, 2);
					assertFalse("Test that the same enquiry is NOT ok to be deleted again?",check);
					
					//Test if enquiry list size has dropped to 0 after removing the 3 test items
					assertEquals("Check that enquiry list is not bigger than 0",0,enquiryList.size());
		}
		

	
	}


