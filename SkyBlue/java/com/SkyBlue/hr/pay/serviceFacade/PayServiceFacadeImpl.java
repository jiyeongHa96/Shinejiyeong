package com.SkyBlue.hr.pay.serviceFacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.pay.applicationService.PayAppService;
import com.SkyBlue.hr.pay.to.ExpensesDeductionBean;
import com.SkyBlue.hr.pay.to.SalaryInputBean;

@Service
public class PayServiceFacadeImpl implements PayServiceFacade{
	@Autowired
	private PayAppService payAppService;


	/* 급여를 계산하는 메서드 */
	@Override
	public List<ExpensesDeductionBean> payCalculate(String paymentDate, String standardDate) throws ProcedureException{
		System.out.println(paymentDate+","+standardDate);
		return payAppService.payCalculate(paymentDate, standardDate);
	}
	
	public List<SalaryInputBean> salaryInputList(String paymentDate){
		return payAppService.salaryInputList(paymentDate);
	}
}
