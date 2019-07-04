package com.SkyBlue.hr.circumstance.applicationService;

import java.util.List;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.circumstance.to.AnnualBean;

public interface AnnualAppService {
	public List<AnnualBean> findAnnualList();
	
	public List<AnnualBean> createAnnual(String standardYear,String empCode,String hireDate) throws ProcedureException;
	
	public void batchAnnual(List<AnnualBean> annualList);
	
	public List<AnnualBean> editAnnualMgt(String standardYear,String empCode,String days,String restDays);
	
}
