package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsDailyAttd")
public class DailyAttdBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,empName,dayAttdSeq,basicDay,attdTypeCode,time,approvalStatus,cost,cause;

}
