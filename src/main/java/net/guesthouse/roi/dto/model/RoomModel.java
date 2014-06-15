package net.guesthouse.roi.dto.model;

public class RoomModel {
	private int id;
	private String roomNo;
	private boolean chked = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

}
