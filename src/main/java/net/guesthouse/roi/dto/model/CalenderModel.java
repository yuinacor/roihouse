package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;
import java.util.List;

public class CalenderModel {
	private Timestamp calenderDate;
	private List<RoomModel> rooms;

	public Timestamp getCalenderDate() {
		return calenderDate;
	}

	public void setCalenderDate(Timestamp calenderDate) {
		this.calenderDate = calenderDate;
	}

	public List<RoomModel> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomModel> rooms) {
		this.rooms = rooms;
	}

}
