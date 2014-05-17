package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;
import java.util.ArrayList;
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

	public void putRooms(RoomModel room) {
		if (this.rooms == null) {
			this.rooms = new ArrayList<RoomModel>();
		}

		this.rooms.add(room);
	}

}
