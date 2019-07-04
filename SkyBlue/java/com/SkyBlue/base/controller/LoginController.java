package com.SkyBlue.base.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.EmployeeBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class LoginController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("/base/checkLogin.do")
	public void checkLogin(@RequestAttribute("inData") PlatformData inData,
				 		   @RequestAttribute("outData") PlatformData outData) throws Exception {
		String businessPlaceCode= inData.getVariable("businessPlaceCode").getString();
		String deptCode= inData.getVariable("deptCode").getString();
		String empCode= inData.getVariable("empCode").getString();
		String password= inData.getVariable("password").getString();
		System.out.println(businessPlaceCode);
		System.out.println(deptCode);
		System.out.println(empCode);
		System.out.println(password);
		
		EmployeeBean employee=baseServiceFacade.checkLogin(businessPlaceCode,deptCode,empCode,password);
		  datasetBeanMapper.beanToDataset(outData, employee, EmployeeBean.class);
		 
    }
}
