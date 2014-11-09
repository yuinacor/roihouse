package net.guesthouse.roi.dao;

import java.util.List;

import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.reserve.Reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDao {
	private static final String namespace = "net.guesthouse.roi.reserve.";

	@Autowired
	private CommonDAO commonDao;

	public int insertReserve(Reserve reserve) {
		return commonDao.insert(namespace + "insertReserve", reserve);
	}

	public int updateReserve(Reserve reserve) {
		return commonDao.update(namespace + "updateReserve", reserve);
	}

	public int deleteReserve(Reserve reserve) {
		return commonDao.delete(namespace + "deleteReserve", reserve);
	}

	public List<Reserve> selectReserve(Reserve reserve) {
		return commonDao.selectList(namespace + "selectReserve", reserve);
	}

	public Reserve selectReserveById(Reserve reserve) {
		return commonDao.selectOne(namespace + "selectReserveById", reserve);
	}

	public List<Reserve> selectReserveList(DashboardTimeModel timeModel) {
		return commonDao.selectList(namespace + "selectReserveList", timeModel);
	}

	public List<Reserve> selectCalender(DashboardTimeModel timeModel) {
		return commonDao.selectList(namespace + "selectCalender", timeModel);
	}

}
