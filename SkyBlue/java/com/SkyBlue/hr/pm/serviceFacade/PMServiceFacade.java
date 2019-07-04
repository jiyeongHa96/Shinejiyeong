package com.SkyBlue.hr.pm.serviceFacade;

import com.SkyBlue.hr.pm.to.EmployeeInfoBean;

public interface PMServiceFacade {
	public EmployeeInfoBean findEmployeeInfoAll();
	public void batchEmployeeInfoAll(EmployeeInfoBean employeeInfoBean);
}
