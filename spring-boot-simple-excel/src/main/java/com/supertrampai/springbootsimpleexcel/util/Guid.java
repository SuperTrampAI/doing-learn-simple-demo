package com.supertrampai.springbootsimpleexcel.util;

import java.util.Random;
import java.util.UUID;

public class Guid {

	public static String NewGuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 生成唯一的主键 格式: 时间+随机数
	 * 
	 * @return
	 */
	public static synchronized String genUniqueKey() {
		Random random = new Random();
		Integer number = random.nextInt(900000) + 100000;

		return System.currentTimeMillis() + String.valueOf(number);
	}
}
