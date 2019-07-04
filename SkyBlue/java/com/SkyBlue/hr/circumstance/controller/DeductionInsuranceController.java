package com.SkyBlue.hr.circumstance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.serviceFacade.CircumstanceServiceFacade;
import com.SkyBlue.hr.circumstance.to.DeductionTaxBean;
import com.SkyBlue.hr.circumstance.to.IncomeTaxBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class DeductionInsuranceController{
	@Autowired
	private CircumstanceServiceFacade circumstanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* 보험공제 목록을 가져오는 메서드 */
	@RequestMapping("/hr/circumstance/findDeductionInsuranceList.do")
	public void findDeductionInsuranceList(@RequestAttribute("inData") PlatformData inData,
				 						   @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<DeductionTaxBean> deductionsTaxList=circumstanceServiceFacade.findDeductionTaxList();
		List<IncomeTaxBean> incomeTaxList=circumstanceServiceFacade.findIncomeTaxList();
		datasetBeanMapper.beansToDataset(outData, deductionsTaxList, DeductionTaxBean.class);
		datasetBeanMapper.beansToDataset(outData, incomeTaxList, IncomeTaxBean.class);
    }
	
	// 보험공제, 소득세를 삭제하는 메서드 
	@RequestMapping("/hr/circumstance/removeDeductionTax.do")
	public void removeDeductionTax(@RequestAttribute("inData") PlatformData inData,
				 				   @RequestAttribute("outData") PlatformData outData) throws Exception {
	
		DeductionTaxBean deductionTaxBean=datasetBeanMapper.datasetToBean(inData, DeductionTaxBean.class);
		List<IncomeTaxBean> incomeTaxList=datasetBeanMapper.datasetToBeans(inData, IncomeTaxBean.class);
		circumstanceServiceFacade.removeDeductionTax(deductionTaxBean);
		circumstanceServiceFacade.removeIncomeTaxList(incomeTaxList);
		findDeductionInsuranceList(inData,outData);
	}

	// 보험공제, 소득세 관련부분을 일괄적으로 처리하는 메서드 
	@RequestMapping("/hr/circumstance/batchDeductionTax.do")
	public void batchDeductionTax(@RequestAttribute("inData") PlatformData inData,
				 				  @RequestAttribute("outData") PlatformData outData) throws Exception{
		DeductionTaxBean deductionTaxBean=datasetBeanMapper.datasetToBean(inData, DeductionTaxBean.class);
		List<IncomeTaxBean> incomeTaxList=datasetBeanMapper.datasetToBeans(inData, IncomeTaxBean.class);
		circumstanceServiceFacade.addDeductionTax(deductionTaxBean);
		circumstanceServiceFacade.addIncomeTaxList(incomeTaxList);
		findDeductionInsuranceList(inData,outData);
	}

	
    
}
