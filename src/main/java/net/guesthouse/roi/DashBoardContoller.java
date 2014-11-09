package net.guesthouse.roi;

import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.reserve.Reserve;
import net.guesthouse.roi.reserve.user.ReservedUser;
import net.guesthouse.roi.service.ReserveService;
import net.guesthouse.roi.service.ReserverService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashBoardContoller {

	@Autowired
	ReserveService reserveService;

	@Autowired
	ReserverService reserverService;

	private static Logger LOGGER = LoggerFactory
			.getLogger(DashBoardContoller.class);

	@RequestMapping(value = "/dashboard.roi", method = RequestMethod.GET)
	public String dashBoard(Model model) {

		return "dashboard";
	}

	@RequestMapping(value = "/inputform.roi", method = RequestMethod.GET)
	public String inputform(Model model) {

		return "inputform";
	}

	@RequestMapping(value = "/selectReserveList.roi", method = RequestMethod.POST)
	public @ResponseBody
	Object selectReserveList(@RequestBody DashboardTimeModel timeModel) {

		return reserveService.findByTimeModel(timeModel);
	}

	@RequestMapping(value = "/postInputForm.roi", method = RequestMethod.POST)
	public @ResponseBody
	void postInputForm(@RequestBody Reserve reserve) {

		// TODO
		// insert reserve, and generated reservedRoom
	}

	@RequestMapping(value = "/insertReserve.roi", method = RequestMethod.POST)
	public @ResponseBody
	void insertReserve(@RequestBody Reserve reserveModel) {

		reserveService.save(reserveModel);

	}

	@RequestMapping(value = "/insertReserver.roi", method = RequestMethod.POST)
	public @ResponseBody
	void insertReserver(@RequestBody ReservedUser reserverModel) {
		reserverService.save(reserverModel);
	}
}
