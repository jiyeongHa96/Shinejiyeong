package com.SkyBlue.hr.attendance.applicationService;

import java.util.List;
import java.util.Map;

import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdOutingBean;
import com.SkyBlue.hr.attendance.to.DailyAttdRestBean;
import com.SkyBlue.hr.attendance.to.testBean;

public interface DailyAttdRestAppService {
	public List<DailyAttdRestBean> findAttdRestList(String empCode);
	
	public List<DailyAttdRestBean> addDailyAttdRest(DailyAttdRestBean dailyAttdRestBean);
	
	public List<DailyAttdRestBean> findAttdRestListByCondition(Map<String,Object> map);	
	
	public List<DailyAttdRestBean> findUnApprovedDailyAttdRestList(String basicDay);
	
	public void batchDailyAttdRest(List<DailyAttdRestBean> dailyAttdRestList);
	
	public void addDailyAttdOuting(DailyAttdOutingBean dailyAttdOutingBean);

	public List<DailyAttdOutingBean> findDailyAttdOutingList(String empCode,String fromDate,String toDate);
	
	public void batchDailyAttdOuting(List<DailyAttdOutingBean> dailyAttdOutingList);
	//홍테스트
	public List<testBean> testEmp(String empName);
	public void batchEmpTest(List<testBean> testListBean);
}
