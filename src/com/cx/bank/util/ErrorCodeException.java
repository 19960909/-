


    package com.cx.bank.util;
    
    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的异常处理</DD></DL>
     * 银行管理系统3.0Struts版本
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */

   public class ErrorCodeException extends RuntimeException {
	
	private String errorCode;//得到异常类型
	
	private Object[] args;//得到异常信息
	
	public ErrorCodeException(String errorCode) {
		this(errorCode, null);
	}
	
	public ErrorCodeException(String errorCode, Object args0) {
		this(errorCode, new Object[]{args0});
	}
	
	public ErrorCodeException(String errorCode, Object[] args) {
		this.errorCode = errorCode;
		this.args = args;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public Object[] getArgs() {
		return args;
	}
}
