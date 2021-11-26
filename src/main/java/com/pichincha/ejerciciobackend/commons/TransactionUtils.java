package com.pichincha.ejerciciobackend.commons;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TransactionUtils {
	public static Date setCreatedAt() {
		LocalDateTime localDateTime = LocalDateTime.now();
	    return Date.from(localDateTime.atZone(ZoneId.of("UTC")).toInstant());
	}
}
