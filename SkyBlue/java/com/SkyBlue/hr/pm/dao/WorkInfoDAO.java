package com.SkyBlue.hr.pm.dao;

import java.util.List;

import com.SkyBlue.hr.pm.to.WorkInfoBean;

public interface WorkInfoDAO {
    public List<WorkInfoBean> selectWorkInfoAll();
    
    public void updateWorkInfo(WorkInfoBean workInfoBean);
}
