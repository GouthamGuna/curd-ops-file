package in.dev.gmsk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

	private int id;
	private String studentName;
	private String dob;
	private String mobileNo;
	private String emailId;
	private String fatherName;
	private String motherName;
	private String fatherMobileNo;
	private String fatherEmailId;
}
