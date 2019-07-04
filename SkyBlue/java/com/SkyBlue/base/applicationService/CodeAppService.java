package com.SkyBlue.base.applicationService;

import java.util.List;

import com.SkyBlue.base.to.CodeBean;
import com.SkyBlue.base.to.CodeInfoBean;
import com.SkyBlue.base.to.DetailCodeBean;

/*import com.worldMiplatform.base.to.CodeInfoBean;*/

public interface CodeAppService {
    public List<CodeBean> findCodeList(); 
   public void batchCode(CodeInfoBean codeInfoBean);
    public void batchDetailCode(List<DetailCodeBean> detailCodeList);
}
