package com.SkyBlue.hr.attendance.dao;

import java.util.List;
import java.util.Map;

import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdReportBean;
import com.SkyBlue.hr.attendance.to.MonthAttdReportBean;
import com.SkyBlue.hr.attendance.to.OverNightReportBean;

public interface AttdReportDAO {
	
	public List<OverNightReportBean> selectOverNightReport(Map<String,String> map);
	
	public void updateRequestStatus(OverNightReportBean overNightReportBean);
	
	public List<DailyAttdReportBean> selectApprovalDailyAttdReport(Map<String,String> map);
	
	public void updateDailyAttdCloseYN(Map<String,Object> map);
	
	/*미마감 내역 생성 */
	public Map<String, Object> createDailyAttdReport(Map<String,Object> map);
	/*생성된 일근태 미마간 내역을 호출함 바로 위에서 생성(프로시저)*/
	public List<DailyAttdReportBean> selectDailyAttdReportByDate(Map<String,Object> map);
	
	//연장 심야 승인
	public List<OverNightReportBean> selectOverNightReportByCondition(Map<String, Object> map);
	
	public void updateApprovalStatus(OverNightReportBean overNightReportBean);
	
	public void insertOverNightReport(OverNightReportBean overNightReportBean);

	public void deleteOverNightReport(OverNightReportBean overNightReportBean);
	
	
	
	//월근태 미마감 항목조회
	public List<DailyAttdReportBean> selectUnClosedDailyAttdReport(Map<String,Object> map);
	
	//월근태 계산 프로시저
	public Map<String, Object> createMonthAttdReport(Map<String,Object> map);
	
	//계산한 항목 호출 
	public List<MonthAttdReportBean> selectMonthlyAttdReportByYearMonth(Map<String,Object> map);
	
	// 월근태 마감 
	public void updateMonthAttdCloseYN(Map<String,String> map);
	
	// 월근태 마감 내역 조회 
	public List<MonthAttdReportBean> selectClosedMonthAttdReport(Map<String,Object> map);
	
}