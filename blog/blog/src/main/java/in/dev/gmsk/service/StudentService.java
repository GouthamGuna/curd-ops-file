package in.dev.gmsk.service;

import java.util.List;

import in.dev.gmsk.model.StudentModel;

public interface StudentService {

	List<StudentModel> retrieveStudentList(String user);
}
