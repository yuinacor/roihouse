package net.guesthouse.roi.reserve;

import java.sql.Timestamp;

public class ReserveRoom {

	private int id;
	private int reserveId;
	private String roomNo;
	private Timestamp reservedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Timestamp getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(Timestamp reservedDate) {
		this.reservedDate = reservedDate;
	}

}
