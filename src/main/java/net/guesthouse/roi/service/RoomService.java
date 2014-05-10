package net.guesthouse.roi.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.guesthouse.roi.DashBoardContoller;
import net.guesthouse.roi.dto.model.CalenderModel;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.RoomModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

	private static Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

	public final long ONE_DAY = 1000 * 60 * 60 * 24;
	public final String[] roomNos = { "201", "202", "203", "301", "302", "303",
			"401", "402", "dm1", "dm2", "dm3", "dm4", "dm5", "df1", "df2",
			"df3", "df4", "df5" };

	public List<CalenderModel> makeCalender(DashboardTimeModel timeModel,
			List<RoomModel> roomModels) {

		Timestamp start = timeModel.getStart();
		Timestamp end = timeModel.getEnd();
		Timestamp now = start;

		LOGGER.debug("start : {}, end : {}", start, end);

		List<CalenderModel> models = new ArrayList<CalenderModel>();

		while (now.getTime() < end.getTime()) {
			CalenderModel calenderModel = new CalenderModel();
			calenderModel.setCalenderDate((Timestamp) now.clone());
			calenderModel.setRooms(roomFilter(now, roomModels));
			models.add(calenderModel);
			now.setTime(now.getTime() + ONE_DAY);
		}
		return models;
	}

	private boolean roomComparator(Timestamp time, RoomModel roomModel) {
		if (time.getTime() == roomModel.getChkin().getTime()) {
			return true;
		} else {
			return false;
		}
	}

	private List<RoomModel> roomFilter(Timestamp time,
			List<RoomModel> roomModels) {
		List<RoomModel> list = new ArrayList<RoomModel>();
		for (RoomModel room : roomModels) {
			if (roomComparator(time, room)) {
				list.add(room);
			}
		}
		return list;
	}
}
