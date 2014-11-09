package net.guesthouse.roi.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.guesthouse.roi.dao.ReserveRoomDao;
import net.guesthouse.roi.reserve.Reserve;
import net.guesthouse.roi.reserve.ReserveRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReserveRoomService {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"YYYYMMdd");
	private static final long ONE_DAY = 24 * 60 * 60 * 1000;

	@Autowired
	private ReserveRoomDao roomDao;

	public List<ReserveRoom> createReserveRoom(Reserve reserve)
			throws Exception {

		if (reserve.getId() == 0) {
			// FIXME
			// create Error type
			throw new Exception();
		}

		Timestamp chkin = reserve.getChkin();
		// FIXME
		// really need?
		long time = simpleDateFormat.parse(simpleDateFormat.format(chkin))
				.getTime();

		List<ReserveRoom> reserveRooms = new ArrayList<ReserveRoom>();

		int index = 0;
		while (index < reserve.getNights()) {
			ReserveRoom room = new ReserveRoom();
			room.setReserveId(reserve.getId());
			room.setRoomNo(reserve.getRoomNo());
			room.setReservedDate(new Timestamp(time + index * ONE_DAY));

			reserveRooms.add(room);
		}
		return reserveRooms;
	}

	@Transactional
	public void save(List<ReserveRoom> reserveRooms) {
		roomDao.insertReserveRooms(reserveRooms);
	}

	@Transactional
	public void modify(ReserveRoom reserveRoom) {
		roomDao.updateReserveRoom(reserveRoom);
	}

	@Transactional
	public void delete(ReserveRoom reserveRoom) {
		roomDao.deleteReserveRoom(reserveRoom);
	}

	@Transactional
	public void delete(int reserveId) {
		roomDao.deleteReserve(reserveId);
	}

	public List<ReserveRoom> findReserveRoomByReserveId(int reserveId) {
		return roomDao.selectReserveRoomsByReserveId(reserveId);
	}

	public ReserveRoom findReserveRoomById(int id) {
		return roomDao.selectReserveRoomById(id);
	}

}
