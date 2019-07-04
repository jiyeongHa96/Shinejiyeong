package com.SkyBlue.hr.attendance.applicationService;

import java.util.List;

import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdBean;

public interface DailyAttdAppService {
	public List<DailyAttdBean> findDailyAttdList(String empCode,String fromDate,String toDate);	

	public List<DailyAttdBean> addDailyAttd(DailyAttdBean dailyAttdBean);
	
	public List<DailyAttdBean> findDailyAttdListByCondition(ConditionBean conditionBean);
	public List<DailyAttdBean> findDailyAttdListByInfo(ConditionBean conditionBean);
	public List<DailyAttdBean> findUnApprovedDailyAttdList(String basicDay);
	
	
	public void batchDailyAttd(List<DailyAttdBean> dailyAttdList);
	public void deleteDailyAttdList(String empCode, String basicDay);

	
}
