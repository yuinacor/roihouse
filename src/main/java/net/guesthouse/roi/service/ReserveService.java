package net.guesthouse.roi.service;

import java.util.List;

import net.guesthouse.roi.dao.ReserveDao;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.reserve.Reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {

	@Autowired
	private ReserveDao reserveDao;

	public void save(Reserve reserveModel) {

		reserveDao.insertReserve(reserveModel);
	}

	public List<Reserve> findByTimeModel(DashboardTimeModel timeModel) {
		return reserveDao.selectReserveList(timeModel);
	}

	public List<Reserve> getCalender(DashboardTimeModel timeModel) {
		return reserveDao.selectCalender(timeModel);
	}

	public Reserve findById(int id) {

		return reserveDao.selectReserveById(makeEmptyModel(id));
	}

	public void delete(int id) {

		reserveDao.deleteReserve(makeEmptyModel(id));
	}

	private Reserve makeEmptyModel(int id) {
		Reserve model = new Reserve();
		model.setId(id);
		return model;
	}

	public void update(Reserve reserveModel) {
		reserveDao.updateReserve(reserveModel);
	}

}
