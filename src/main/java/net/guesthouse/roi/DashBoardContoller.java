package net.guesthouse.roi;


import net.guesthouse.roi.dto.model.ReserveModel;
import net.guesthouse.roi.dto.model.ReserverModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DashBoardContoller {

	@Autowired
	private ReserveModel reserveModel;
	@Autowired
	private ReserverModel reserverModel;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashBoard(Model model) {

		return "dashboard";
	}
}
