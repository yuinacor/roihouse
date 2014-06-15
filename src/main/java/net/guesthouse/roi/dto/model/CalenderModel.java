package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalenderModel {
	private Timestamp calenderDate;
	private List<RoomModel> rooms;

	private final String[] roomNos = { "201", "202", "203", "301", "302",
			"303", "401", "402", "df1", "df2", "df3", "df4", "df5", "dm1",
			"dm2", "dm3", "dm4", "dm5" };

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

	public void putRooms(int id, String room) {
		if (this.rooms == null) {
			this.rooms = new ArrayList<RoomModel>(roomNos.length);
			for (String roomNo : roomNos) {
				RoomModel roomModel = new RoomModel();
				roomModel.setRoomNo(roomNo);
				this.rooms.add(roomModel);
			}
		}
		RoomModel tempRoom = this.rooms.get(Arrays.asList(roomNos)
				.indexOf(room));
		tempRoom.setId(id);
		tempRoom.setChked(true);
	}

}
