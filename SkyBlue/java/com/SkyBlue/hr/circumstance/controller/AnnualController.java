package com.SkyBlue.hr.circumstance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.serviceFacade.CircumstanceServiceFacade;
import com.SkyBlue.hr.circumstance.to.AnnualBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class AnnualController{
	@Autowired
	private CircumstanceServiceFacade circumstanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* 사원의 연차정보를 조회하는 메서드 */
	@RequestMapping("/hr/circumstance/findAnnualList.do")
	public void findAnnualList(@RequestAttribute("inData") PlatformData inData,
				 			   @RequestAttribute("outData") PlatformData outData) throws Exception {
	       List<AnnualBean> annualList=circumstanceServiceFacade.findAnnualList();
	       datasetBeanMapper.beansToDataset(outData, annualList, AnnualBean.class);
	}

	// 해당년도, 해당사원의 연차를 생성하는 메서드 
	@RequestMapping("/hr/circumstance/createAnnual.do")
	public void createAnnual(@RequestAttribute("inData") PlatformData inData,
			   				 @RequestAttribute("outData") PlatformData outData) throws Exception {
		String standardYear = inData.getVariable("standardYear").getString();
		String empCode = inData.getVariable("empCode").getString();
		String hireDate = inData.getVariable("hireDate").getString();
		List<AnnualBean> annulList=circumstanceServiceFacade.createAnnual(standardYear,empCode,hireDate);
		datasetBeanMapper.beansToDataset(outData, annulList, AnnualBean.class);
    }
	
	// 연차와 관련된 일괄처리를 하는 메서드 
	@RequestMapping("/hr/circumstance/batchAnnual.do")
	public void batchAnnual(@RequestAttribute("inData") PlatformData inData,
				 			@RequestAttribute("outData") PlatformData outData) throws Exception {
		   List<AnnualBean> annualList=datasetBeanMapper.datasetToBeans(inData, AnnualBean.class);
		   circumstanceServiceFacade.batchAnnual(annualList);
		   findAnnualList(inData,outData);
	}
	
	// 연차신청할때 연차관리테이블을 수정하기 위한 메서드 
	@RequestMapping("/hr/circumstance/editAnnualMgt.do")
	public void editAnnualMgt(@RequestAttribute("inData") PlatformData inData,
 							  @RequestAttribute("outData") PlatformData outData) throws Exception {
		String standardYear = inData.getVariable("standardYear").getString();
		String empCode = inData.getVariable("empCode").getString();
		String days = inData.getVariable("days").getString();
		String restDays = inData.getVariable("restDays").getString();
		List<AnnualBean> annulList=circumstanceServiceFacade.editAnnulMgt(standardYear,empCode,days,restDays);
		datasetBeanMapper.beansToDataset(outData, annulList, AnnualBean.class);
    }
    
    
}
