package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Column;
import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsIncomeTax")
public class IncomeTaxBean extends BaseBean{
	@Setter
	@Getter
	private String inputedYear,incomeTaxRate,lowSal,highSal,progressiveDeduction;

}
