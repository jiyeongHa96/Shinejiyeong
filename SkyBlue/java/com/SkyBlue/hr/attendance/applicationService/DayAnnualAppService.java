package com.SkyBlue.hr.attendance.applicationService;

import java.util.List;

import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DayAnnualBean;

public interface DayAnnualAppService {
	public List<DayAnnualBean> findAnnualMgt(String empCode,String standardYear);
	
	public List<DayAnnualBean> addDayAnnual(DayAnnualBean dayAnnulBean);
	
	public List<DayAnnualBean> findDayAnnualListByCondition(String deptCode,String empCode,String fromDate,String toDate,String approvalStatus);

	public void batchDayAnnual(List<DayAnnualBean> dayAnnualList);
	
}
