
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ravichandran_Sunthereswaran, 4 Aug 2021 10:07:43 am -
 */

public class Registration {
	private int registrationid;
	private int tuitiontimetableid;
	private String studentemail;
	private String status;
	private String registrationdate;
	public Registration(int registrationid, int tuitiontimetableid, String studentemail,
			String registrationdate) {
		this.registrationid = registrationid;
		this.tuitiontimetableid = tuitiontimetableid;
		this.studentemail = studentemail;
		status="Pending";
		this.registrationdate = registrationdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRegistrationid() {
		return registrationid;
	}
	public int getTuitiontimetableid() {
		return tuitiontimetableid;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public String getRegistrationdate() {
		return registrationdate;
	}
	
}
