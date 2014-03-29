package net.guesthouse.roi;

import net.guesthouse.roi.dao.ReserveDao;
import net.guesthouse.roi.dao.ReserverDao;
import net.guesthouse.roi.dto.model.ReserveModel;
import net.guesthouse.roi.dto.model.ReserverModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashBoardContoller {

	@Autowired
	ReserveDao reserveDao;
	@Autowired
	ReserverDao reserverDao;

	@RequestMapping(value = "/dashboard.roi", method = RequestMethod.GET)
	public String dashBoard(Model model) {

		return "dashboard";
	}

	@RequestMapping(value = "/inputform.roi", method = RequestMethod.GET)
	public String inputform(Model model) {

		return "inputform";
	}

	@RequestMapping(value = "/insertReserve", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody Object
	insertReserve(@RequestBody ReserveModel reserveModel) {
		int result = reserveDao.insertReserve(reserveModel);
		
		if(result < 0) {
			return false;
		}
		return true;
	}
}
