package in.dev.gmsk.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.dev.gmsk.model.StudentModel;
import in.dev.gmsk.service.StudentService;

class TestStudentServiceImpl {
	private static final StudentService SERVICE = new StudentServiceImpl();
	
	@Test
	void test() {
		List<StudentModel> studentData = SERVICE.retrieveStudentList("karan");
		assertNotNull(studentData);
		System.out.println("studentData : "+studentData);
	}

}
