package net.guesthouse.roi.reserve;

import java.sql.Timestamp;

public class Reserve {
	private int id;
	private String rType;
	private Timestamp reservDate;
	private String roomNo;
	private Timestamp chkin;
	private int nights;
	private int payPerDay;
	private int payment;
	private int deposit;
	private int balance;
	private String via;

	private String rName;
	private String gender;
	private String region;
	private String phone;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public Timestamp getReservDate() {
		return reservDate;
	}

	public void setReservDate(Timestamp reservDate) {
		this.reservDate = reservDate;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Timestamp getChkin() {
		return chkin;
	}

	public void setChkin(Timestamp chkin) {
		this.chkin = chkin;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public int getPayPerDay() {
		return payPerDay;
	}

	public void setPayPerDay(int payPerDay) {
		this.payPerDay = payPerDay;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

}
