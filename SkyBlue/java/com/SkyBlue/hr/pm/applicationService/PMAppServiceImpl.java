package com.SkyBlue.hr.pm.applicationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.hr.pm.dao.EducationInfoDAO;
import com.SkyBlue.hr.pm.dao.EmpInfoDAO;
import com.SkyBlue.hr.pm.dao.FamilyInfoDAO;
import com.SkyBlue.hr.pm.dao.LicenseInfoDAO;
import com.SkyBlue.hr.pm.dao.SalInfoDAO;
import com.SkyBlue.hr.pm.dao.WorkInfoDAO;
import com.SkyBlue.hr.pm.to.EducationInfoBean;
import com.SkyBlue.hr.pm.to.EmpInfoBean;
import com.SkyBlue.hr.pm.to.EmployeeInfoBean;
import com.SkyBlue.hr.pm.to.FamilyInfoBean;
import com.SkyBlue.hr.pm.to.LicenseInfoBean;
import com.SkyBlue.hr.pm.to.SalInfoBean;
import com.SkyBlue.hr.pm.to.WorkInfoBean;

@Component
@Transactional
public class PMAppServiceImpl implements PMAppService {
	@Autowired
	private EmpInfoDAO empInfoDAO;
	
	@Autowired
	private WorkInfoDAO workInfoDAO;
	
	@Autowired
	private FamilyInfoDAO familyInfoDAO;

	@Autowired
	private LicenseInfoDAO licenseInfoDAO;
	
	@Autowired
	private EducationInfoDAO educationInfoDAO;
	
	@Autowired
	private SalInfoDAO salInfoDAO;
	
	
	@Override
	/* 사원의 모든 상세정보를 가지고 오는 메서드 */
	public EmployeeInfoBean findEmployeeInfoAll() {
		EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
		employeeInfoBean.setEmpInfoList(empInfoDAO.selectEmpInfoAll());
		employeeInfoBean.setWorkInfoList(workInfoDAO.selectWorkInfoAll());
		employeeInfoBean.setFamilyInfoList(familyInfoDAO.selectFamilyInfoAll());
		employeeInfoBean.setLicenseInfoList(licenseInfoDAO.selectLicenseInfoAll());
		employeeInfoBean.setEducationInfoList(educationInfoDAO.selectEducationInfoAll());
		employeeInfoBean.setSalInfoList(salInfoDAO.selectSalInfoAll());
		
		return employeeInfoBean;
	}
	
	/* 사원관련정보를 일괄처리하는 메서드 */
	@Override
	public void batchEmployeeInfoAll(EmployeeInfoBean employeeInfoBean) {
		//사원상세정보 있으면 여기 실행(수정된것) [사원코드랑 연결 되어 있는 구조는 insert,delete가 안됨 update 뿐임.. insert는 기본 사원정보 넣을 때 실시 삭제는 내가 막아 놨음]
		for(EmpInfoBean EmpInfoBean :employeeInfoBean.getEmpInfoList()){
			empInfoDAO.updateEmpInfo(EmpInfoBean);
		}
		
		for(WorkInfoBean workInfoBean:employeeInfoBean.getWorkInfoList()){
			workInfoDAO.updateWorkInfo(workInfoBean);
		}
		
		for(SalInfoBean salInfoBean:employeeInfoBean.getSalInfoList()){
			salInfoDAO.updateSalInfo(salInfoBean);
		}

		for(FamilyInfoBean familyInfoBean :employeeInfoBean.getFamilyInfoList()){
			switch(familyInfoBean.getStatus()){
				case "insert" : familyInfoDAO.insertFamilyInfo(familyInfoBean); break;
				case "update" : familyInfoDAO.updateFamilyInfo(familyInfoBean); break;
				case "delete" : familyInfoDAO.deleteFamilyInfo(familyInfoBean); break;
			}
		}
		
		for(LicenseInfoBean licenseInfoBean :employeeInfoBean.getLicenseInfoList()){
			switch(licenseInfoBean.getStatus()){
				case "insert" : licenseInfoDAO.insertLicenseInfo(licenseInfoBean); break;
				case "update" : licenseInfoDAO.updateLicenseInfo(licenseInfoBean); break;
				case "delete" : licenseInfoDAO.deleteLicenseInfo(licenseInfoBean); break;
			}
		}
		
		
		for(EducationInfoBean educationInfoBean :employeeInfoBean.getEducationInfoList()){
			switch(educationInfoBean.getStatus()){
				case "insert" : educationInfoDAO.insertEducationInfo(educationInfoBean); break;
				case "update" : educationInfoDAO.updateEducationInfo(educationInfoBean); break;
				case "delete" : educationInfoDAO.deleteEducationInfo(educationInfoBean); break;
			}
		}
	
	}
}
