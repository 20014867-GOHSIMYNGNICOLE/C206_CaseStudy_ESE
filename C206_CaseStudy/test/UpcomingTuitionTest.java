import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20036497, 8 Aug 2021 8:20:53 am
 */

public class UpcomingTuitionTest {

	private UpcomingTuition ut1;
	private UpcomingTuition ut2;
	private ArrayList<UpcomingTuition> UTuition;
	
	public UpcomingTuitionTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub

		ut1 = new UpcomingTuition("Alice", "C1", "English Language", "25 Aug 2021");
		ut2 = new UpcomingTuition("Benny", "C2", "History", "31 Aug 2021");

		UTuition = new ArrayList<UpcomingTuition>();

	}
	
	@Test
	public void addUpcomingTuitionTest() {
		//UTuition list is not null, so that can add a new upcoming tuition - boundary
		assertNotNull("Check if there is valid UTuition arraylist to add to", UTuition);
		//Given an empty list, after adding UpcomingTuition, the size of the list become 1 - normal
		//The UpcomingTuition just added is as same as the ut1
		ManageStudentTuition.updateStudentUpcomingTuition(UTuition, ut1);
		assertEquals("Check that UpcomingTuition arraylist size is 1", 1, UTuition.size());
		assertSame("Check that New Upcoming Tuition is added", ut1, UTuition.get(0));
		//Add another UpcomingTuition. Test the size of the UpcomingTuition list is 2? - normal
		//The UpcomingTuition just added is as same as the ut2
		ManageStudentTuition.updateStudentUpcomingTuition(UTuition, ut2);
		assertEquals("Check that UpcomingTuition arraylist size is 2", 2, UTuition.size());
		assertSame("Check that New Upcoming Tuition is added", ut2, UTuition.get(1));
		
	}
	
	@Test
	public void retrieveUpcomingTuitionTest() {
		//Test if UpcomingTuition list is not null but it is empty - boundary 
		assertNotNull("Test if there is valid UTuition arraylist to retrieve for, UTuition");
		
		//Test if the UpcomingTuition list retrived from ManageStudentTuition is empty - boundary
		String allUpcomingTuition = ManageStudentTuition.viewUpcomingTuition(UTuition);
		String testForOutput = "";
		assertEquals("Check that ViewUpcomingTuition", testForOutput, allUpcomingTuition);
		
		//Given an empty list, after adding 2 student's upcoming tuition, if the size of the list is 2 - normal
		ManageStudentTuition.updateStudentUpcomingTuition(UTuition,ut1);
		ManageStudentTuition.updateStudentUpcomingTuition(UTuition, ut2);
		assertEquals("Test that UpcomingTuition arraylist size is 2", 2, UTuition.size());
		
		//Test if the expected output same as the list of UTuition retrieved from the ManageStudentTuition
		allUpcomingTuition = ManageStudentTuition.viewUpcomingTuition(UTuition);
		testForOutput = String.format("%-10s %-20s %-20s %-20s\n", "Alice", "C1", "English Language", "25 Aug 2021");
		testForOutput += String.format("%-10s %-20s %-20s %-20s\n", "Benny", "C2", "History", "31 Aug 2021");
		
		assertEquals("Test that ViewUpcomingTuition", testForOutput, allUpcomingTuition);
		
	}
	
	
	@After
	public void tearDown() throws Exception{
		ut1 = null;
		ut2 = null;
		UTuition = null;
	}

}
