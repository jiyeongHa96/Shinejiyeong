package com.SkyBlue.base.applicationService;

import java.util.List;

import com.SkyBlue.base.to.AuthorityBean;
import com.SkyBlue.base.to.AuthorityInfoBean;
import com.SkyBlue.base.to.MenuAuthorityBean;

public interface AuthorityAppService {
    public List<MenuAuthorityBean> findMenuAuthorityList(String authorityCode);
    public List<AuthorityBean> findAuthorityList();
    public List<MenuAuthorityBean> findMenuAuthorityListAll();
    public void batchAuthority(AuthorityInfoBean authorityInfoBean);
   
}