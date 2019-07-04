package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsAnnual")
public class AnnualBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,standardYear,restDays,usableDays,usedDays,lengthOfService;
}
