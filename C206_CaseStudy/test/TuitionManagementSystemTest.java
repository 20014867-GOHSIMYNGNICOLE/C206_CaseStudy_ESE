

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
 * 20036497, 3 Aug 2021 9:49:06 pm
 */

public class TuitionManagementSystemTest {
	
	private StudentAccount sa1;
	private StudentAccount sa2;
	
	private ArrayList<StudentAccount> StudentList;

	public TuitionManagementSystemTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		sa1 = new StudentAccount("Alice", "F", 85478569, "alice123@gmail.com", "29JUL04", "SG");
		sa2 = new StudentAccount("Benny", "M", 96585478, "benny098@gmail.com", "26APR06", "SG");
		
		StudentList = new ArrayList<StudentAccount>();

	}
	
	@Test
	public void registerStudentAccountTest() {
		//StudentList list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid StudentList arraylist to add to", StudentList);
		//Given an empty list, after adding StudentAccount, the size of the list become 1 - normal
		//The StudentAccount just added is as same as the sa1
		TuitionManagementSystem.registerStudentAccount(StudentList, sa1);
		assertEquals("Check that StudentAccount arraylist size is 1", 1, StudentList.size());
		assertSame("Check that New Student is added", sa1, StudentList.get(0));
		//Add another StudentAccount. Test the size of the StudentList list is 2? - normal
		//The StudentAccount just added is as same as the sa2
		TuitionManagementSystem.registerStudentAccount(StudentList, sa2);
		assertEquals("Check that StudentAccount arraylist size is 2", 2, StudentList.size());
		assertSame("Check that New Student is added", sa2, StudentList.get(1));
		
	}
	
	@Test
	public void retrieveAllStudentAccountTest() {
		//Test if StudentAccount list is not null but it is empty - boundary 
		assertNotNull("Test if there is valid StudentList arraylist to retrieve for, StudentList");
		
		//Test if the StudentList list retrived from TuitionManagementSystem is empty - boundary
		String allStudentAcc = TuitionManagementSystem.retrieveAllStudentAccount(StudentList);
		String testForOutput = "";
		assertEquals("Check that ViewStudentAccount", testForOutput, allStudentAcc);
		
		//Given an empty list, after adding 2 student account, if the size of the list is 2 - normal
		TuitionManagementSystem.registerStudentAccount(StudentList,sa1);
		TuitionManagementSystem.registerStudentAccount(StudentList, sa2);
		assertEquals("Test that StudentAccount arraylist size is 2", 2, StudentList.size());
		
		//Test if the expected output same as the list of StudentList retrieved from the TuitionManagementSystem
		allStudentAcc = TuitionManagementSystem.retrieveAllStudentAccount(StudentList);
		testForOutput = String.format("%-10s %-10s %-10s %-20s %-20s %-20s\n", "Alice", "F", 85478569, "alice123@gmail.com", "29JUL04", "SG");
		testForOutput += String.format("%-10s %-10s %-10s %-20s %-20s %-20s\n", "Benny", "M", 96585478, "benny098@gmail.com", "26APR06", "SG");
		
		assertEquals("Test that ViewAllStudentAccount", testForOutput, allStudentAcc);
		
	}
	
	@Test
	public void doDeleteStudentAcc() {
		//Test if the StudentList list is not null - boundary
		assertNotNull("Test if there is valid StudentList arraylist to delete for", StudentList);

		
		TuitionManagementSystem.registerStudentAccount(StudentList, sa1);
		TuitionManagementSystem.registerStudentAccount(StudentList, sa2);
		
		//Test for the sa1's name can be retrieve and test to delete sa1's name
		String name = sa1.getName();
		
		
		//normal condition
		Boolean isdeleted = TuitionManagementSystem.doDeleteStudentAcc(StudentList, name);
		assertTrue("Test if this name is deleted", isdeleted);
		
		
		//error condition
		isdeleted = TuitionManagementSystem.doDeleteStudentAcc(StudentList, name);
		assertFalse("Test that the student is fail to delete", isdeleted);
		
		
	}
	
	@After
	public void tearDown() throws Exception{
		sa1 = null;
		sa2 = null;
		StudentList = null;
	}




}
