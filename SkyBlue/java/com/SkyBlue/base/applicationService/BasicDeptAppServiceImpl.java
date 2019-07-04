 package com.SkyBlue.base.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.DeptDAO;
import com.SkyBlue.base.to.DeptBean;


@Component
@Transactional
public class BasicDeptAppServiceImpl implements BasicDeptAppService {
	@Autowired
    private DeptDAO deptDAO;


    @Override
    public List<DeptBean> findDeptList(String businessPlaceCode) {
        return deptDAO.selectDeptList(businessPlaceCode);
    }

	@Override
	public void batchDept(List<DeptBean> deptList) {
		for(DeptBean deptBean:deptList){
			switch(deptBean.getStatus()){ /*mapper에서 bean들의  rowType를 읽어 온듯?? 필요없는경우에 받아만 놓고 사용 안함*/
				case "insert" : deptDAO.insertDept(deptBean); break;
				case "update" : deptDAO.updateDept(deptBean); break;
				case "delete" : deptDAO.deleteDept(deptBean); break;
			}
		}
	}

}
