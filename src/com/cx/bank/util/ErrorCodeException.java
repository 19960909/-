


    package com.cx.bank.util;
    
    /**
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ���쳣����</DD></DL>
     * ���й���ϵͳ3.0Struts�汾
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */

   public class ErrorCodeException extends RuntimeException {
	
	private String errorCode;//�õ��쳣����
	
	private Object[] args;//�õ��쳣��Ϣ
	
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
