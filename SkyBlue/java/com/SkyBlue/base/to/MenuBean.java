package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsMenu")
public class MenuBean extends BaseBean{
	@Setter
	@Getter
	private String menuCode,menuName,menuUrl,superMenuCode,usingStatus,level;

}
