
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20036497, 7 Aug 2021 9:48:28 pm 
 */

public class TuitionFeedback {
	
	private String Name;
	private String TuitionCode;
	private String TuitionTitle;
	private String Feedback;

	public TuitionFeedback(String name, String tuitionCode, String tuitionTitle, String feedback) {
		Name = name;
		TuitionCode = tuitionCode;
		TuitionTitle = tuitionTitle;
		Feedback = feedback;
	}
	
	public String toString() {
		return String.format("%-10s %-20s %-20s %-60s", Name, TuitionCode, TuitionTitle, Feedback);
	}


	public String getName() {
		return Name;
	}


	public String getTuitionCode() {
		return TuitionCode;
	}


	public String getTuitionTitle() {
		return TuitionTitle;
	}

	public String getFeedback() {
		return Feedback;
	}
	

}
