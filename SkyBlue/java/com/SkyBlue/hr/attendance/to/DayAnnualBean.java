package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsDayAnnual")
public class DayAnnualBean extends BaseBean{
	@Setter
	@Getter
	private String dayAnnualSeq,empCode,startDate,endDate,causeCode,detailCause;
	@Setter
	@Getter
	private String standardYear,annualCode,days,empName,approvalStatus;
}
