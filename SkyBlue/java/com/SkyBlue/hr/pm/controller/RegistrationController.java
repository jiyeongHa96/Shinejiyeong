package com.SkyBlue.hr.pm.controller;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.pm.serviceFacade.PMServiceFacade;
import com.SkyBlue.hr.pm.to.EducationInfoBean;
import com.SkyBlue.hr.pm.to.EmpInfoBean;
import com.SkyBlue.hr.pm.to.EmployeeInfoBean;
import com.SkyBlue.hr.pm.to.FamilyInfoBean;
import com.SkyBlue.hr.pm.to.LicenseInfoBean;
import com.SkyBlue.hr.pm.to.SalInfoBean;
import com.SkyBlue.hr.pm.to.WorkInfoBean;

import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.DataSet;

@Controller
public class RegistrationController{

	@Autowired
	private PMServiceFacade pmServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	// 해당사원의 모든 사원관련 상세정보를 가져오는 메서드 
	@RequestMapping("/hr/pm/findEmployeeInfoAll.do")
	public void findEmployeeInfoAll(@RequestAttribute("inData") PlatformData inData,
				 					@RequestAttribute("outData") PlatformData outData) throws Exception {
		EmployeeInfoBean employeeInfoBean=pmServiceFacade.findEmployeeInfoAll();
		
		datasetBeanMapper.beansToDataset(outData, employeeInfoBean.getEmpInfoList(), EmpInfoBean.class);
		datasetBeanMapper.beansToDataset(outData, employeeInfoBean.getWorkInfoList(), WorkInfoBean.class);
		datasetBeanMapper.beansToDataset(outData, employeeInfoBean.getFamilyInfoList(), FamilyInfoBean.class);
		datasetBeanMapper.beansToDataset(outData, employeeInfoBean.getLicenseInfoList(), LicenseInfoBean.class);
		datasetBeanMapper.beansToDataset(outData, employeeInfoBean.getEducationInfoList(), EducationInfoBean.class);
		datasetBeanMapper.beansToDataset(outData, employeeInfoBean.getSalInfoList(), SalInfoBean.class);
		
		
		
    }

	// 사원의 이미지를 저장하는 메서드 
	@RequestMapping("/hr/pm/saveEmpImg.do")
	public void saveEmpImg(@RequestAttribute("inData") PlatformData inData,
				 		   @RequestAttribute("outData") PlatformData outData) throws Exception {
		DataSet dataset = inData.getDataSet("dsImg");
		FileOutputStream out = null;
		FileOutputStream out1 = null;
		String fileName = (String) dataset.getObject(0, "EMP_FILE_NAME");
		try {
			if (fileName != null) {
				System.out.println("fileName : " + fileName);
				out = new FileOutputStream("C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/SkyBlue/img/"+fileName);
				out1 = new FileOutputStream("C:/MiplatformSpring/SkyBlue/src/main/webapp/img/"+fileName);
				
				
				byte[] file = dataset.getBlob(0, "IMG_FILE_DATA");
				BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
				BufferedOutputStream bufferedOut1 = new BufferedOutputStream(out1);
				
				bufferedOut.write(file);
				bufferedOut.flush();
				bufferedOut.close();
				
				bufferedOut1.write(file);
				bufferedOut1.flush();
				bufferedOut1.close();
				
				
				out.close();
				bufferedOut = null;
				bufferedOut1 = null;
				out = null;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	// 사원의 상세정보를 일괄처리하는 메서드 
	@RequestMapping("/hr/pm/batchEmployeeInfoAll.do")
	public void batchEmployeeInfoAll(@RequestAttribute("inData") PlatformData inData,
	 		   						 @RequestAttribute("outData") PlatformData outData) throws Exception {
		System.out.println(inData);
		EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
		employeeInfoBean.setEmpInfoList(datasetBeanMapper.datasetToBeans(inData, EmpInfoBean.class));
		employeeInfoBean.setWorkInfoList(datasetBeanMapper.datasetToBeans(inData, WorkInfoBean.class));
		employeeInfoBean.setFamilyInfoList(datasetBeanMapper.datasetToBeans(inData, FamilyInfoBean.class));
		employeeInfoBean.setLicenseInfoList(datasetBeanMapper.datasetToBeans(inData, LicenseInfoBean.class));
		employeeInfoBean.setEducationInfoList(datasetBeanMapper.datasetToBeans(inData, EducationInfoBean.class));
	
		employeeInfoBean.setSalInfoList(datasetBeanMapper.datasetToBeans(inData, SalInfoBean.class));
		
		
		pmServiceFacade.batchEmployeeInfoAll(employeeInfoBean);
		findEmployeeInfoAll(inData,outData);
    }

	
}