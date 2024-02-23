package in.dev.gmsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import in.dev.gmsk.service.StudentService;
import in.dev.gmsk.serviceImpl.StudentServiceImpl;

@Controller
public class StudentController {

	private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();
	private static final Gson GSON = new Gson();

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentByName(ModelMap model, @RequestParam String name) {

		if (name != null && !name.isEmpty() && !name.isBlank()) {
			model.put("student_service", GSON.toJson(STUDENT_SERVICE.retrieveStudentList(name)));
		}

		return "student";
	}
}
