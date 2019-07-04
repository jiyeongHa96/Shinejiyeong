package com.SkyBlue.hr.circumstance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.serviceFacade.CircumstanceServiceFacade;
import com.SkyBlue.hr.circumstance.to.SalPaymentDateBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class PayDateController{
	@Autowired
	private CircumstanceServiceFacade circumstanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* 귀속년월의 등록된 급/상여 지급일및 관련정보를 조회하는 메서드 */
	@RequestMapping("/hr/circumstance/findSalPaymentDateList.do")
	public void findSalPaymentDateList(@RequestAttribute("inData") PlatformData inData,
				 					   @RequestAttribute("outData") PlatformData outData) throws Exception {
		String inputedYearMonth = inData.getVariable("inputedYearMonth").getString();
		List<SalPaymentDateBean> salPaymentsDateList = circumstanceServiceFacade.findSalPaymentDateList(inputedYearMonth);
		datasetBeanMapper.beansToDataset(outData, salPaymentsDateList, SalPaymentDateBean.class);
    }


	// 귀속년월의 급/상여 지급일 및 관련정보를 등록및 수정,삭제한 내용을 일괄처리하는 메서드 
	@RequestMapping("/hr/circumstance/batchSalPaymentDate.do")
	public void batchSalPaymentDate(@RequestAttribute("inData") PlatformData inData,
			   						@RequestAttribute("outData") PlatformData outData) throws Exception {
		
		List<SalPaymentDateBean> salPaymentDateList = datasetBeanMapper.datasetToBeans(inData, SalPaymentDateBean.class);
		circumstanceServiceFacade.batchSalPaymentDate(salPaymentDateList);
    }
    
}
