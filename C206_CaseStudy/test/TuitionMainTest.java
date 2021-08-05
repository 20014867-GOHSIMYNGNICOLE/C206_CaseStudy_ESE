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

public class TuitionMainTest {
	private Tuition ntt1;
	private Tuition ntt2;
	
	private ArrayList<Tuition> tuitionList;
	
	public TuitionMainTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		ntt1 = new Tuition("TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "HBL");
		ntt2 = new Tuition("TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "School");

		tuitionList= new ArrayList<Tuition>();
	}

	
	@Test
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
		testOutput = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n","TT01", "Marketing", "GroupA", "Marketing for biz", "1 hour", "No", "HBL");
		testOutput += String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n","TT02", "ESports", "GroupB", "Athletes", "3 hour", "Good in technology", "School");
	
		assertEquals("Test that ViewAllTuition", testOutput, allTuition);
		
	}
	

	@Test
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
	
	@After
	public void tearDown() throws Exception {
		ntt1 = null;
		ntt2 = null;
		tuitionList = null;
	}
}
