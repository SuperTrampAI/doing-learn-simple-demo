package com.supertrampai.springbootsimpleexcel.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RestResponse {

	public RestResponse() {
		code = "0000";
		name = "SUCCESS";
		description = "业务操作成功";
	}

	@ApiModelProperty(value = "业务返回编码", name = "RSP_CODE", required = true)
	@JsonProperty("RSP_CODE")
	private String code;

	@ApiModelProperty(value = "业务返回名称", required = true)
	@JsonProperty("RSP_NAME")
	private String name;

	@ApiModelProperty(value = "业务返回描述", required = true)
	@JsonProperty("RSP_DESC")
	private String description;

	@ApiModelProperty(value = "业务返回结果，可以是单个对象，也可以是集合对象", name = "DATA")
	@JsonProperty("DATA")
	private Object data;

	@ApiModelProperty(value = "服务扩展数据，支持扩展，是一个对象", name = "ATTACH")
	@JsonProperty("ATTACH")
	private Object attach;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getAttach() {
		return attach;
	}

	public void setAttach(Object attach) {
		this.attach = attach;
	}
}
