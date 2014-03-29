package net.guesthouse.roi.dao;

import java.util.List;

import net.guesthouse.roi.dto.model.ReserveModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDao {
	private static final String namespace = "net.guesthouse.roi.ReserveModel.";

	@Autowired
	private CommonDAO commonDao;

	public void insertReserve(ReserveModel reservModel) {
		commonDao.insert(namespace + "insertReserve", reservModel);
	}

	public List<ReserveModel> selectReserve() {
		return commonDao.selectList(namespace + "selectReserve");
	}
}
