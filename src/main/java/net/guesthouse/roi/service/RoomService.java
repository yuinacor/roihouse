package net.guesthouse.roi.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.guesthouse.roi.dto.model.CalenderModel;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.ReserveModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

	private static Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

	public final long ONE_DAY = 1000 * 60 * 60 * 24;
	public final long NINE_HOUR = 9 * 60 * 60 * 1000;

	public List<CalenderModel> makeCalender(DashboardTimeModel timeModel,
			List<ReserveModel> reserveModels) {

		Timestamp start = timeModel.getStart();
		Timestamp end = timeModel.getEnd();
		Timestamp now = start;

		// LOGGER.debug("start : {}, end : {}", start, end);

		// reserveModels = correctTimestamp(reserveModels);

		List<CalenderModel> models = new ArrayList<CalenderModel>();

		Map<Long, CalenderModel> map = calenderListMaker(reserveModels);

		while (now.getTime() < end.getTime()) {

			long nowTime = now.getTime();

			// LOGGER.info("containsKey - {} : {}", nowTime,
			// map.containsKey(nowTime));

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
				caModel.putRooms(reserve.getId(), reserve.getRoomNo(),
						reserve.getrName());
				calenderMap.put(chkin + ONE_DAY * i, caModel);
			}
		}

		// test
		// for (long key : calenderMap.keySet()) {
		//
		// CalenderModel data = calenderMap.get(key);
		//
		// LOGGER.info("key : {}, data : {}", key, data);
		// LOGGER.info("room length : {} ", data.getRooms().size());
		// for (RoomModel room : data.getRooms()) {
		// LOGGER.info("rooms : {}", room.getRoomNo());
		// }
		//
		// }

		return calenderMap;
	}

}
