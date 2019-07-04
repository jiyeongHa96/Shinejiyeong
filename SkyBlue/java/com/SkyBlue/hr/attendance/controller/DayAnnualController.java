package com.SkyBlue.hr.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.attendance.serviceFacade.AttendanceServiceFacade;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DayAnnualBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class DayAnnualController{
	@Autowired
	private AttendanceServiceFacade attendanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* 해당년도, 해당사원의 연차정보, 사원정보를 조회하는 메서드 */
	@RequestMapping("/hr/attendance/findAnnualMgt.do")
	public void findAnnualMgt(@RequestAttribute("inData") PlatformData inData,
							  @RequestAttribute("outData") PlatformData outData) throws Exception {
		String empCode = inData.getVariable("empCode").getString();
		String standardYear = inData.getVariable("standardYear").getString();
		List<DayAnnualBean> dayAnnualList=attendanceServiceFacade.findAnnualMgt(empCode,standardYear);
		datasetBeanMapper.beansToDataset(outData, dayAnnualList, DayAnnualBean.class);
    }
	
	// 연차를 신청하는 메서드 
	@RequestMapping("/hr/attendance/addDayAnnual.do")
	public void addDayAnnual(@RequestAttribute("inData") PlatformData inData,
			  				 @RequestAttribute("outData") PlatformData outData) throws Exception {
		DayAnnualBean dayAnnualBean=datasetBeanMapper.datasetToBean(inData, DayAnnualBean.class);
		List<DayAnnualBean> dayAnnualList=attendanceServiceFacade.addDayAnnual(dayAnnualBean);
		datasetBeanMapper.beansToDataset(outData, dayAnnualList, DayAnnualBean.class);
	}
	
	
	// 연차 승인, 관리부분에서 조건에 따라 조회하는 메서드 
	@RequestMapping("/hr/attendance/findDayAnnualListByCondition.do")
	public void findDayAnnualListByCondition(@RequestAttribute("inData") PlatformData inData,
			  								 @RequestAttribute("outData") PlatformData outData) throws Exception {
		String deptCode = inData.getVariable("deptCode").getString();
		String empCode = inData.getVariable("empCode").getString();
		String fromDate = inData.getVariable("fromDate").getString();
		String toDate = inData.getVariable("toDate").getString();
		String approvalStatus = inData.getVariable("approvalStatus").getString();
		
		List<DayAnnualBean> dayAnnualList=attendanceServiceFacade.findDayAnnualListByCondition(deptCode,empCode,fromDate,toDate,approvalStatus);
		datasetBeanMapper.beansToDataset(outData, dayAnnualList, DayAnnualBean.class);
	  }


	// 연차 승인화면에서 연차를 일괄적으로 승인처리 하는 메서드 
	@RequestMapping("/hr/attendance/batchDayAnnual.do")
	public void batchDayAnnual(@RequestAttribute("inData") PlatformData inData,
				 			   @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<DayAnnualBean> dayAnnualList=datasetBeanMapper.datasetToBeans(inData, DayAnnualBean.class);
		attendanceServiceFacade.batchDayAnnual(dayAnnualList);
    }


}
