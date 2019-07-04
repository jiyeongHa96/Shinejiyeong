package com.SkyBlue.hr.attendance.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.attendance.dao.AttdReportDAO;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdReportBean;
import com.SkyBlue.hr.attendance.to.MonthAttdReportBean;
import com.SkyBlue.hr.attendance.to.OverNightReportBean;

@Component
@Transactional
public class AttdReportAppServiceImpl implements AttdReportAppService {
	@Autowired
	private AttdReportDAO attdReportDAO;
	

	//연장 심야 신청 리스트 
	public List<OverNightReportBean> findOverNightReport(String empCode,String fromDate,String toDate){
		HashMap<String, String> map = new HashMap<>();
		map.put("empCode",empCode);
		map.put("fromDate",fromDate);
		map.put("toDate",toDate);
		return attdReportDAO.selectOverNightReport(map);
	}
	
	//연장 심야 신청 일괄 신청
	public void updateRequestStatus(List<OverNightReportBean> overNightReportList){
		for(OverNightReportBean overNightReportBean:overNightReportList){
			attdReportDAO.updateRequestStatus(overNightReportBean);
		}
	}
	
	// 일근태관리테이블에서 기준일에 해당하는 승인된 데이터를 조회하는 메서드 
	@Override
	public List<DailyAttdReportBean> findApprovalDailyAttdReport(String baseDay,String deptCode){
		Map<String, String> map = new HashMap<>();
	       map.put("baseDay", baseDay);
	       map.put("deptCode", deptCode);
		 return attdReportDAO.selectApprovalDailyAttdReport(map);
	}
	
	// 해당날짜의 일근태를 마감하는 메서드 (Y-> N / N-> Y ) 
	@Override
	public void updateDailyAttdCloseYN(List<DailyAttdReportBean> dailyAttdReportList,String deptCode) {
		 for(DailyAttdReportBean dailyAttdReportBean : dailyAttdReportList) {
				Map<String, Object> map = new HashMap<>();
				   map.put("basicDay", dailyAttdReportBean.getBasicDay());
				   map.put("closeYn", dailyAttdReportBean.getCloseYn());
			       map.put("deptCode", deptCode);
			       System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@"+"basicday:"+dailyAttdReportBean.getBasicDay()+"closeYn:"+dailyAttdReportBean.getCloseYn()+"deptCode:"+deptCode);
			 attdReportDAO.updateDailyAttdCloseYN(map);
	     }
	}
	
	// 일근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 
		@Override
	public List<DailyAttdReportBean> findDailyAttdReport(String baseDay,String deptCode) throws ProcedureException{
		 Map<String, Object> map = new HashMap<>();
		 Map<String, String> result = new HashMap<>();
		       map.put("baseDay", baseDay);
		       map.put("deptCode", deptCode);
		       attdReportDAO.createDailyAttdReport(map); //생성 
               result.put("errorCode", map.get("errorCode") + "");
               result.put("errorMsg", map.get("errorMsg") + "");
		
		return attdReportDAO.selectDailyAttdReportByDate(map); // 조회 
	}
		
	//연장 심야 승인 목록조회	
	public List<OverNightReportBean> findOverNightReportByCondition(Map<String,Object> map){
		return attdReportDAO.selectOverNightReportByCondition(map);
	}	
	
	
	//연장 심야 신청등록, 신청삭제, 승인업데이트
	public void batchOverNight(List<OverNightReportBean> overNightReportList){
		for(OverNightReportBean overNightReportBean:overNightReportList){
			
			switch(overNightReportBean.getStatus()) {
			
			case "insert" : attdReportDAO.insertOverNightReport(overNightReportBean); break;
			case "update" : attdReportDAO.updateApprovalStatus(overNightReportBean); break;
			case "delete" : attdReportDAO.deleteOverNightReport(overNightReportBean); break;
		
			}
	    }
	}
	
	
	// 해당년월의 일근태관리테이블의 데이터중 미마감인 day관련 정보를 조회하는 항목 
	@Override
	public List<DailyAttdReportBean> findUnClosedDailyAttdReport(String baseYearMonth, String deptCode) {
		Map<String, Object> map = new HashMap<>();
		 	map.put("baseYearMonth", baseYearMonth);
	        map.put("deptCode", deptCode);
		System.out.println("해당년월의 일근태관리테이블의 데이터중 미마감인 day관련 정보를 조회하는 항목");
		return attdReportDAO.selectUnClosedDailyAttdReport(map);
	}
	
	//월근태 미마감항목 조회에서 일근태/근태외를 미마감한 경우 일괄적으로 처리하는 메서드 
	@Override
	public List<DailyAttdReportBean> batchDailyAttdCloseYN(List<DailyAttdReportBean> dailyAttdReportList,String deptCode) {
		 String baseYearMonth=null;
		 Map<String, Object> map = new HashMap<>();
		 for(DailyAttdReportBean dailyAttdReportBean : dailyAttdReportList) {
				   map.put("basicDay", dailyAttdReportBean.getBasicDay());
				   map.put("closeYn", dailyAttdReportBean.getCloseYn());
			       map.put("deptCode", deptCode);
			 attdReportDAO.updateDailyAttdCloseYN(map);
			 if(baseYearMonth==null){
				 baseYearMonth = dailyAttdReportBean.getBasicDay(); // 날짜 얻어 옴 
			 }
	     }
		 baseYearMonth = baseYearMonth.substring(0, 6);
		 return findUnClosedDailyAttdReport(baseYearMonth, deptCode); // 수정 후 일근태 미마감 목록 다시 조회 !!
	}
	

	// 월근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 
	@Override
	public List<MonthAttdReportBean> findMonthAttdReport(String baseYearMonth,String deptCode) throws ProcedureException {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> result = new HashMap<>();
	       map.put("baseYearMonth", baseYearMonth);
	       map.put("deptCode", deptCode);
	       attdReportDAO.createMonthAttdReport(map);
           result.put("errorCode", map.get("errorCode") + "");
           result.put("errorMsg", map.get("errorMsg") + "");
		
		return attdReportDAO.selectMonthlyAttdReportByYearMonth(map);
	}
	
	
	// 기준년월의 데이터를 마감하는 메서드 
	@Override
	public void updateMonthAttdCloseYN(List<MonthAttdReportBean> monthAttdReportList) {
		String basicYearMonth = monthAttdReportList.get(0).getBasicYearMonth();
		String closeYn = monthAttdReportList.get(0).getCloseYn();
		Map<String,String> map = new HashMap<String,String>();
		map.put("basicYearMonth", basicYearMonth);
		map.put("closeYn", closeYn);
		attdReportDAO.updateMonthAttdCloseYN(map);
	}

	//월근태 마감 내역 조회 
	@Override
	public List<MonthAttdReportBean> findClosedMonthAttdReport(String baseYearMonth,String deptCode){
		Map<String, Object> map = new HashMap<>();
	       map.put("baseYearMonth", baseYearMonth);
	       map.put("deptCode", deptCode);
		return attdReportDAO.selectClosedMonthAttdReport(map);
	}



}