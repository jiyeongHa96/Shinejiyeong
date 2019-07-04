package com.SkyBlue.base.applicationService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.CompanyDAO;
import com.SkyBlue.base.to.CompanyBean;




@Component
@Transactional
public class CompanyAppServiceImpl implements CompanyAppService {
	@Autowired
    private CompanyDAO companyDAO;
    
	
	@Override
	public CompanyBean findCompany() {
	
		return companyDAO.selectCompany();
	}

	@Override
	public void batchCompany(CompanyBean companyBean) {

	
			switch(companyBean.getStatus()){ /*mapper에서 bean들의  rowType를 읽어 온듯?? 필요없는경우에 받아만 놓고 사용 안함*/
				case "insert" : companyDAO.insertCompany(companyBean); break;
				case "update" : companyDAO.updateCompany(companyBean); break;
				case "delete" : companyDAO.deleteCompany(companyBean); break;
			
		}
	
	}
	
}
