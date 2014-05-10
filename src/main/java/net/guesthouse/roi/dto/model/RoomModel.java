package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;

public class RoomModel {
	private String roomNo;
	private Timestamp chkin;
	private boolean chked;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public boolean isChked() {
		return chked;
	}

	public void setChked(boolean chked) {
		this.chked = chked;
	}

	public Timestamp getChkin() {
		return chkin;
	}

	public void setChkin(Timestamp chkin) {
		this.chkin = chkin;
	}
	
}
