package net.guesthouse.roi;

import javax.servlet.http.HttpSession;

import net.guesthouse.roi.dao.UserDao;
import net.guesthouse.roi.dto.model.UserModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private UserDao userDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserModel userModel, Model model, HttpSession session) {
		UserModel logedUser = userDao.selectUser(userModel);
		if (logedUser != null) {
			session.setAttribute("userId", logedUser.getId());
			model.addAttribute("logedUser", logedUser);
			return "redirect:dashboard.roi";
		}
		model.addAttribute("loginFail", "fail");
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "home";
	}

}
