package net.guesthouse.roi.service;

import net.guesthouse.roi.dao.ReserverDao;
import net.guesthouse.roi.reserve.user.ReservedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserverServiceImpl implements ReserverService {

	@Autowired
	private ReserverDao reserverDao;

	@Override
	public void save(ReservedUser reserverModel) {
		reserverDao.insertReserver(reserverModel);
	}

}
