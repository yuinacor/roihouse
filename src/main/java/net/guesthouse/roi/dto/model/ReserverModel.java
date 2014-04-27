package net.guesthouse.roi.dto.model;

public class ReserverModel {
	private int id;
	private String rName;
	private String gender;
	private String nationality;
	private String phone;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ReserverModel [id=" + id + ", rName=" + rName + ", gender="
				+ gender + ", nationality=" + nationality + ", phone=" + phone
				+ ", email=" + email + "]";
	}

}
