package com.SkyBlue.base.applicationService;

import java.util.List;

import com.SkyBlue.base.to.DeptBean;


public interface BasicDeptAppService {
    public List<DeptBean> findDeptList(String businessPlaceCode);
    public void batchDept(List<DeptBean> deptList);
}
