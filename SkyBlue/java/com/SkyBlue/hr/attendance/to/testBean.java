package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Data;

@Dataset(name="dsTest")
public class testBean extends BaseBean{
	private String empCode;
	private String empName ;
	private String deptCode;
	private String positionCode;
	private String hireDate;
	private String passWord;
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmpCode() {
		return empCode;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	

	@Override
	public String toString() {
		return "testBean [empCode=" + empCode + ", empName=" + empName + ", deptCode=" + deptCode
				+ ", positionCode=" + positionCode + ", hireDate=" + hireDate + ", passWord=" +passWord+"]";
	}
}
