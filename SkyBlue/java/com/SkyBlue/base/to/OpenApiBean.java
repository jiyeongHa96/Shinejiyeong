package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsOpenApi")
public class OpenApiBean extends BaseBean{
	@Setter
	@Getter
	private String fdPrdtNm,atcId,mdcd,fdFilePathImg,fdYmd,depPlace,fdSbjt;
}
