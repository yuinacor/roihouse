package net.guesthouse.roi;

import java.util.List;

import net.guesthouse.roi.dto.model.CalenderModel;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.reserve.Reserve;
import net.guesthouse.roi.service.ReserveRoomService;
import net.guesthouse.roi.service.ReserveService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//TODO
//need exception handler
//need reserveRoom business logic
@Controller
public class CalenderController {

	@Autowired
	private ReserveService reserveService;

	@Autowired
	private ReserveRoomService reserveRoomService;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CalenderController.class);

	@RequestMapping(value = "/calender.roi", method = RequestMethod.GET)
	public String Calender() {
		return "calender";
	}

	@RequestMapping(value = "/selectCalender.roi", method = RequestMethod.POST)
	public @ResponseBody
	List<CalenderModel> selectCalender(@RequestBody DashboardTimeModel timeModel) {
		// TODO
		// get page of calender(1 month)
		return null;
	}

	@RequestMapping(value = "/selectReserveById.roi", method = RequestMethod.GET)
	public @ResponseBody
	Reserve selectReserveById(int id) {

		return reserveService.findById(id);
	}

	@RequestMapping(value = "/deleteReserve.roi", method = {
			RequestMethod.DELETE, RequestMethod.GET })
	public @ResponseBody
	void deleteReserve(int id) {
		reserveService.delete(id);
	}

	@RequestMapping(value = "/updateReserve.roi", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody
	void updateReserve(@RequestBody Reserve reserve) {
		reserveService.update(reserve);
	}
}
