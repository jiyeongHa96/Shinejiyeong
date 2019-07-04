package com.SkyBlue.base.applicationService;

import java.util.List;

import com.SkyBlue.base.to.PositionBean;

public interface PositionAppService {
    public List<PositionBean> findPositionList();
    
    public PositionBean findPosition(String positionCode);
}
