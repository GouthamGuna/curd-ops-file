package in.dev.gmsk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import in.dev.gmsk.service.StudentService;
import in.dev.gmsk.serviceImpl.StudentServiceImpl;

@Controller
public class StudentController {

	private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();
	private static final Gson GSON = new Gson();

	public StudentService service = new StudentServiceImpl();

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentByName(ModelMap model, @RequestParam String name) {
		logger.info("Innside getStudentByName Method If Loop {} ...", name);
		if (name != null && !name.isEmpty() && !name.isBlank()) {
			model.put("student_service", GSON.toJson(STUDENT_SERVICE.retrieveStudentList(name)));
		}

		return "student";
	}

	@RequestMapping(value = "/allstudent", method = RequestMethod.GET)
	@ResponseBody
	public String getAllStudent() {
		logger.info("Innside getAllStudent Method...");

		return GSON.toJson(service.getAllStudent().toList());
	}
}
