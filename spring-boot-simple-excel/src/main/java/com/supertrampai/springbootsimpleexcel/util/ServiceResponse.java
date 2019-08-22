package com.supertrampai.springbootsimpleexcel.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ServiceResponse {

	public ServiceResponse() {
		status = "0000";
		msg = "SUCCESS";

		this.rsp = new RestResponse();
	}

	@ApiModelProperty(value = "系统状态码", name = "STATUS", required = true)
	@JsonProperty("STATUS")
	private String status;

	@ApiModelProperty(value = "系统状态描述", name = "MSG", required = true)
	@JsonProperty("MSG")
	private String msg;

	@ApiModelProperty(value = "操作流水号，全局唯一，由微服务平台生成", name = "TXID", required = true)
	@JsonProperty("TXID")
	private String txid;

	@ApiModelProperty(value = "业务返回对象", name = "RSP", required = true)
	@JsonProperty("RSP")
	private RestResponse rsp;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public RestResponse getRsp() {
        return rsp;
    }

    public void setRsp(RestResponse rsp) {
        this.rsp = rsp;
    }
}
