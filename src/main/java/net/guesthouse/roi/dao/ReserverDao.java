package net.guesthouse.roi.dao;

import net.guesthouse.roi.dto.model.ReserverModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserverDao {
	private static final String namespace = "net.guesthouse.roi.ReserverModel.";

	@Autowired
	private CommonDAO commonDao;

	public int insertReserver(ReserverModel reserverModel) {
		return commonDao.insert(namespace + "insertReserver", reserverModel);
	}

	public void updateReserver(ReserverModel reserverModel) {
		commonDao.update(namespace + "updateReserver", reserverModel);
	}

	public ReserverModel selectReserver(ReserverModel reserverModel) {
		return commonDao.selectOne(namespace + "selectReserver", reserverModel);
	}
}
