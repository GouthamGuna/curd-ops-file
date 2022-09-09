package com.cerp.example.action;

public class EmployeesVo {
	
	private String primaryId;
	private String EmpId;
	private String Empname;
	private String Empsalary;
	
	public String getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public String getEmpsalary() {
		return Empsalary;
	}
	public void setEmpsalary(String empsalary) {
		Empsalary = empsalary;
	}
	
}
