package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name = "dsDailyAttdRest")
public class DailyAttdRestBean extends BaseBean {
	@Setter
	@Getter
	private String empCode,attdRestSeq,attdRestCode,requestDate,startDate,endDate;
	@Setter
	@Getter
	private String days,cost,cause,approvalStatus,empName,otherSudang;
}
