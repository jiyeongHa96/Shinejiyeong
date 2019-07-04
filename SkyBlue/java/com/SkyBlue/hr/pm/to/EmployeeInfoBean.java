package com.SkyBlue.hr.pm.to;

import java.util.List;

import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

public class EmployeeInfoBean extends BaseBean{
	@Setter
	@Getter
	private List<EmpInfoBean> empInfoList;
	@Setter
	@Getter
	private List<WorkInfoBean> workInfoList;
	@Setter
	@Getter
	private List<FamilyInfoBean> familyInfoList;
	@Setter
	@Getter
	private List<LicenseInfoBean> licenseInfoList;
	@Setter
	@Getter
	private List<EducationInfoBean> educationInfoList;
	@Setter
	@Getter
	private List<SalInfoBean> salInfoList;

}
