package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsOuting")
public class DailyAttdOutingBean extends BaseBean {
	@Setter
	@Getter
	private String goingoutSeq,empCode,empName,deptCode,etcSal,plusCost,cause,basicDay;
	@Setter
	@Getter
	private String requestTime,approvalStatus,status2,attdType;
}
