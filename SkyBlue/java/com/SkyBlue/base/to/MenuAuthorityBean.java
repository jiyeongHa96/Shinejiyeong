package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsMenuAuthority")
public class MenuAuthorityBean extends BaseBean{
	@Setter
	@Getter
	private String authorityCode,authorityName,menuCode,menuName;

}
