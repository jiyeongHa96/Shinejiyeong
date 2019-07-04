package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsOverNight")
public class OverNightReportBean extends BaseBean{
	@Setter
	@Getter
	private String overNightSeq,basicDay,empCode,empName,approvalStatus,requestStatus,type;
	@Setter
	@Getter
	private String requestDate,fromTime,toTime;

}