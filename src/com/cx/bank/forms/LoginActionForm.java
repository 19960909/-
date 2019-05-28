


    package com.cx.bank.forms;

    import org.apache.struts.action.ActionForm;
    
    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的LoginActionForm</DD></DL>
     * 银行管理系统3.0Struts版本
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */

    public class LoginActionForm extends ActionForm{

    private String username;//表单收集的用户名
	
	private String password;//表单收集的密码
	
	private String id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
