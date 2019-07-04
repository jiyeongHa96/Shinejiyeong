package com.SkyBlue.hr.pay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.pay.serviceFacade.PayServiceFacade;
import com.SkyBlue.hr.pay.to.ExpensesDeductionBean;
import com.SkyBlue.hr.pay.to.SalaryInputBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class PayController{
	@Autowired
	private PayServiceFacade payServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* 급여를 계산하는 메서드 */
	@RequestMapping("/hr/pay/payCalculate.do")
	public void payCalculate(@RequestAttribute("inData") PlatformData inData,
				 			 @RequestAttribute("outData") PlatformData outData) throws Exception {
		String paymentDate = inData.getVariable("paymentDate").getString();
		String standardDate = inData.getVariable("standardDate").getString();// 추가 
		List<ExpensesDeductionBean> expensespayDeductionList = payServiceFacade.payCalculate(paymentDate,standardDate);
		List<SalaryInputBean> salaryInputList = payServiceFacade.salaryInputList(paymentDate);
		
		/*
		 * List<SalaryInputBean>
		 * salaryInputList=payServiceFacade.payCalculate(paymentDate,standardDate);
		 * 
		 * List<ExpensesDeductionBean> payDeductionList=new
		 * ArrayList<ExpensesDeductionBean>(); for(SalaryInputBean
		 * salaryInputBean:salaryInputList){
		 * payDeductionList.addAll(salaryInputBean.getPayDeductionList()); }
		 */
		datasetBeanMapper.beansToDataset(outData, expensespayDeductionList, ExpensesDeductionBean.class);
		datasetBeanMapper.beansToDataset(outData, salaryInputList, SalaryInputBean.class);
    }
}