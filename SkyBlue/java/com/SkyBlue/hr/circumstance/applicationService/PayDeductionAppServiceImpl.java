package com.SkyBlue.hr.circumstance.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.hr.circumstance.dao.PayDeductionDAO;
import com.SkyBlue.hr.circumstance.to.PayDeductionBean;

@Component
@Transactional
public class PayDeductionAppServiceImpl implements PayDeductionAppService {
	@Autowired
    private PayDeductionDAO payDeductionDAO;
	

	/* 지급공제 목록을 조회하는 메서드 */
	@Override
	public List<PayDeductionBean> findPayDeductionList() {
		return payDeductionDAO.selectPayDeductionList();
	}

	
	// 지급/공제 관련된 항목을 일괄처리하는 메서드 
	@Override
	public void batchPayDeduction(List<PayDeductionBean> payDeductionList) {
		for(PayDeductionBean payDeductionBean:payDeductionList){
			switch(payDeductionBean.getStatus()){
				case "insert" : payDeductionDAO.insertPayDeduction(payDeductionBean); break;
				case "update" : payDeductionDAO.updatePayDeduction(payDeductionBean); break;
				case "delete" : payDeductionDAO.deletePayDeduction(payDeductionBean); break;
			}
		}
	}
	
}
