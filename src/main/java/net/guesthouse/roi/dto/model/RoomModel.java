package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;

public class RoomModel {
	private String roomNo;
	private Timestamp chkin;
	private int nights;
	private boolean chked;

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

	public boolean isChked() {
		return chked;
	}

	public void setChked(boolean chked) {
		this.chked = chked;
	}

}
