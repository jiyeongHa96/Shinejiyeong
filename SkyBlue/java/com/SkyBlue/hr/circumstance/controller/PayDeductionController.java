package com.SkyBlue.hr.circumstance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.serviceFacade.CircumstanceServiceFacade;
import com.SkyBlue.hr.circumstance.to.PayDeductionBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class PayDeductionController{
	@Autowired
	private CircumstanceServiceFacade circumstanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	// 지급/공제항목을 조회하는 메서드 
	@RequestMapping("/hr/circumstance/findPayDeductionList.do")
	public void findPayDeductionList(@RequestAttribute("inData") PlatformData inData,
			   						 @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<PayDeductionBean> payDeductionList = circumstanceServiceFacade.findPayDeductionList();
		datasetBeanMapper.beansToDataset(outData, payDeductionList, PayDeductionBean.class);
    }
	
	// 지급/공제항목에 관한 일괄처리하는 메서드 
	@RequestMapping("/hr/circumstance/batchPayDeduction.do")
	public void batchPayDeduction(@RequestAttribute("inData") PlatformData inData,
			   					  @RequestAttribute("outData") PlatformData outData) throws Exception {
		   List<PayDeductionBean> payDeductionList=datasetBeanMapper.datasetToBeans(inData, PayDeductionBean.class);
		   circumstanceServiceFacade.batchPayDeduction(payDeductionList);
		   findPayDeductionList(inData,outData);
	}
	
}
