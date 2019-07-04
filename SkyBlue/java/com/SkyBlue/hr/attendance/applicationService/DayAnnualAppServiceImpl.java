package com.SkyBlue.hr.attendance.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.hr.attendance.dao.DayAnnualDAO;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DayAnnualBean;

@Component
@Transactional
public class DayAnnualAppServiceImpl implements DayAnnualAppService {
	@Autowired
	private DayAnnualDAO dayAnnualDAO;
	

	/* 해당년도, 해당사원의 연차정보, 사원정보를 조회하는 메서드 */
	@Override
	public List<DayAnnualBean> findAnnualMgt(String empCode, String standardYear) {
		Map<String, Object> map = new HashMap<>();
        map.put("empCode", empCode);
        map.put("standardYear", standardYear);
		return dayAnnualDAO.selectAnnualMgt(map);
	}
	
	// 연차를 신청하는 메서드 
	@Override
	public List<DayAnnualBean> addDayAnnual(DayAnnualBean dayAnnualBean) {
		dayAnnualDAO.insertDayAnnual(dayAnnualBean);
		return findAnnualMgt(dayAnnualBean.getEmpCode(),dayAnnualBean.getStandardYear());
	}
	
	// 연차 승인부분에서 연차를 조건에 따라 조회하는 메서드 
	@Override
	public List<DayAnnualBean> findDayAnnualListByCondition(String deptCode,String empCode,String fromDate,String toDate,String approvalStatus) {
		Map<String, Object> map = new HashMap<>();
        map.put("deptCode", deptCode);
        map.put("empCode", empCode);
        map.put("fromDate", fromDate);
        map.put("toDate", toDate);
        map.put("approvalStatus", approvalStatus);
		return dayAnnualDAO.selectDayAnnualListByCondition(map);
	}

	// 연차를 일괄적으로 처리하는 메서드 
	@Override
	public void batchDayAnnual(List<DayAnnualBean> dayAnnualList) {
		 for(DayAnnualBean dayAnnualBean : dayAnnualList) {
			 switch(dayAnnualBean.getStatus()) {
			 	case "insert" : dayAnnualDAO.insertDayAnnual(dayAnnualBean); break;
	            case "update" : dayAnnualDAO.updateDayAnnual(dayAnnualBean); break;
	            case "delete" : dayAnnualDAO.deleteDayAnnual(dayAnnualBean); 
	            				dayAnnualDAO.updateDayAnnualDays(dayAnnualBean); break;
			 }
	      }
	}
	
}
