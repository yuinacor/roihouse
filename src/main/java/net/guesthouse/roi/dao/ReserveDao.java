package net.guesthouse.roi.dao;

import java.util.List;

import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.ReserveModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDao {
	private static final String namespace = "net.guesthouse.roi.ReserveModel.";

	@Autowired
	private CommonDAO commonDao;

	public int insertReserve(ReserveModel reserveModel) {
		return commonDao.insert(namespace + "insertReserve", reserveModel);
	}

	public int updateReserve(ReserveModel reserveModel) {
		return commonDao.update(namespace + "updateReserve", reserveModel);
	}

	public int deleteReserve(ReserveModel reserveModel) {
		return commonDao.delete(namespace + "deleteReserve", reserveModel);
	}

	public List<ReserveModel> selectReserve(ReserveModel reserveModel) {
		return commonDao.selectList(namespace + "selectReserve", reserveModel);
	}

	public ReserveModel selectReserveById(ReserveModel reserveModel) {
		return commonDao.selectOne(namespace + "selectReserveById",
				reserveModel);
	}

	public List<ReserveModel> selectReserveList(DashboardTimeModel timeModel) {
		return commonDao.selectList(namespace + "selectReserveList", timeModel);
	}

	public List<ReserveModel> selectCalender(DashboardTimeModel timeModel) {
		return commonDao.selectList(namespace + "selectCalender", timeModel);
	}

}
