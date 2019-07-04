package com.SkyBlue.hr.pm.serviceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SkyBlue.hr.pm.applicationService.PMAppService;
import com.SkyBlue.hr.pm.to.EmployeeInfoBean;

@Service
public class PMServiceFacadeImpl implements PMServiceFacade{
	@Autowired
	private PMAppService pmAppService;

	/* 사원의 모든상세정보를 가지고 오는 메서드 */
	@Override
	public EmployeeInfoBean findEmployeeInfoAll() {
		return pmAppService.findEmployeeInfoAll();
	}

	//사원관련된 정보를 일괄처리하는 메서드 
	@Override
	public void batchEmployeeInfoAll(EmployeeInfoBean employeeInfoBean) {
		 pmAppService.batchEmployeeInfoAll(employeeInfoBean);
	}

	
}
