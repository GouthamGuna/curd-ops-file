package in.dev.gmsk.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import in.dev.gmsk.model.JDBCModel;
import in.dev.gmsk.model.StudentModel;

public class StudentRepository {

	public Stream<StudentModel> getAllStudent() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<StudentModel> returnList = new ArrayList<>();
		try {

			connection = JDBCConnection.getConnection(JDBCModel.getJDBCModel());
			preparedStatement = connection.prepareStatement(
					"SELECT `id`, CONCAT(`firstname`,' ',`lastname`) AS stuName, `dateofbirth`, `gender`, `bloodgroup` FROM `student_registration`");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StudentModel model = new StudentModel();
				model.setId(resultSet.getInt("id"));
				model.setStudentName(resultSet.getString("stuName"));
				model.setDob(resultSet.getString("dateofbirth"));
				returnList.add(model);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnList.parallelStream();
	}

}
