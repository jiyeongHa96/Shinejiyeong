package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;



@Dataset(name="dsAuthority")
public class AuthorityBean extends BaseBean{
	@Setter
	@Getter
	String authorityCode,authorityName;


	
}
