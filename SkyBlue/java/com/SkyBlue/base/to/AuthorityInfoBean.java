package com.SkyBlue.base.to;

import java.util.List;

import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

public class AuthorityInfoBean extends BaseBean{
	@Setter
	@Getter
	private List<AuthorityBean> authorityList;
	@Setter
	@Getter
	private List<MenuAuthorityBean> menuAuthorityList;

}
