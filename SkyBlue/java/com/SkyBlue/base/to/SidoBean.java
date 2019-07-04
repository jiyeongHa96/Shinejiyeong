package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsSido")
public class SidoBean extends BaseBean{
	@Setter
	@Getter
	private String sidoCode,sidoValue;

}
