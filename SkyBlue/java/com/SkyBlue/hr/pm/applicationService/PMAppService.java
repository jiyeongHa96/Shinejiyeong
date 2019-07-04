package com.SkyBlue.hr.pm.applicationService;

import com.SkyBlue.hr.pm.to.EmployeeInfoBean;

public interface PMAppService {
	
	public EmployeeInfoBean findEmployeeInfoAll();

	public void batchEmployeeInfoAll(EmployeeInfoBean employeeInfoBean);

}
