package in.dev.gmsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/welcome")
	@ResponseBody
	public String sayHello() {
		return "Hello World dummy";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		model.put("name", name);
		return "welcome";
	}
}
