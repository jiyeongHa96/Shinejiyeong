package com.SkyBlue.hr.pm.dao;

import java.util.List;

import com.SkyBlue.hr.pm.to.EmpInfoBean;


public interface EmpInfoDAO {
    public List<EmpInfoBean> selectEmpInfoAll();
   
    public void updateEmpInfo(EmpInfoBean empInfoBean);
}
