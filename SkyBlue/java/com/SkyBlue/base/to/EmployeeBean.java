package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsEmployee")
public class EmployeeBean extends BaseBean{
	@Getter
	@Setter
	private String empCode,empName,password,authorityCode,deptCode,positionCode,businessCode;
}
