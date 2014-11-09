package net.guesthouse.roi.dao;

import java.util.List;

import net.guesthouse.roi.reserve.ReserveRoom;

import org.springframework.beans.factory.annotation.Autowired;

public class ReserveRoomDao {
	private static final String namespace = "net.guesthouse.roi.reserveRoom.";

	@Autowired
	private CommonDAO commonDao;

	public void insertReserveRooms(List<ReserveRoom> reserveRooms) {
		commonDao.insert(namespace + "insertReserveRooms", reserveRooms);
	}

	public void insertReserveRoom(ReserveRoom reserveRoom) {
		commonDao.insert(namespace + "insertReserveRoom", reserveRoom);
	}

	public void updateReserveRoom(ReserveRoom reserveRoom) {
		commonDao.update(namespace + "updateReserveRoom", reserveRoom);
	}

	public void deleteReserveRoom(ReserveRoom reserveRoom) {
		commonDao.delete(namespace + "deleteReserveRoom", reserveRoom);
	}

	public void deleteReserve(int reserveId) {
		commonDao.delete(namespace + "deleteAll", reserveId);
	}

	public List<ReserveRoom> selectReserveRoomsByReserveId(int reserveId) {
		return commonDao.selectList(namespace + "selectReserveRoom", reserveId);
	}

	public ReserveRoom selectReserveRoomById(int id) {
		return commonDao.selectOne(namespace + "selectReserveRoomById", id);
	}

}
