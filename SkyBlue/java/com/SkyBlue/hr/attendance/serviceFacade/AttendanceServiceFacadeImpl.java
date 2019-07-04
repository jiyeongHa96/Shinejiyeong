package com.SkyBlue.hr.attendance.serviceFacade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.attendance.applicationService.AttdReportAppService;
import com.SkyBlue.hr.attendance.applicationService.DailyAttdAppService;
import com.SkyBlue.hr.attendance.applicationService.DailyAttdRestAppService;
import com.SkyBlue.hr.attendance.applicationService.DayAnnualAppService;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdBean;
import com.SkyBlue.hr.attendance.to.DailyAttdOutingBean;
import com.SkyBlue.hr.attendance.to.DailyAttdReportBean;
import com.SkyBlue.hr.attendance.to.DailyAttdRestBean;
import com.SkyBlue.hr.attendance.to.DayAnnualBean;
import com.SkyBlue.hr.attendance.to.MonthAttdReportBean;
import com.SkyBlue.hr.attendance.to.OverNightReportBean;
import com.SkyBlue.hr.attendance.to.testBean;

@Service
public class AttendanceServiceFacadeImpl implements AttendanceServiceFacade{
	@Autowired
	private DailyAttdAppService dailyAttdAppService;
	@Autowired
	private DayAnnualAppService dayAnnualAppService;
	@Autowired
	private DailyAttdRestAppService dailyAttdRestAppService;
	@Autowired
	private AttdReportAppService attdReportAppService;
	
	
	

	@Override
	/* 근태목록을 가지고오는 메서드 */
	public List<DailyAttdBean> findDailyAttdList(String empCode,String fromDate,String toDate) {
		return dailyAttdAppService.findDailyAttdList(empCode,fromDate,toDate);
	}

	@Override
	// 근태신청한 내용을 추가하는 메서드
	public List<DailyAttdBean> addDailyAttd(DailyAttdBean dailyAttdBean) {
		return dailyAttdAppService.addDailyAttd(dailyAttdBean);
	}
	
	// 해당년도, 해당사원의 연차정보, 사원정보를 조회하는 메서드 
	@Override
	public List<DayAnnualBean> findAnnualMgt(String empCode,String standardDate) {
		return dayAnnualAppService.findAnnualMgt(empCode,standardDate);
	}
	
	@Override
	// 근태외목록을 가지고 오는 메서드 
	public List<DailyAttdRestBean> findAttdRestList(String empCode) {
		return dailyAttdRestAppService.findAttdRestList(empCode);
	}
	
	// 연차를 신청하는 메서드 
	@Override
	public List<DayAnnualBean> addDayAnnual(DayAnnualBean dayAnnualBean) {
		return dayAnnualAppService.addDayAnnual(dayAnnualBean);
	}
		
	

	@Override
	// 근태외 신청한 내용을 추가하는 메서드 
	public List<DailyAttdRestBean> addDailyAttdRest(DailyAttdRestBean dailyAttdRestBean) {
		return dailyAttdRestAppService.addDailyAttdRest(dailyAttdRestBean);
	}
	
	@Override
	// 연장 심야 신청 리스트
	public List<OverNightReportBean> findOverNightReport(String empCode,String fromDate,String toDate){
		return attdReportAppService.findOverNightReport(empCode,fromDate,toDate);
	} 
	/*연장심야 일괄 신청*/
	public void updateRequestStatus(List<OverNightReportBean> overNightReportList){
		attdReportAppService.updateRequestStatus(overNightReportList);
	}
	
	
	// 일근태관리테이블에서 기준일에 해당하는 승인된 데이터를 조회하는 메서드 
	@Override
	public List<DailyAttdReportBean> findApprovalDailyAttdReport(String baseDay,String deptCode){
		return attdReportAppService.findApprovalDailyAttdReport(baseDay,deptCode);
	}
	
	
	
	// 해당날짜의 일근태를 마감(수정 )하는 메서드 (N -> Y)(Y -> N)
	@Override
	public void updateDailyAttdCloseYN(List<DailyAttdReportBean> dailyAttdReportList,String deptCode) {
		attdReportAppService.updateDailyAttdCloseYN(dailyAttdReportList,deptCode);
	}
	
	
	// 일근태 승인관리 부분에서 일근태를 조건에 따라 조회하기 위한 메서드 
	@Override
	public List<DailyAttdBean> findDailyAttdListByCondition(ConditionBean conditionBean) {
		return dailyAttdAppService.findDailyAttdListByCondition(conditionBean);
	}
	
	public List<DailyAttdBean> findDailyAttdListByInfo(ConditionBean conditionBean) {
		return dailyAttdAppService.findDailyAttdListByInfo(conditionBean);
	}
	
	// 근태외 승인관리 부분에서 조건에 따라 조회하기 위한 메서드 
	@Override
	public List<DailyAttdRestBean> findAttdRestListByCondition(Map<String,Object> map) {
		return dailyAttdRestAppService.findAttdRestListByCondition(map);
	}
	
	
	//일근태 미승인을 승인으로 변경시 (N이 없어짐 승은으로 변경 되었으면 값이 안나옴?)
	@Override
	public List<DailyAttdBean> findUnApprovedDailyAttdList(String basicDay) {
		return dailyAttdAppService.findUnApprovedDailyAttdList(basicDay);
	}
	
