package com.SkyBlue.hr.circumstance.dao;

import java.util.List;

import com.SkyBlue.hr.circumstance.to.PayDeductionBean;

public interface PayDeductionDAO {
	public List<PayDeductionBean> selectPayDeductionList();
	
	public void insertPayDeduction(PayDeductionBean payDeductionBean);
	public void updatePayDeduction(PayDeductionBean payDeductionBean);
	public void deletePayDeduction(PayDeductionBean payDeductionBean);
	
}

