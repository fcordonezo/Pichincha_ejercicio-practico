package com.pichincha.ejerciciobackend.commons;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AccountUtils {
	
	public static Date setDueDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
	    localDateTime = localDateTime.plusYears(5);
	    return Date.from(localDateTime.atZone(ZoneId.of("UTC")).toInstant());
	}

}
