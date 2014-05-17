package net.guesthouse.roi;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import net.guesthouse.roi.dao.ReserveDao;
import net.guesthouse.roi.dto.model.CalenderModel;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.RoomModel;
import net.guesthouse.roi.service.RoomService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@RequestMapping(value = "/selectCalender", method = RequestMethod.POST)
	public @ResponseBody
	List<CalenderModel> selectCalender(@RequestBody DashboardTimeModel timeModel) {
		List<RoomModel> roomModels = reserveDao.selectCalender(timeModel);
		return roomService.makeCalender(timeModel, roomModels);
	}
}