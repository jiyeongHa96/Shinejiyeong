package com.SkyBlue.hr.attendance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.attendance.serviceFacade.AttendanceServiceFacade;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdReportBean;
import com.SkyBlue.hr.attendance.to.MonthAttdReportBean;
import com.SkyBlue.hr.attendance.to.OverNightReportBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class AttdReportController{
	@Autowired
	private AttendanceServiceFacade attendanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	
	/*연장 심야 신청 조회버튼  */
	@RequestMapping("/hr/attendance/findOverNightAttdReport.do")
	public void findOverNightAttdReport(@RequestAttribute("inData") PlatformData inData,
				 						@RequestAttribute("outData") PlatformData outData) throws Exception {
		
		String empCode = inData.getVariable("empCode").getString();
		String fromDate = inData.getVariable("fromDate").getString();
		String toDate = inData.getVariable("toDate").getString();
		
		List<OverNightReportBean> overNightReportList=attendanceServiceFacade.findOverNightReport(empCode,fromDate,toDate);
		datasetBeanMapper.beansToDataset(outData, overNightReportList, OverNightReportBean.class);
    }

	/*연장 심야 일괄 신청버튼 --> 없앴다*/   
	@RequestMapping("/hr/attendance/updateRequestStatus.do")
	public void updateRequestStatus(@RequestAttribute("inData") PlatformData inData,
								    @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<OverNightReportBean> overNightReportList=datasetBeanMapper.datasetToBeans(inData, OverNightReportBean.class);
		attendanceServiceFacade.updateRequestStatus(overNightReportList);
    }
	
	// 일근태관리테이블에서 기준일에 해당하는 승인된 데이터를 조회하는 메서드 
	@RequestMapping("/hr/attendance/findApprovalDailyAttdReport.do")
	public void findApprovalDailyAttdReport(@RequestAttribute("inData") PlatformData inData,
											@RequestAttribute("outData") PlatformData outData) throws Exception {
		String baseDay = inData.getVariable("baseDay").getString();
		String deptCode = inData.getVariable("deptCode").getString();
		System.out.println("Xplatform server test");
		List<DailyAttdReportBean> dailyAttdReportList=attendanceServiceFacade.findApprovalDailyAttdReport(baseDay,deptCode);
		datasetBeanMapper.beansToDataset(outData, dailyAttdReportList, DailyAttdReportBean.class);
	}
	
	// 해당날짜의 일근태를 마감하는 메서드 (마감여부를 Y -> N으로 ) (N-> Y)
	@RequestMapping("/hr/attendance/updateDailyAttdCloseYN.do")
	public void updateDailyAttdCloseYN(@RequestAttribute("inData") PlatformData inData,
									   @RequestAttribute("outData") PlatformData outData) throws Exception {
		String deptCode = inData.getVariable("deptCode").getString();
		List<DailyAttdReportBean> dailyAttdReportList=datasetBeanMapper.datasetToBeans(inData, DailyAttdReportBean.class);
		attendanceServiceFacade.updateDailyAttdCloseYN(dailyAttdReportList,deptCode);
	}
	
	// 일근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 (일일근태관리 프로시저 호출)
	@RequestMapping("/hr/attendance/findDailyAttdReport.do")
	public void findDailyAttdReport(@RequestAttribute("inData") PlatformData inData,
			   						@RequestAttribute("outData") PlatformData outData) throws Exception {		
		String baseDay = inData.getVariable("baseDay").getString();
		String deptCode = inData.getVariable("deptCode").getString();
		
		List<DailyAttdReportBean> dailyAttdReportList=attendanceServiceFacade.findDailyAttdReport(baseDay,deptCode);
		datasetBeanMapper.beansToDataset(outData, dailyAttdReportList, DailyAttdReportBean.class);
	}

	// 연장 심야 승인관리 
	@RequestMapping("/hr/attendance/findOverNightReportByCondition.do")
	public void findOverNightReportByCondition(@RequestAttribute("inData") PlatformData inData,
											   @RequestAttribute("outData") PlatformData outData) throws Exception{
		
		String deptCode = inData.getVariable("deptCode").getString();
		String empCode = inData.getVariable("empCode").getString();
		String fromDate = inData.getVariable("fromDate").getString();
		String toDate = inData.getVariable("toDate").getString();
		String approvalStatus = inData.getVariable("approvalStatus").getString();
		Map<String,Object> map=new HashMap<>();
		map.put("deptCode",deptCode);
		map.put("empCode",empCode);
		map.put("fromDate",fromDate);
		map.put("toDate",toDate);
		map.put("approvalStatus",approvalStatus);
		List<OverNightReportBean> overNightReportList=attendanceServiceFacade.findOverNightReportByCondition(map);
		datasetBeanMapper.beansToDataset(outData, overNightReportList, OverNightReportBean.class);
	}
	
	
	/*연장심야 승인 결과 저장*/
	@RequestMapping("/hr/attendance/batchOverNight.do")
	public void batchOverNight(@RequestAttribute("inData") PlatformData inData,
			   				   @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<OverNightReportBean> overNightReportList=datasetBeanMapper.datasetToBeans(inData, OverNightReportBean.class);
		
		attendanceServiceFacade.batchOverNight(overNightReportList);
    }
	
	
	// 해당년월의 일근태관리테이블의 데이터중 미마감인 day관련 정보를 조회하는 항목 
	@RequestMapping("/hr/attendance/findUnClosedDailyAttdReport.do")
	public void findUnClosedDailyAttdReport(@RequestAttribute("inData") PlatformData inData,
			   								@RequestAttribute("outData") PlatformData outData) throws Exception {
		String baseYearMonth = inData.getVariable("baseYearMonth").getString();
		String deptCode = inData.getVariable("deptCode").getString();
		List<DailyAttdReportBean> UnclosedDailyAttdReportList=attendanceServiceFacade.findUnClosedDailyAttdReport(baseYearMonth,deptCode);
		datasetBeanMapper.beansToDataset(outData, UnclosedDailyAttdReportList, DailyAttdReportBean.class);
	}
	
	// 월근태 미마감항목 조회에서 일근태/근태외를 미마감한 경우 일괄적으로 처리하는 메서드 
	@RequestMapping("/hr/attendance/batchDailyAttdCloseYN.do")
	public void batchDailyAttdCloseYN(@RequestAttribute("inData") PlatformData inData,
									  @RequestAttribute("outData") PlatformData outData) throws Exception {
		String deptCode = inData.getVariable("deptCode").getString();
		List<DailyAttdReportBean> dailyAttdReportList=datasetBeanMapper.datasetToBeans(inData, DailyAttdReportBean.class);
		List<DailyAttdReportBean> UnclosedDailyAttdReportList=attendanceServiceFacade.batchDailyAttdCloseYN(dailyAttdReportList,deptCode);
		datasetBeanMapper.beansToDataset(outData, UnclosedDailyAttdReportList, DailyAttdReportBean.class);
	}
	
	
	// 월근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 월근태관리프로시저
	@RequestMapping("/hr/attendance/findMonthAttdReport.do")
	public void findMonthAttdReport(@RequestAttribute("inData") PlatformData inData,
			  					    @RequestAttribute("outData") PlatformData outData) throws Exception {
		String baseYearMonth = inData.getVariable("baseYearMonth").getString();
		String deptCode = inData.getVariable("deptCode").getString();
		List<MonthAttdReportBean> monthAttdReportList=attendanceServiceFacade.findMonthAttdReport(baseYearMonth,deptCode);
		datasetBeanMapper.beansToDataset(outData, monthAttdReportList, MonthAttdReportBean.class);
	}
	
	// 기준년월의 데이터를 마감처리하는 메서드 
	@RequestMapping("/hr/attendance/updateMonthAttdCloseYN.do")
	public void updateMonthAttdCloseYN(@RequestAttribute("inData") PlatformData inData,
			    					   @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<MonthAttdReportBean> monthAttdReportList=datasetBeanMapper.datasetToBeans(inData, MonthAttdReportBean.class);
		attendanceServiceFacade.updateMonthAttdCloseYN(monthAttdReportList);
	}

	//월근태 미간 매역 조회 
	@RequestMapping("/hr/attendance/findClosedMonthAttdReport.do")
	public void findClosedMonthAttdReport(@RequestAttribute("inData") PlatformData inData,
			   							  @RequestAttribute("outData") PlatformData outData) throws Exception {
		String baseYearMonth = inData.getVariable("baseYearMonth").getString();
		String deptCode = inData.getVariable("deptCode").getString();
		List<MonthAttdReportBean> monthAttdReportList=attendanceServiceFacade.findClosedMonthAttdReport(baseYearMonth,deptCode);
		datasetBeanMapper.beansToDataset(outData, monthAttdReportList, MonthAttdReportBean.class);
    }



}