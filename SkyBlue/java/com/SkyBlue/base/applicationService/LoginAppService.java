package com.SkyBlue.base.applicationService;

import com.SkyBlue.base.exception.BusinessPlaceNotFoundException;
import com.SkyBlue.base.exception.DeptNotFoundException;
import com.SkyBlue.base.exception.EmpCodeNotFoundException;
import com.SkyBlue.base.exception.PwMissMatchException;
import com.SkyBlue.base.to.EmployeeBean;

public interface LoginAppService {

    public EmployeeBean checkLogin(String businessPlaceCode,String deptCode,String empCode,String password)throws EmpCodeNotFoundException,BusinessPlaceNotFoundException,DeptNotFoundException,PwMissMatchException;
    
    
}

	
		
	
