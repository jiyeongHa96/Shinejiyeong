package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsEmployeeHiredateList")
public class EmployeeHireDateBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,password,empName,authorityCode,deptCode,positionCode,hireDate;
}
