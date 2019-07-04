package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsMonthAttdReport")
public class MonthAttdReportBean extends BaseBean{
	@Setter
	@Getter
	private String deptCode,basicYearMonth,empCode,basicWorkHour,workHour,overWorkHour;
	@Setter
	@Getter
	private String nightWorkHour,basicWorkDays,weekdayWork,holidayWorkDays,holidayWorkHour;
	@Setter
	@Getter
	private String holidayOverWorkHour,holidayNightWorkHour,absentDays,lateDays,lateHour;
	@Setter
	@Getter
	private String leaveEarlyDays,leaveDays,closeYn,attdRestDays,empName,privateLeaveHour;
	@Setter
	@Getter
	private String officialLeaveHour,holidayLeaveDays,holidayPrivateLeaveHour,holidayOfficialLeaveHour;

}
