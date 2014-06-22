package net.guesthouse.roi;

import java.util.List;

import net.guesthouse.roi.dao.ReserveDao;
import net.guesthouse.roi.dto.model.CalenderModel;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.ReserveModel;
import net.guesthouse.roi.service.RoomService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalenderController {

	@Autowired
	RoomService roomService;

	@Autowired
	ReserveDao reserveDao;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CalenderController.class);

	@RequestMapping(value = "/calender.roi", method = RequestMethod.GET)
	public String Calender() {
		return "calender";
	}

	@RequestMapping(value = "/selectCalender.roi", method = RequestMethod.POST)
	public @ResponseBody
	List<CalenderModel> selectCalender(@RequestBody DashboardTimeModel timeModel) {
		List<ReserveModel> reserveModels = reserveDao.selectCalender(timeModel);
		return roomService.makeCalender(timeModel, reserveModels);
	}

	@RequestMapping(value = "/selectReserveById.roi", method = RequestMethod.GET)
	public @ResponseBody
	ReserveModel selectReserveById(int id) {

		ReserveModel reserveModel = new ReserveModel();
		reserveModel.setId(id);
		return reserveDao.selectReserveById(reserveModel);
	}

	@RequestMapping(value = "/deleteReserve.roi", method = {
			RequestMethod.DELETE, RequestMethod.GET })
	public @ResponseBody
	boolean deleteReserve(int id) {
		ReserveModel model = new ReserveModel();
		model.setId(id);
		int result = reserveDao.deleteReserve(model);
		if (result != 1)
			return false;
		return true;
	}

	@RequestMapping(value = "/updateReserve.roi", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody
	boolean updateReserve(@RequestBody ReserveModel reserve) {
		int result = reserveDao.updateReserve(reserve);
		if (result != 1)
			return false;
		return true;
	}
}
