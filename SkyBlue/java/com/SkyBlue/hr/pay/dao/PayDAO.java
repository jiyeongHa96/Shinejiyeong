package com.SkyBlue.hr.pay.dao;

import java.util.List;
import java.util.Map;

import com.SkyBlue.hr.pay.to.ExpensesDeductionBean;
import com.SkyBlue.hr.pay.to.SalaryInputBean;

public interface PayDAO {
	public List<ExpensesDeductionBean> payCalculate(Map<String, Object> map);
	public List<SalaryInputBean> selectSalaryInputList(String paymentDate);
	public List<ExpensesDeductionBean> selectPayDeductionList(String paymentDate);
}
