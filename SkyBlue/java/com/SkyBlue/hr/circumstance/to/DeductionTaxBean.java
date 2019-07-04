package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Column;
import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsDeductionTax")
public class DeductionTaxBean extends BaseBean{
	@Setter
	@Getter
	private String inputedYear,healthInsurRate,nationalPenRate,longTermCareRate,employeementInsurRate;
}
