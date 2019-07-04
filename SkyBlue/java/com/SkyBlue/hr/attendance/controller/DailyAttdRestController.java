package com.SkyBlue.hr.attendance.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.attendance.serviceFacade.AttendanceServiceFacade;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdOutingBean;
import com.SkyBlue.hr.attendance.to.DailyAttdRestBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class DailyAttdRestController {
	@Autowired
	private AttendanceServiceFacade attendanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* 근태외 목록을 가지고오는 메서드 */
	@RequestMapping("/hr/attendance/findAttdRestList.do")
	public void findAttdRestList(@RequestAttribute("inData") PlatformData inData,
								 @RequestAttribute("outData") PlatformData outData) throws Exception {
		String empCode = inData.getVariable("empCode").getString();
		List<DailyAttdRestBean> dailyAttdRestList=attendanceServiceFacade.findAttdRestList(empCode);
		datasetBeanMapper.beansToDataset(outData, dailyAttdRestList, DailyAttdRestBean.class);
    }
	
	// 근태외신청을 추가하는 메서드 
	@RequestMapping("/hr/attendance/addDailyAttdRest.do")
	public void addDailyAttdRest(@RequestAttribute("inData") PlatformData inData,
			 					 @RequestAttribute("outData") PlatformData outData) throws Exception {
		DailyAttdRestBean dailyAttdRestBean=datasetBeanMapper.datasetToBean(inData, DailyAttdRestBean.class);
		List<DailyAttdRestBean> dailyAttdRestList=attendanceServiceFacade.addDailyAttdRest(dailyAttdRestBean);
		datasetBeanMapper.beansToDataset(outData, dailyAttdRestList, DailyAttdRestBean.class);
    }
	
	/* 외출신청목록을 가지고오는 메서드 */
	@RequestMapping("/hr/attendance/findDailyAttdOutingList.do")
	public void findDailyAttdOutingList(@RequestAttribute("inData") PlatformData inData,
			 							@RequestAttribute("outData") PlatformData outData) throws Exception {
		String empCode = inData.getVariable("empCode").getString();
		String fromDate = inData.getVariable("fromDate").getString();
		String toDate = inData.getVariable("toDate").getString();
		List<DailyAttdOutingBean> dailyAttdOutingList=attendanceServiceFacade.findDailyAttdOutingList(empCode,fromDate,toDate);
		datasetBeanMapper.beansToDataset(outData, dailyAttdOutingList, DailyAttdOutingBean.class);
    }
	
	// 외출신청을 추가하는 메서드 
	@RequestMapping("/hr/attendance/addDailyAttdOuting.do")
	public void addDailyAttdOuting(@RequestAttribute("inData") PlatformData inData,
								   @RequestAttribute("outData") PlatformData outData) throws Exception {
		DailyAttdOutingBean dailyAttdOutingBean=datasetBeanMapper.datasetToBean(inData, DailyAttdOutingBean.class);

		attendanceServiceFacade.addDailyAttdOuting(dailyAttdOutingBean);
	}
	
	
	
	// 근태외 승인, 일근태 관리부분에서 조건에 따라 조회하는 메서드 
	@RequestMapping("/hr/attendance/findAttdRestListByCondition.do")
	public void findAttdRestListByCondition(@RequestAttribute("inData") PlatformData inData,
			   							    @RequestAttribute("outData") PlatformData outData) throws Exception {
		
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
		List<DailyAttdRestBean> DailyAttdRestList=attendanceServiceFacade.findAttdRestListByCondition(map);

		datasetBeanMapper.beansToDataset(outData, DailyAttdRestList, DailyAttdRestBean.class);
	}
		
	//일근태외 미승인 -> 승인 된 후 목록 던짐 
	@RequestMapping("/hr/attendance/updateRestApproval.do")
	public void updateApproval(@RequestAttribute("inData") PlatformData inData,
			    			   @RequestAttribute("outData") PlatformData outData) throws Exception {
		batchDailyAttdRest(inData,outData);
		String basicDay = inData.getVariable("basicDay").getString();
		List<DailyAttdRestBean> dailyAttdRestList=attendanceServiceFacade.findUnApprovedDailyAttdRestList(basicDay);
		datasetBeanMapper.beansToDataset(outData, dailyAttdRestList, DailyAttdRestBean.class);
    }

	// 근태외 승인부분에서 일괄적으로 처리하는 메서드 
	@RequestMapping("/hr/attendance/batchDailyAttdRest.do")
	public void batchDailyAttdRest(@RequestAttribute("inData") PlatformData inData,
								   @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<DailyAttdRestBean> dailyAttdRestList=datasetBeanMapper.datasetToBeans(inData, DailyAttdRestBean.class);
		attendanceServiceFacade.batchDailyAttdRest(dailyAttdRestList);
    }
	
	// 근태외 승인부분에서 일괄적으로 처리하는 메서드 
	@RequestMapping("/hr/attendance/batchDailyAttdOuting.do")
	public void batchDailyAttdOuting(@RequestAttribute("inData") PlatformData inData,
			   						 @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<DailyAttdOutingBean> dailyAttdOutingList=datasetBeanMapper.datasetToBeans(inData, DailyAttdOutingBean.class);
		attendanceServiceFacade.batchDailyAttdOuting(dailyAttdOutingList);
	}
	
	
	
}
