package com.SkyBlue.hr.attendance.applicationService;

import java.util.List;
import java.util.Map;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdReportBean;
import com.SkyBlue.hr.attendance.to.MonthAttdReportBean;
import com.SkyBlue.hr.attendance.to.OverNightReportBean;

public interface AttdReportAppService {
	//연장 심야 신청 리스트 
	public List<OverNightReportBean> findOverNightReport(String empCode,String fromDate,String toDate);
	//연장심야 일괄 신청
	public void updateRequestStatus(List<OverNightReportBean> overNightReportList);
	//해당 일자의 일근태 마감 내역 조회 
	public List<DailyAttdReportBean> findApprovalDailyAttdReport(String baseDay,String deptCode);
	//일 근태 마감 여부 수정 (N -> Y)(Y -> N)
	public void updateDailyAttdCloseYN(List<DailyAttdReportBean> dailyAttdReportList,String deptCode);
	
	// 일근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 
	public List<DailyAttdReportBean> findDailyAttdReport(String baseDay,String deptCode) throws ProcedureException;
	
	//연장심야관리목록조히
	public List<OverNightReportBean> findOverNightReportByCondition(Map<String,Object> map);
	
	//연장 심야 상세 저장
	public void batchOverNight(List<OverNightReportBean> overNightReportList);
	
	//월 근태 미마감 조회시 	
	public List<DailyAttdReportBean> findUnClosedDailyAttdReport(String baseYearMonth, String deptCode);
	
	//월근태에서 일근태 미마감 항목 일괄 승인 시
	public List<DailyAttdReportBean> batchDailyAttdCloseYN(List<DailyAttdReportBean> dailyAttdReportList,String deptCode);
	
	// 월근태 계산 
	public List<MonthAttdReportBean> findMonthAttdReport(String baseYearMonth,String deptCode) throws ProcedureException;
	
	// 월 근태 승인 마감
	public void updateMonthAttdCloseYN(List<MonthAttdReportBean> monthAttdReportList);
	
	// 월근태 마감 내역 조회 
	public List<MonthAttdReportBean> findClosedMonthAttdReport(String baseYearMonth,String deptCode);


	
	
}
