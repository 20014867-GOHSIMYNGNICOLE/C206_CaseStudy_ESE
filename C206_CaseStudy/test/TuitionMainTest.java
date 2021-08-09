import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Goh Sim Yng, Nicole 20014867, 4 Aug 2021 12:39:30 am
 */

//GOH SIM YNG, NICOLE (20014867)
public class TuitionMainTest {
	
	//Sprint 1
	private Tuition ntt1;
	private Tuition ntt2;
	
	//Sprint 2
	private Tuition ntt3;
	private Tuition ntt4;
	
	private ArrayList<Tuition> tuitionList;
	
	public TuitionMainTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		//Sprint 1
		ntt1 = new Tuition("TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "online");
		ntt2 = new Tuition("TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "f2f");
		
		//Sprint 2
		ntt3 = new Tuition("TT03", "Health", "GroupC", "Nutrition", "2 hour", "basic science", "f2f", "f2f");
		ntt4 = new Tuition("TT04", "Technology", "GroupD", "techy", "5 hour", "java", "online", "online");

		tuitionList= new ArrayList<Tuition>();
	}

	
	@Test
	//Sprint 1
	public void addNewTuition() {
		// Tuition list is not null, so that can add a new tuition - boundary
		assertNotNull("Check if there is valid Tuition arraylist to add to", tuitionList);
		
		//Given an empty Tuition list, after adding 1 new tuition, the size of the list is 1 - normal
		//The tuition just added is as same as the first tuition of the list
		TuitionMain.addNewTuition(tuitionList, ntt1);
		assertEquals("Check that Tuition arraylist size is 1", 1, tuitionList.size());
		assertSame("Check that Tuition is added", ntt1, tuitionList.get(0));
		
		//Add another new tuition, test the size of the list is 2? -normal
		//The new tuition just added is as same as the second tuition of the list
		TuitionMain.addNewTuition(tuitionList, ntt2);
		assertEquals("Check that Tuition arraylist size is 2", 2, tuitionList.size());
		assertSame("Check that Tuition is added", ntt2, tuitionList.get(1));
	}
	
	
	@Test
	//Sprint 1
	public void retrieveTuition() {
		// Test if Tuition list is not null but empty -boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve tuition", tuitionList);
		
		//test if the list of tuitions retrieved from the SourceCentre is empty - boundary
		String allTuition = TuitionMain.retrieveTuition(tuitionList);
		String testOutput = "";
		assertEquals("Check that ViewAllTuition", testOutput, allTuition);
		
		//Given an empty Tuition list, after adding 2 tuitions, test if the size of the list is 2 - normal
		TuitionMain.addNewTuition(tuitionList, ntt1);
		TuitionMain.addNewTuition(tuitionList, ntt2);
		assertEquals("Test that Tuition arraylist size is 2", 2, tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the SourceCentre	
		allTuition = TuitionMain.retrieveTuition(tuitionList);
		testOutput = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n","TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "online");
		testOutput += String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n","TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "f2f");
	
		assertEquals("Test that ViewAllTuition", testOutput, allTuition);
		
	}
	

	@Test
	//Sprint 1
	public void doDeletionTuition() {
		//boundary
		assertNotNull("test if there is valid Tuition arraylist to delete from", tuitionList);
		TuitionMain.addNewTuition(tuitionList, ntt1);
		// normal
		Boolean ok = TuitionMain.doDeletionTuition(tuitionList, "TT01", 'Y');
		assertTrue("Test if an available item is ok to be deleted?", ok);
		//error condition
		ok = TuitionMain.doDeletionTuition(tuitionList, "TT03", 'Y');
		assertFalse("Test if an invalid/non-existing tuition code is able to delete?", ok);	
		//normal condition
		ok = TuitionMain.doDeletionTuition(tuitionList, "TT02", 'N');
		assertFalse("Test that not confirm is NOT ok to delete?", ok);
	}
	
	@Test
	//Sprint 2
	public void doUpdateTuition() {
		//Test if there is valid Tuition arraylist to update to - normal
		assertNotNull("test if there is valid Tuition arraylist to update to", tuitionList);
		TuitionMain.updateTuition(tuitionList, "TT01", "f2f", "f2f");
		//Test if an available item is ok to be updated - normal
		TuitionMain.addNewTuition(tuitionList, ntt2);
		Boolean ok = TuitionMain.doUpdateTuition(tuitionList, "TT02", "online", "online");
		assertTrue("Test if an available item is ok to be updated?", ok);
		//Test if an invalid/non-existing tuition code is able to update - error
		ok = TuitionMain.doUpdateTuition(tuitionList, "TT05", "f2f", "f2f");
		assertFalse("Test if an invalid/non-existing tuition code is able to update?", ok);	
	}
	
	@Test
	//Sprint 2
	public void retrieveSearchTuition() {
		// Test if Tuition list is not null but empty -boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve tuition", tuitionList);
		
		//test if the list of tuitions retrieved from the SourceCentre is empty - boundary
		String f2fTuition = TuitionMain.retrieveSearchTuition(tuitionList,1);
		String testOutput2 = "";
		assertEquals("Check that ViewF2FTuition", testOutput2, f2fTuition);
		
		//Given an empty Tuition list, after adding 1 tuitions, test if the size of the list is 1 - normal
		TuitionMain.addNewTuition(tuitionList, ntt3);
		assertEquals("Test that Tuition arraylist size is 1", 1, tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the SourceCentre	
		f2fTuition = TuitionMain.retrieveSearchTuition(tuitionList,1);
		testOutput2 = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s %-25s\n","TT03", "Health", "GroupC", 
				"Nutrition", "2 hour", "basic science", "f2f", "f2f");
	
		assertEquals("Test that ViewF2FTuition", testOutput2, f2fTuition);
		
		//test if the list of tuitions retrieved from the SourceCentre is empty - boundary
		String onlineTuition = TuitionMain.retrieveSearchTuition(tuitionList,2);
		String testOutput3 = "";
		assertEquals("Check that ViewOnlineTuition", testOutput3, onlineTuition);
				
		//Given the Tuition list, after adding more 1 tuitions, test if the size of the list is 2 - normal
		TuitionMain.addNewTuition(tuitionList, ntt4);
		assertEquals("Test that Tuition arraylist size is 2", 2, tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the SourceCentre	
		onlineTuition = TuitionMain.retrieveSearchTuition(tuitionList,2);
		testOutput3 = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s %-25s\n","TT04", "Technology", "GroupD", 
				"techy", "5 hour", "java", "online", "online");
			
		assertEquals("Test that ViewOnlineTuition", testOutput3, onlineTuition);

	}
	
	@After
	public void tearDown() throws Exception {
		ntt1 = null;
		ntt2 = null;
		ntt3 = null;
		ntt4 = null;
		tuitionList = null;
	}
}
