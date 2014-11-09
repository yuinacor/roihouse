package net.guesthouse.roi.dao;

import net.guesthouse.roi.reserve.user.ReservedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserverDao {
	private static final String namespace = "net.guesthouse.roi.ReserverModel.";

	@Autowired
	private CommonDAO commonDao;

	public int insertReserver(ReservedUser reserverModel) {
		return commonDao.insert(namespace + "insertReserver", reserverModel);
	}

	public void updateReserver(ReservedUser reserverModel) {
		commonDao.update(namespace + "updateReserver", reserverModel);
	}

	public ReservedUser selectReserver(ReservedUser reserverModel) {
		return commonDao.selectOne(namespace + "selectReserver", reserverModel);
	}
}
