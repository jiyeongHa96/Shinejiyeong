package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsSalPaymentDate")
public class SalPaymentDateBean extends BaseBean{
	@Setter
	@Getter
	private String paymentDate,inputedYearMonth,jikjongCode,targetChoice;
	@Setter
	@Getter
	private String sameTimeSelection,payType,salaryTypeCode,note;

}
