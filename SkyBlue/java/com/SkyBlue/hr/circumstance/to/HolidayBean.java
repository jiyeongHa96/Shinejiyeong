package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsHoliday")
public class HolidayBean extends BaseBean{
	@Setter
	@Getter
	private String basicDay,holidayName,note,holidayType;

}
