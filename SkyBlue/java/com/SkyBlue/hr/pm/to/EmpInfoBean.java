package com.SkyBlue.hr.pm.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsEmpInfo")
public class EmpInfoBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,empName,residentNumber,birthDate,gender,imgSrc,zipCode;
	@Setter
	@Getter
	private String baseAddress,detailAddress,email,tel,phoneNumber,highestEducationCode,nativeTypeCode,disabilityCode;


}
