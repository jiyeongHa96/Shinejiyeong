package com.SkyBlue.hr.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.attendance.serviceFacade.AttendanceServiceFacade;
import com.SkyBlue.hr.attendance.to.testBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class testController{
	@Autowired
	private AttendanceServiceFacade attendanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("/hr/attendance/testEmp.do")
	public void testEmp(@RequestAttribute("inData") PlatformData inData,
						@RequestAttribute("outData") PlatformData outData) throws Exception {
		//홍 테스트 select
		String empName = inData.getVariable("empName").getString();
		List<testBean> empinfo=attendanceServiceFacade.testEmp(empName);
		datasetBeanMapper.beansToDataset(outData, empinfo, testBean.class);
	}
	
	@RequestMapping("/hr/attendance/batchEmpTest.do")
	public void batchEmpTest(@RequestAttribute("inData") PlatformData inData,
							 @RequestAttribute("outData") PlatformData outData) throws Exception {
		//홍 테스트 batch
		List<testBean> testListBean=datasetBeanMapper.datasetToBeans(inData, testBean.class);
		for(testBean testBean : testListBean) {
			System.out.println("@@@@@@@@@@@@@@@"+testBean.getStatus()+"#######"+testBean);
		}
		attendanceServiceFacade.batchEmpTest(testListBean);
	}
}
