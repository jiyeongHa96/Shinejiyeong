package com.SkyBlue.hr.pm.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsLicenseInfo")
public class LicenseInfoBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,licenseSeq,licenseName,startDate,endDate,licenseCenter,licenseLevel,licenseNo;

}
