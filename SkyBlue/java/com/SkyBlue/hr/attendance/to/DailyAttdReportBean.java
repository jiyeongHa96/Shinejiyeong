package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsDailyAttdReport")
public class DailyAttdReportBean extends BaseBean{
	@Setter
	@Getter
	private String deptCode;
	@Setter
	@Getter
	private String empCode;
	@Setter
	@Getter
	private String basicDay;
	@Setter
	@Getter
	private String daily;
	@Setter
	@Getter
	private String attendTime;
	@Setter
	@Getter
	private String attendTypeCode;
	@Setter
	@Getter
	private String quitTime;
	@Setter
	@Getter
	private String quitTypeCode;
	@Setter
	@Getter
	private String privateLeaveHour;
	@Setter
	@Getter
	private String officialLeaveHour;
	@Setter
	@Getter
	private String workHour;	
	@Setter
	@Getter
	private String lateHour;
	@Setter
	@Getter
	private String overWorkHour;
	@Setter
	@Getter
	private String nightWorkHour;
	@Setter
	@Getter
	private String closeYn;
	@Setter
	@Getter
	private String attdDayType;
	@Setter
	@Getter
	private String earlyLeaveTime;
	@Setter
	@Getter
	private String empName;

}
