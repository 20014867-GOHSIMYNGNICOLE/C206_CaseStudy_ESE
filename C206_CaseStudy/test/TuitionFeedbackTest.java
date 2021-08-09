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
 * 20036497, 7 Aug 2021 11:30:37 pm
 */

public class TuitionFeedbackTest {

	private TuitionFeedback tf1;
	private TuitionFeedback tf2;

	
	private ArrayList<TuitionFeedback> TFeedback;
	
	public TuitionFeedbackTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		tf1 = new TuitionFeedback("Alice", "C1", "English Language", "Quite Fun!");
		tf2 = new TuitionFeedback("Benny", "C2", "History", "Slide can be more in detailed");
		
		TFeedback = new ArrayList<TuitionFeedback>();

	}
	
	@Test
	public void addFeedbackTest() {
		//TFeedback list is not null, so that can add a new feedback - boundary
		assertNotNull("Check if there is valid TFeedback arraylist to add to", TFeedback);
		//Given an empty list, after adding TuitionFeedback, the size of the list become 1 - normal
		//The TuitionFeedback just added is as same as the tf1
		ManageStudentTuition.updateStudentFeedback(TFeedback, tf1);
		assertEquals("Check that StudentAccount arraylist size is 1", 1, TFeedback.size());
		assertSame("Check that New Student's feedback is added", tf1, TFeedback.get(0));
		//Add another TuitionFeedback. Test the size of the TuitionFeedback list is 2? - normal
		//The TuitionFeedback just added is as same as the tf2
		ManageStudentTuition.updateStudentFeedback(TFeedback, tf2);
		assertEquals("Check that StudentAccount arraylist size is 2", 2, TFeedback.size());
		assertSame("Check that New Student's feedback is added", tf2, TFeedback.get(1));
		
	}
	
	@Test
	public void retrieveTuitionFeedbackTest() {
		//Test if TuitionFeedback list is not null but it is empty - boundary 
		assertNotNull("Test if there is valid TFeedback arraylist to retrieve for, TFeedback");
		
		//Test if the TFeedback list retrived from ManageStudentTuition is empty - boundary
		String allFeedback = ManageStudentTuition.retrieveFeedback(TFeedback);
		String testForOutput = "";
		assertEquals("Check that View Tuition Feedback", testForOutput, allFeedback);
		
		//Given an empty list, after adding 2 student's feedback, if the size of the list is 2 - normal
		ManageStudentTuition.updateStudentFeedback(TFeedback,tf1);
		ManageStudentTuition.updateStudentFeedback(TFeedback, tf2);
		assertEquals("Test that TuitionFeedback arraylist size is 2", 2, TFeedback.size());
		
		//Test if the expected output same as the list of TFeedback retrieved from the ManageStudentTuition
		allFeedback = ManageStudentTuition.retrieveFeedback(TFeedback);
		testForOutput = String.format("%-10s %-20s %-20s %-60s\n", "Alice", "C1", "English Language", "Quite Fun!");
		testForOutput += String.format("%-10s %-20s %-20s %-60s\n", "Benny", "C2", "History", "Slide can be more in detailed");
		
		assertEquals("Test that View Tuition Feedback", testForOutput, allFeedback);
		
	}
	
	
	@After
	public void tearDown() throws Exception{
		tf1 = null;
		tf2 = null;
		TFeedback = null;
	}

}
