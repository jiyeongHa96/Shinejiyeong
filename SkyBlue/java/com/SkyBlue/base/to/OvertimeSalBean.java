package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsOvertimeSal")
public class OvertimeSalBean extends BaseBean{

	@Getter
	@Setter
	private String overtimeSalCode,overtimeSalName,overtimeSalRate;

}
