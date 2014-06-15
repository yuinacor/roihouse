package net.guesthouse.roi.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.guesthouse.roi.DashBoardContoller;
import net.guesthouse.roi.dto.model.CalenderModel;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.ReserveModel;
import net.guesthouse.roi.dto.model.RoomModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

	private static Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

	public final long ONE_DAY = 1000 * 60 * 60 * 24;
	public final long NINE_HOUR = 9 * 60 * 60  * 1000;
	public final String[] roomNos = { "201", "202", "203", "301", "302", "303",
			"401", "402", "dm1", "dm2", "dm3", "dm4", "dm5", "df1", "df2",
			"df3", "df4", "df5" };

	public List<CalenderModel> makeCalender(DashboardTimeModel timeModel,
			List<ReserveModel> reserveModels) {

		Timestamp start = timeModel.getStart();
		Timestamp end = timeModel.getEnd();
		Timestamp now = start;

//		LOGGER.debug("start : {}, end : {}", start, end);

//		 reserveModels = correctTimestamp(reserveModels);

		List<CalenderModel> models = new ArrayList<CalenderModel>();

		Map<Long, CalenderModel> map = calenderListMaker(reserveModels);

		while (now.getTime() < end.getTime()) {

			long nowTime = now.getTime();

//			LOGGER.info("containsKey - {} : {}", nowTime,
//					map.containsKey(nowTime));
			
			CalenderModel calenderModel = null;
			if (map.containsKey(nowTime)) {
				calenderModel = map.get(nowTime);
			} else {
				calenderModel = new CalenderModel();
			}
			calenderModel.setCalenderDate((Timestamp) now.clone());
			models.add(calenderModel);
			now.setTime(now.getTime() + ONE_DAY);
		}
		return models;
	}

	private List<ReserveModel> correctTimestamp(List<ReserveModel> models) {
		for (ReserveModel reserve : models) {
			reserve.getChkin().setTime(reserve.getChkin().getTime() + NINE_HOUR);
		}

		return models;
	}

	private Map<Long, CalenderModel> calenderListMaker(
			List<ReserveModel> reserveModels) {
		Map<Long, CalenderModel> calenderMap = new HashMap<Long, CalenderModel>();

		for (ReserveModel reserve : reserveModels) {
			for (int i = 0; i < reserve.getNights(); i++) {
				CalenderModel caModel = null;
				long chkin = reserve.getChkin().getTime();

				if (calenderMap.containsKey(chkin + ONE_DAY * i)) {
					caModel = calenderMap.get(chkin + ONE_DAY * i);
				} else {
					caModel = new CalenderModel();
				}
				caModel.putRooms(reserve.getId(), reserve.getRoomNo());
				calenderMap.put(chkin + ONE_DAY * i, caModel);
			}
		}

		// test
//		for (long key : calenderMap.keySet()) {
//
//			CalenderModel data = calenderMap.get(key);
//
//			LOGGER.info("key : {}, data : {}", key, data);
//			LOGGER.info("room length : {} ", data.getRooms().size());
//			for (RoomModel room : data.getRooms()) {
//				LOGGER.info("rooms : {}", room.getRoomNo());
//			}
//
//		}

		return calenderMap;
	}

	private List<RoomModel> roomFilter(Timestamp time,
			List<ReserveModel> reserveModels) {
		List<RoomModel> list = new ArrayList<RoomModel>();
		for (ReserveModel reserve : reserveModels) {
			for (int i = 0; i < reserve.getNights(); i++) {
			}
		}
		return list;
	}
}
