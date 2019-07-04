package com.SkyBlue.hr.attendance.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.hr.attendance.dao.DailyAttdRestDAO;
import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DailyAttdOutingBean;
import com.SkyBlue.hr.attendance.to.DailyAttdRestBean;
import com.SkyBlue.hr.attendance.to.testBean;

@Component
@Transactional
public class DailyAttdRestAppServiceImpl implements DailyAttdRestAppService {

	@Autowired
	private DailyAttdRestDAO dailyAttdRestDAO;


	
	// 근태외 목록을 가지고오는 메서드 
	@Override
	public List<DailyAttdRestBean> findAttdRestList(String empCode) {
		return dailyAttdRestDAO.selectAttdRestList(empCode);
	}
	
	
	// 근퇴외 신청을 하는 메서드 
	@Override
	public List<DailyAttdRestBean> addDailyAttdRest(DailyAttdRestBean dailyAttdRestBean) {
		dailyAttdRestDAO.insertDailyAttdRest(dailyAttdRestBean);
		return findAttdRestList(dailyAttdRestBean.getEmpCode());
	}
	
	
	// 근태승인관리, 일근태부분에서 조건에따라 근태외항목을 조회하기 위한 메서드 
	@Override
	public List<DailyAttdRestBean> findAttdRestListByCondition(Map<String,Object> map) {
		return  dailyAttdRestDAO.selectAttdRestListByCondition(map);
	}
	
	//일근태외 미승인 ->승인 후 목록 던짐 
	@Override
	public List<DailyAttdRestBean> findUnApprovedDailyAttdRestList(String basicDay) {
		return dailyAttdRestDAO.selectUnApprovedDailyAttdRestList(basicDay);
	}
	@Override	
	public void addDailyAttdOuting(DailyAttdOutingBean dailyAttdOutingBean) {
		dailyAttdRestDAO.insertDailyAttdOuting(dailyAttdOutingBean);
	}

	@Override
	public List<DailyAttdOutingBean> findDailyAttdOutingList(String empCode,String fromDate,String toDate) {
		HashMap<String,String> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return dailyAttdRestDAO.selectDailyAttdOutingList(map);
	}
	
	// 근태외항목을 일괄처리하기 위한 메서드 
	@Override
	public void batchDailyAttdRest(List<DailyAttdRestBean> dailyAttdRestList) {
		 for(DailyAttdRestBean dailyAttdRestBean : dailyAttdRestList) {
	         switch(dailyAttdRestBean.getStatus()) {
	            case "insert" : dailyAttdRestDAO.insertDailyAttdRest(dailyAttdRestBean); break;
	            case "update" : dailyAttdRestDAO.updateDailyAttdRest(dailyAttdRestBean); break;
	            case "delete" : dailyAttdRestDAO.deleteDailyAttdRest(dailyAttdRestBean); break;
	         }
	     }
	}

	// 근태외항목을 일괄처리하기 위한 메서드 
	@Override
	public void batchDailyAttdOuting(List<DailyAttdOutingBean> dailyAttdOutingList) {
		
		 for(DailyAttdOutingBean dailyAttdOutingBean : dailyAttdOutingList) {
			
	         switch(dailyAttdOutingBean.getStatus()) {
	            case "update" : HashMap<String, String> map = new HashMap<>();
								map.put("outingSeq", dailyAttdOutingBean.getGoingoutSeq());
								map.put("approvalStatus", dailyAttdOutingBean.getApprovalStatus());
	            				dailyAttdRestDAO.updateDailyAttdOuting(map); break;
	            case "delete" : dailyAttdRestDAO.deleteDailyAttdOuting(dailyAttdOutingBean); break;
	         }
	     }
	}
	//홍 테스트
	@Override
	public List<testBean> testEmp(String empName) {
		return dailyAttdRestDAO.selectTestEmpInfo(empName);	
	}
	//홍 테스트 일괄
	@Override
	public void batchEmpTest(List<testBean> testListBean) {
		for(testBean testBean:testListBean) {
			switch(testBean.getStatus()) { 
				case "delete" : dailyAttdRestDAO.deleteTestEmpInfo(testBean);break;
				case "insert" : dailyAttdRestDAO.insertTestEmpINfo(testBean);break;
				case "update" : dailyAttdRestDAO.updateTestEmpINfo(testBean);break;
			}
		}
	}
	
}
