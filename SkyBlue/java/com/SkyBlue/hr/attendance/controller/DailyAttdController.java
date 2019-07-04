package com.SkyBlue.hr.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.attendance.serviceFacade.AttendanceServiceFacade;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class DailyAttdController{
	@Autowired
	private AttendanceServiceFacade attendanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
					     
	@RequestMapping("/hr/attendance/findDailyAttdListByInfo.do")
	public void findDailyAttdListByInfo(@RequestAttribute("inData") PlatformData inData,
										@RequestAttribute("outData") PlatformData outData) throws Exception {
		String deptCode = inData.getVariable("deptCode").getString();
		String basicDay = inData.getVariable("basicDay").getString();
		String approvalStatus = inData.getVariable("approvalStatus").getString();
		String empCode = inData.getVariable("empCode").getString();
		ConditionBean conditionBean =new ConditionBean();
		conditionBean.setApprovalStatus(approvalStatus);
		conditionBean.setBasicDay(basicDay);
		conditionBean.setDeptCode(deptCode);
		conditionBean.setEmpCode(empCode);
		List<DailyAttdBean> dailyAttdList=attendanceServiceFacade.findDailyAttdListByInfo(conditionBean);
		datasetBeanMapper.beansToDataset(outData, dailyAttdList, DailyAttdBean.class);
	}
	
	/* 일근태 목록을 가지고 오는 메서드 */
	@RequestMapping("/hr/attendance/findDailyAttdList.do")
	public void findDailyAttdList(@RequestAttribute("inData") PlatformData inData,
								  @RequestAttribute("outData") PlatformData outData) throws Exception {
		String empCode = inData.getVariable("empCode").getString();
		String fromDate = inData.getVariable("fromDate").getString();
		String toDate = inData.getVariable("toDate").getString();
		List<DailyAttdBean> dailyAttdList=attendanceServiceFacade.findDailyAttdList(empCode,fromDate,toDate);
		datasetBeanMapper.beansToDataset(outData, dailyAttdList, DailyAttdBean.class);
    }
	
	 //일근태 삭제
	@RequestMapping("/hr/attendance/deleteDailyAttdList.do")
	public void deleteDailyAttdList(@RequestAttribute("inData") PlatformData inData,
									@RequestAttribute("outData") PlatformData outData) throws Exception {
		String empCode = inData.getVariable("empCode").getString();
		String basicDay = inData.getVariable("basicDay").getString();
		System.out.println("CON삭제@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+empCode);
		
		attendanceServiceFacade.deleteDailyAttdList(empCode,basicDay);
    }

	// 일근태를 추가하는 메서드 
	@RequestMapping("/hr/attendance/addDailyAttd.do")
	public void addDailyAttd(@RequestAttribute("inData") PlatformData inData,
			  				 @RequestAttribute("outData") PlatformData outData) throws Exception {
		DailyAttdBean dailyAttdBean=datasetBeanMapper.datasetToBean(inData, DailyAttdBean.class);
		List<DailyAttdBean> dailyAttdList=attendanceServiceFacade.addDailyAttd(dailyAttdBean);
		datasetBeanMapper.beansToDataset(outData, dailyAttdList, DailyAttdBean.class);
    }
	
	
	// 일근태 승인, 관리부분에서 조건에 따라 조회하는 메서드 
	@RequestMapping("/hr/attendance/findDailyAttdListByCondition.do")
	public void findDailyAttdListByCondition(@RequestAttribute("inData") PlatformData inData,
											 @RequestAttribute("outData") PlatformData outData) throws Exception {
		String deptCode = inData.getVariable("deptCode").getString();
		String basicDay = inData.getVariable("basicDay").getString();
		String approvalStatus = inData.getVariable("approvalStatus").getString();
		
		ConditionBean conditionBean =new ConditionBean();
		conditionBean.setApprovalStatus(approvalStatus);
		conditionBean.setBasicDay(basicDay);
		conditionBean.setDeptCode(deptCode);
		List<DailyAttdBean> dailyAttdList=attendanceServiceFacade.findDailyAttdListByCondition(conditionBean);
		datasetBeanMapper.beansToDataset(outData, dailyAttdList, DailyAttdBean.class);
	   }
	
	//일근태 관리에서 근태/근태외 미승인을 승인으로 변경 후 저장 할 때 
	@RequestMapping("/hr/attendance/updateApproval.do")
	public void updateApproval(@RequestAttribute("inData") PlatformData inData,
			 				   @RequestAttribute("outData") PlatformData outData) throws Exception {
		batchDailyAttd(inData,outData);
		String basicDay = inData.getVariable("basicDay").getString();
		List<DailyAttdBean> unApprovedDailyAttdList=attendanceServiceFacade.findUnApprovedDailyAttdList(basicDay); //변경 후 결과를 가져 간다.
		datasetBeanMapper.beansToDataset(outData, unApprovedDailyAttdList, DailyAttdBean.class);
    }
		
		

	// 일근태 승인화면에서 일근태를 일괄적으로 승인처리 하는 메서드 (N- > Y 변경 하는 곳 )
	@RequestMapping("/hr/attendance/batchDailyAttd.do")
	public void batchDailyAttd(@RequestAttribute("inData") PlatformData inData,
			   				   @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<DailyAttdBean> dailyAttdList=datasetBeanMapper.datasetToBeans(inData, DailyAttdBean.class);
		attendanceServiceFacade.batchDailyAttd(dailyAttdList);
    }
}
