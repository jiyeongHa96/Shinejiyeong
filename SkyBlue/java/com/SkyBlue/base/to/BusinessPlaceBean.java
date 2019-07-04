package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;


@Dataset(name = "dsBusinessPlace")
public class BusinessPlaceBean extends BaseBean {
	@Setter
	@Getter
	private String businessPlaceCode;
	@Setter
	@Getter
	private String businessPlaceName;
	@Setter
	@Getter
	private String businessPlaceTel;
	@Setter
	@Getter
	private String companyCode;
}
