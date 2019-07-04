package com.SkyBlue.hr.attendance.applicationService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.hr.attendance.dao.DailyAttdDAO;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdBean;

@Component
@Transactional
public class DailyAttdAppServiceImpl implements DailyAttdAppService {
	@Autowired
	private DailyAttdDAO dailyAttdDAO;
	
	public void deleteDailyAttdList(String empCode, String basicDay) {
		HashMap<String, String> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("basicDay", basicDay);
		dailyAttdDAO.deleteDailyAttd(map);
	}

	// 일근태목록을 가지고 오는 메서드 
	@Override
	public List<DailyAttdBean> findDailyAttdList(String empCode,String fromDate,String toDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return dailyAttdDAO.selectDailyAttdList(map);
	}

	// 일근태를 추가하는 메서드 
	@Override
	public List<DailyAttdBean> addDailyAttd(DailyAttdBean dailyAttdBean) {
		HashMap<String, String> map= new HashMap<>();
		map.put("basicDay", dailyAttdBean.getBasicDay());
		map.put("empCode", dailyAttdBean.getEmpCode());
		map.put("empName", dailyAttdBean.getEmpName());
		map.put("attdTypeCode", dailyAttdBean.getAttdTypeCode());
		map.put("time", dailyAttdBean.getTime());
		map.put("cause", dailyAttdBean.getCause());
		if(("ADC100").equals(dailyAttdBean.getAttdTypeCode())) {
			dailyAttdDAO.insertDailyAttdCheckOutByProcedure(map);
		}else{
			dailyAttdDAO.insertDailyAttd(dailyAttdBean);
		}
		
		return findDailyAttdList(dailyAttdBean.getEmpCode(),dailyAttdBean.getBasicDay(),dailyAttdBean.getBasicDay());
	}
	
	
	// 일근태 승인부분에서 일근태를 조건에 따라 조회하는 메서드 
	@Override
	public List<DailyAttdBean> findDailyAttdListByCondition(ConditionBean conditionBean) {
		return dailyAttdDAO.selectDailyAttdListByCondition(conditionBean);
	}
	
	public List<DailyAttdBean> findDailyAttdListByInfo(ConditionBean conditionBean) {
		return dailyAttdDAO.selectDailyAttdListByInfo(conditionBean);
	}
	
	//일근태 미승인을 승인으로 변경 시 (N이 없어짐 승은으로 변경 되었으면 값이 안나옴?)
	@Override
	public List<DailyAttdBean> findUnApprovedDailyAttdList(String basicDay) {
		return dailyAttdDAO.selectUnApprovedDailyAttdList(basicDay);
	}

	

	//일근태를 일괄적으로 처리하는 메서드 ( N -> Y 로 변경 하는 부분 )
	@Override
	public void batchDailyAttd(List<DailyAttdBean> dailyAttdList) {
		 for(DailyAttdBean dailyAttdBean : dailyAttdList) {
	            switch(dailyAttdBean.getStatus()) {
	            case "insert" : dailyAttdDAO.insertDailyAttd(dailyAttdBean); break;
	            case "update" : dailyAttdDAO.updateDailyAttd(dailyAttdBean); break; //일근태 관리 에서 미승인을 승인으로 변경 하면 여기 실행됨
	            case "delete" : HashMap<String, String> map = new HashMap<>();
	    						map.put("empCode", dailyAttdBean.getEmpCode());
	    						map.put("basicDay", dailyAttdBean.getBasicDay());
	            				dailyAttdDAO.deleteDailyAttd(map); break;
	            }
	     }

	}
}
