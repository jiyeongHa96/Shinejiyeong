package com.SkyBlue.hr.pm.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsWorkInfo")
public class WorkInfoBean extends BaseBean {
	@Setter
	@Getter
	private String hireDate,retireDate,employeementTypeCode,retireCause,probationStatus,probationExpireDate;
	@Setter
	@Getter
	private String projectCode,jikjongCode,empCode,empName;

}
