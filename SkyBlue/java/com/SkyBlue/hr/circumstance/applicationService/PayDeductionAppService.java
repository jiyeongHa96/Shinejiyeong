package com.SkyBlue.hr.circumstance.applicationService;

import java.util.List;

import com.SkyBlue.hr.circumstance.to.PayDeductionBean;

public interface PayDeductionAppService {
	public List<PayDeductionBean> findPayDeductionList();
	public void batchPayDeduction(List<PayDeductionBean> payDeductionList);
}
