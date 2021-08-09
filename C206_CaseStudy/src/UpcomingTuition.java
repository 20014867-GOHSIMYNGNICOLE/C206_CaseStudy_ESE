
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20036497, 8 Aug 2021 7:43:33 am
 */

public class UpcomingTuition {
	
	private String Name;
	private String TuitionCode;
	private String TuitionTitle;
	private String Date;

	public UpcomingTuition(String name, String tuitionCode, String tuitionTitle, String date) {
		Name = name;
		TuitionCode = tuitionCode;
		TuitionTitle = tuitionTitle;
		Date = date;
	}
	
	public String toString() {
		return String.format("%-10s %-20s %-20s %-20s", Name, TuitionCode, TuitionTitle, Date);
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
	
	public String getDate() {
		return Date;
	}

}
