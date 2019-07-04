package com.SkyBlue.base.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.SudangDAO;
import com.SkyBlue.base.to.EtcSalBean;
import com.SkyBlue.base.to.OvertimeSalBean;
import com.SkyBlue.base.to.SudangInfoBean;

@Component
@Transactional
public class BasicSalaryAppServiceImpl implements BasicSalaryAppService {
	@Autowired
    private SudangDAO sudangDAO;
	

	@Override
	/* 연장,야간,휴일수당관련된 목록을 가져오는 메서드 */
	public List<OvertimeSalBean> findOvertimeSalList() {
		return sudangDAO.selectOvertimeSalList();
	}

	@Override
	/* 기타수당을 가져오는 메서드 */
	public List<EtcSalBean> findEtcSalList() {
		return sudangDAO.selectEtcSalList();
	}


	@Override
	public void batchSudang(SudangInfoBean sudangInfoBean) {
		for(OvertimeSalBean overtimeSalBean :sudangInfoBean.getOvertimeSalList()){
			switch(overtimeSalBean.getStatus()){
				case "insert" : sudangDAO.insertOvertimeSal(overtimeSalBean); break;
				case "update" : sudangDAO.updateOvertimeSal(overtimeSalBean); break;
				case "delete" : sudangDAO.deleteOvertimeSal(overtimeSalBean); break;
			}

		}

		for(EtcSalBean etcSalBean:sudangInfoBean.getEtcSalList()){

			switch(etcSalBean.getStatus()){
				case "insert" : sudangDAO.insertEtcSal(etcSalBean); break;
				case "update" : sudangDAO.updateEtcSal(etcSalBean); break;
				case "delete" : sudangDAO.deleteEtcSal(etcSalBean); break;
			}
		}
	}


}
