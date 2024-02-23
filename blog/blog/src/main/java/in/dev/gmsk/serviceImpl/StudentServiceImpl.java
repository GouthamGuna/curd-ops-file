package in.dev.gmsk.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import in.dev.gmsk.model.StudentModel;
import in.dev.gmsk.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private static List<StudentModel> studentData = new ArrayList<StudentModel>();
	//private static int todoCount = 3;

	static {

		studentData.add(new StudentModel(1,"Saran", "24.6.1998", "0987654321", 
				"saran@gmsk.com", "sunmugam", "-", "9393939495", "sunmugam@gmail.com"));

		studentData.add(new StudentModel(2,"Main", "15.11.1998", "12345654321", 
				"main@gmsk.com", "sunmugam", "-", "9393322495", "sekar@gmail.com"));

		studentData.add(new StudentModel(3,"karan", "24.7.1998", "0987622221", 
				"karan@gmsk.com", "sunmugam", "-", "9393dss25", "guna@gmsk.com"));
	}

	@Override
	public List<StudentModel> retrieveStudentList(String user) {

		List<StudentModel> filteredStudents = new ArrayList<StudentModel>();

		/*
		 *  int[] array = {1, 2, 3, 4, 5};
		 *	Arrays.stream(array).forEach(System.out::println);
		 * 
		 * */


		/*for (StudentModel runner : studentData) {

			if (runner.getStudentName().equals(user))
				filteredStudents.add(runner);

		}*/

		studentData.stream()
		.filter(runner -> runner.getStudentName()
				.equals(user))
		.forEach(filteredStudents::add);

		return filteredStudents;
	}

}
