package com.SkyBlue.base.to;

import java.util.List;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsCompany")
public class CompanyBean extends BaseBean {
	@Setter
	@Getter
	private String companyCode,companyName,companyDivision,businessLicenseNumber,corporationLicenseNumber,companyCeoName;
	@Setter
	@Getter
	private String companyBusinessConditions,companyBusinessItems,companyZipCode,companyBasicAddress,companyDetailAddress;
	@Setter
	@Getter
	private String companyTelNumber,companyFaxNumber,companyEstablishmentDate,companyOpenDate;


	


}