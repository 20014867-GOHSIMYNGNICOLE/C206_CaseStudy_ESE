import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ravichandran_Sunthereswaran, 4 Aug 2021 11:54:38 am 
 */

public class RegistrationMainTest {
	private Registration r1;
	private Registration r2;

	
	private ArrayList<Registration> registrationList;
	
	public RegistrationMainTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		LocalDate date=LocalDate.now();
		String stringdate=String.valueOf(date);
		r1 = new Registration(1,1,"ravi@gmail.com",stringdate);
		r2 = new Registration(2,2,"ravichandran@gmail.com",stringdate);
		registrationList= new ArrayList<Registration>();

	}
	@Test
	public void addNewRegistration() {
		assertNotNull("Check if there is valid Registration arraylist to add to", registrationList);
		
		RegistrationMain.addNewRegistration(registrationList,r1);
		assertEquals("Check that Registration arraylist size is 1", 1, registrationList.size());
		assertSame("Check that Registration is added", r1, registrationList.get(0));

		RegistrationMain.addNewRegistration(registrationList,r2);
		assertEquals("Check that Registration arraylist size is 2", 2, registrationList.size());
		assertSame("Check that Registration is added", r2, registrationList.get(1));
	}
	
	
	@Test
	public void retrieveRegistration() {
		assertNotNull("Test if there is valid Registration arraylist to retrieve registration", registrationList);
		String allRegistration = RegistrationMain.retrieveRegistration(registrationList);
		String testOutput = "";
		assertEquals("Check that ViewAllRegistration", testOutput, allRegistration);
		RegistrationMain.addNewRegistration(registrationList, r1);
		RegistrationMain.addNewRegistration(registrationList, r2);
		assertEquals("Test that Registration arraylist size is 2", 2, registrationList.size());
		
		allRegistration= RegistrationMain.retrieveRegistration(registrationList);
		LocalDate date=LocalDate.now();
		String datestring=String.valueOf(date);
		testOutput = String.format("%-25d %-20d %-40s %-15s %s\n",1,1,RegistrationMain.obscure("ravi@gmail.com"),"Pending",datestring);
		testOutput += String.format("%-25d %-20d %-40s %-15s %s\n",2,2,RegistrationMain.obscure("ravichandran@gmail.com"),"Pending",datestring);
	
		assertEquals("Test that ViewAllRegistration", testOutput, allRegistration);
	}
	

	@Test
	public void doDeletionRegistration() {
		//boundary
		assertNotNull("test if there is valid Registration arraylist to delete from", registrationList);
		
		RegistrationMain.addNewRegistration(registrationList, r1);
		// normal
		Boolean ok = RegistrationMain.doDeletionRegistration(registrationList,1,"ravi@gmail.com");
		assertTrue("Test if an available item is ok to be deleted?", ok);
		//error condition
		ok = RegistrationMain.doDeletionRegistration(registrationList, 3,"ravi@yahoo.com");
		assertFalse("Test if an invalid/non-existing tuition code is able to delete?", ok);	

	}
	
	@After
	public void tearDown() throws Exception {
		r1 = null;
		r2 = null;
		registrationList = null;
	}
}