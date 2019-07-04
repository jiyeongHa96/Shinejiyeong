
package com.SkyBlue.base.dao;



import com.SkyBlue.base.to.CompanyBean;

public interface CompanyDAO {
	 public CompanyBean selectCompany();

	    public void insertCompany(CompanyBean companyBean);
	    public void updateCompany(CompanyBean companyBean);
	    public void deleteCompany(CompanyBean companyBean);
}
