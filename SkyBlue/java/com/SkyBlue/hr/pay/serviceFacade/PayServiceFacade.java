package com.SkyBlue.hr.pay.serviceFacade;

import java.util.List;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.pay.to.ExpensesDeductionBean;
import com.SkyBlue.hr.pay.to.SalaryInputBean;

public interface PayServiceFacade {
	public List<ExpensesDeductionBean> payCalculate(String paymentDate, String standardDate) throws ProcedureException;
	public List<SalaryInputBean> salaryInputList(String paymentDate);
}
