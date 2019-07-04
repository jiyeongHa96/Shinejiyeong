package com.SkyBlue.common.to;

import lombok.Getter;
import lombok.Setter;


public class BaseBean {
	@Getter
	@Setter
    private String status = "normal";
	@Getter
	@Setter
    private String errorCode;
	@Getter
	@Setter
    private String errorMsg;
}
