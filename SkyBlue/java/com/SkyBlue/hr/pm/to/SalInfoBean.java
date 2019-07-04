package com.SkyBlue.hr.pm.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsSalInfo")
public class SalInfoBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,hobong,salaryTypeCode,pensionType,nationalPension,healthInsurance;
	@Setter
	@Getter
	private String employeementInsurance,longTermCareInsurance,supportTwentyBelow,supportSixtyAbove;
	@Setter
	@Getter
	private String manyChildDeduction,accountCode,accountHolder,salTransBank;

}
