
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Goh Sim Yng, Nicole 20014867, 3 Aug 2021 9:25:47 pm
 */

public class Tuition {
	private String tuitionCode;
	private String title;
	private String groupName;
	private String description;
	private String duration;
	private String preRequisite;
	private String mode;
	
	public Tuition(String tuitionCode, String title, String groupName, String description, String duration,
			String preRequisite, String mode) {
		this.tuitionCode = tuitionCode;
		this.title = title;
		this.groupName = groupName;
		this.description = description;
		this.duration = duration;
		this.preRequisite = preRequisite;
		this.mode = mode;
	}

	public String getTuitionCode() {
		return tuitionCode;
	}

	public void setTuitionCode(String tuitionCode) {
		this.tuitionCode = tuitionCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPreRequisite() {
		return preRequisite;
	}

	public void setPreRequisite(String preRequisite) {
		this.preRequisite = preRequisite;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public String toString() {
		String output = String.format("%-15s %-20s %-20s %-20s %-15s %-20s %-10s\n", 
				tuitionCode,
				title,
				groupName,
				description,
				duration,
				preRequisite,
				mode);
		return output;
	}
}
