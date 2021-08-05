
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19028074, 4 Aug 2021 11:31:09 pm
 */
//done by nehla 
public class Enquiry {

	private int enquiryId;
	private String title;
	private String date;
	private String time;
	private String enquiryMethod;
	private String status;
	private String mode;
	
	public Enquiry(int enquiryId, String title, String date, String time, String enquiryMethod, String status,
			String mode) {
		super();
		this.enquiryId = enquiryId;
		this.title = title;
		this.date = date;
		this.time = time;
		this.enquiryMethod = enquiryMethod;
		this.status = status;
		this.mode = mode;
	}

	/**
	 * @return the enquiryId
	 */
	public int getEnquiryId() {
		return enquiryId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return the enquiryMethod
	 */
	public String getEnquiryMethod() {
		return enquiryMethod;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	
	public String toString() {
		String output = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n", 
				enquiryId,
				title,
				date,
				time,
				enquiryMethod,
				status,
				mode);
		return output;
	}
	
	
}
