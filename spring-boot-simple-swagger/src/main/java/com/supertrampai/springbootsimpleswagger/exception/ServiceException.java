/**
 * Copyright © 2017 - 2018 交艺网.All Rights Reserved.
 */
package com.supertrampai.springbootsimpleswagger.exception;

/**
 * @Description
 * @author lxh800109@gmail.com
 * @create 2019-08-21 20:39
 */
public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ServiceException(String message) {
		super(message);
	}
}
