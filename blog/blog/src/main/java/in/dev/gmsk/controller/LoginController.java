package in.dev.gmsk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.dev.gmsk.service.LoginService;
import in.dev.gmsk.serviceImpl.LoginServiceImpl;

@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final LoginService SERVICE = new LoginServiceImpl();

	@RequestMapping(value = "/")
	public String sayGreeting() {
		logger.info("Innside sayGreeting Method...");
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		logger.info("Innside showLoginPage Method...");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		logger.info("Innside handleUserLogin Method...");
		if (!SERVICE.validateUser(name, password)) {
			logger.info("Innside handleUserLogin Method If Loop {} ...", name);
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		model.put("name", name);
		return "welcome";
	}
}
