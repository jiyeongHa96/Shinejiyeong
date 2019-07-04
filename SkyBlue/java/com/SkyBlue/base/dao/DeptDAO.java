package com.SkyBlue.base.dao;

import java.util.List;

import com.SkyBlue.base.to.DeptBean;

public interface DeptDAO {
    public List<DeptBean> selectDeptList(String businessPlaceCode);

    public void insertDept(DeptBean deptBean);
    public void updateDept(DeptBean deptBean);
    public void deleteDept(DeptBean deptBean);
}
