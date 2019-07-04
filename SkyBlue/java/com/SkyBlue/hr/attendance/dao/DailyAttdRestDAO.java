package com.SkyBlue.hr.attendance.dao;



import java.util.List;
import java.util.Map;

import com.SkyBlue.hr.attendance.to.DailyAttdOutingBean;
import com.SkyBlue.hr.attendance.to.DailyAttdRestBean;
import com.SkyBlue.hr.attendance.to.testBean;

public interface DailyAttdRestDAO {
	public List<DailyAttdRestBean> selectAttdRestList(String empCode);
	
	public void insertDailyAttdRest(DailyAttdRestBean dailyAttdRestBean);
	public void updateDailyAttdRest(DailyAttdRestBean dailyAttdRestBean);
	public void deleteDailyAttdRest(DailyAttdRestBean dailyAttdRestBean);
	
	public List<DailyAttdRestBean> selectAttdRestListByCondition(Map<String,Object> map);
	public List<DailyAttdRestBean> selectUnApprovedDailyAttdRestList(String basicDay);
	public List<DailyAttdOutingBean> selectDailyAttdOutingList(Map<String,String> map);

	public void insertDailyAttdOuting(DailyAttdOutingBean dailyAttdOutingBean);
	public void updateDailyAttdOuting(Map<String, String> map);
	public void deleteDailyAttdOuting(DailyAttdOutingBean dailyAttdOutingBean);
	
	//홍 테스트
	public List<testBean> selectTestEmpInfo(String empName);
	//홍 테스트 일괄 삭제
	public void deleteTestEmpInfo(testBean testBean);
	//홍 테스트 일괄 추가
	public void insertTestEmpINfo(testBean testBean);
	//홍 테스트 일괄 수정
	public void updateTestEmpINfo(testBean testBean);
	
}
