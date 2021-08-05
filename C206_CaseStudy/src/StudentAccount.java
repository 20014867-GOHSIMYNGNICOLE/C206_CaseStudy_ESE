

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20036497, 3 Aug 2021 7:46:14 pm
 */

public class StudentAccount {
	private String name;
	private String gender;
	private int mobile;
	private String email;
	private String dob;
	private String cor;
	private String feedback;
	
	public StudentAccount(String name, String gender, int mobile, String email, String dob, String cor, String feedback) {
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.cor = cor;
		this.feedback = feedback;
	}
	
	public String toString() {
		return String.format("%-10s %-10s %-10d %-20s %-20s %-20s", name, gender, mobile, email, dob, cor);
	}


	public String getName() {
		return name;
	}


	public String getGender() {
		return gender;
	}


	public int getMobile() {
		return mobile;
	}

	
	public String getDob() {
		return dob;
	}


	public String getCor() {
		return cor;
	}


	public String getEmail() {
		return email;
	}
	
	public String getFeedback() {
		return feedback;
	}

}