	// 일근태를 일괄적으로 처리하는 메서드 (N -> Y 변경 하는 부분 )
	@Override
	public void batchDailyAttd(List<DailyAttdBean> dailyAttdList) {
		dailyAttdAppService.batchDailyAttd(dailyAttdList);
	}
	
	@Override
	public void deleteDailyAttdList(String empCode, String BasicDay) {
		dailyAttdAppService.deleteDailyAttdList(empCode,BasicDay);
	}
	
	/*일근태후 미승인 -> 승인 후 목록 던짐 */
	@Override
	public List<DailyAttdRestBean> findUnApprovedDailyAttdRestList(String basicDay) {
		return dailyAttdRestAppService.findUnApprovedDailyAttdRestList(basicDay);
	}
	
	
	// 근태외 승인관리 부분을 일괄적으로 처리하는 메서드 
	@Override
	public void batchDailyAttdRest(List<DailyAttdRestBean> dailyAttdRestList) {
		dailyAttdRestAppService.batchDailyAttdRest(dailyAttdRestList);
	}
	
	
	
	// 일근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 
	@Override
	public List<DailyAttdReportBean> findDailyAttdReport(String baseDay,String deptCode) throws ProcedureException{
		return attdReportAppService.findDailyAttdReport(baseDay,deptCode);
	}
		
	//연장 심야 승인관리 목록 조회
	public List<OverNightReportBean> findOverNightReportByCondition(Map<String,Object> map){
		return attdReportAppService.findOverNightReportByCondition(map);
	}
	
	
	//연장 심야 승인 결과 저장
	public void batchOverNight(List<OverNightReportBean> overNightReportList){
		attdReportAppService.batchOverNight(overNightReportList);
	}
	
	
	// 연차 승인관리 부분에서 연차를 조건에 따라 조회하기 위한 메서드 
	@Override
	public List<DayAnnualBean> findDayAnnualListByCondition(String deptCode,String empCode,String fromDate,String toDate,String approvalStatus) {
		return dayAnnualAppService.findDayAnnualListByCondition(deptCode,empCode,fromDate,toDate,approvalStatus);
	}
	
	// 연차를 일괄적으로 처리하는 메서드 
	@Override
	public void batchDayAnnual(List<DayAnnualBean> dayAnnualList) {
		dayAnnualAppService.batchDayAnnual(dayAnnualList);
	}
	
	
	// 해당년월의 일근태관리테이블의 데이터중 미마감인 day관련 정보를 조회하는 항목 
	@Override
	public List<DailyAttdReportBean> findUnClosedDailyAttdReport(String baseYearMonth,String deptCode) {
		return attdReportAppService.findUnClosedDailyAttdReport(baseYearMonth,deptCode);
	}
	
	// 월근태 미마감항목 조회에서 일근태/근태외를 미마감한 경우 일괄적으로 처리하는 메서드 
	@Override
	public List<DailyAttdReportBean> batchDailyAttdCloseYN(List<DailyAttdReportBean> dailyAttdReportList,String deptCode) {
		return attdReportAppService.batchDailyAttdCloseYN(dailyAttdReportList,deptCode);
	}
	
	
	// 월근태관리테이블에서 기준일에 해당하는 데이터를 생성,조회하는 메서드 
	@Override
	public List<MonthAttdReportBean> findMonthAttdReport(String baseYearMonth,String deptCode) throws ProcedureException {
		return attdReportAppService.findMonthAttdReport(baseYearMonth,deptCode);
	}
	
	// 월근태 마감 기준년월의 데이터를 마감하는 메서드 
	@Override
	public void updateMonthAttdCloseYN(List<MonthAttdReportBean> monthAttdReportList) {
		attdReportAppService.updateMonthAttdCloseYN(monthAttdReportList);
	}
	
	// 월근태 마감 내역 조회 
	@Override
	public List<MonthAttdReportBean> findClosedMonthAttdReport(String baseYearMonth,String deptCode){

		return attdReportAppService.findClosedMonthAttdReport(baseYearMonth,deptCode);
	}

	@Override
	public void addDailyAttdOuting(DailyAttdOutingBean dailyAttdOutingBean) {
		
		dailyAttdRestAppService.addDailyAttdOuting(dailyAttdOutingBean);
		
	}
	
	@Override
	public List<DailyAttdOutingBean> findDailyAttdOutingList(String empCode,String fromDate,String toDate) {
		
		return dailyAttdRestAppService.findDailyAttdOutingList(empCode,fromDate,toDate);
		
	}

	@Override
	public void batchDailyAttdOuting(List<DailyAttdOutingBean> dailyAttdOutingList) {
		dailyAttdRestAppService.batchDailyAttdOuting(dailyAttdOutingList);
	}
	//홍 테스트
	@Override
	public List<testBean> testEmp(String testEmp) {
		return dailyAttdRestAppService.testEmp(testEmp);
	}
	//홍 테스트 일괄
	@Override
	public void batchEmpTest(List<testBean> testListBean) {
		dailyAttdRestAppService.batchEmpTest(testListBean);
	}
	
}
