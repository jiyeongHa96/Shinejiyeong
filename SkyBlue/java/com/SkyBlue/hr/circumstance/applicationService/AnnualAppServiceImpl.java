package com.SkyBlue.hr.circumstance.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.circumstance.dao.AnnualDAO;
import com.SkyBlue.hr.circumstance.to.AnnualBean;

@Component
@Transactional
public class AnnualAppServiceImpl implements AnnualAppService {
	@Autowired
	private AnnualDAO annualDAO;

	

	/* 연차정보를 조회하는 메서드 */
	@Override
	public List<AnnualBean> findAnnualList() {
		return annualDAO.selectAnnualList();
	}

	// 해당년도, 해당사원의 연차정보를 생성하는 메서드
	@Override
	public List<AnnualBean> createAnnual(String standardDate, String empCode, String hireDate) throws ProcedureException {
		Map<String, Object> map = new HashMap<>();
	       map.put("standardYear", standardDate);
	       map.put("empCode", empCode);
	       map.put("hireDate", hireDate);
		   map = annualDAO.createAnnual(map);
		   Map<String, String> result = new HashMap<>();
           result.put("errorCode", map.get("errorCode") + "");
           result.put("errorMsg", map.get("errorMsg") + "");
           
		return annualDAO.selectAnnualList();
	}

	// 연차와 관련된 일괄처리를 하는 메서드
	@Override
	public void batchAnnual(List<AnnualBean> annualList) {
		for (AnnualBean annualBean : annualList) {
			switch (annualBean.getStatus()) {
			case "update":
				annualDAO.updateAnnual(annualBean);
				break;// 필요 한지는 모르겠음 (막아야 될 듯)
			case "delete":
				annualDAO.deleteAnnual(annualBean);
				break;
			}
		}
	}

	// 연차를 신청할때 연차관리테이블을 update하기 위한 메서드
	@Override
	public List<AnnualBean> editAnnualMgt(String standardYear, String empCode, String days, String restDays) {
		Map<String, Object> map = new HashMap<>();
        map.put("standardYear", standardYear);
        map.put("empCode", empCode);
        map.put("days", days);
        map.put("restDays", restDays);
		annualDAO.updateAnnualMgt(map);
		return annualDAO.selectAnnualList();
	}

}
