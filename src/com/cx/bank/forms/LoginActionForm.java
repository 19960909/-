


    package com.cx.bank.forms;

    import org.apache.struts.action.ActionForm;
    
    /**
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��LoginActionForm</DD></DL>
     * ���й���ϵͳ3.0Struts�汾
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */

    public class LoginActionForm extends ActionForm{

    private String username;//���ռ����û���
	
	private String password;//���ռ�������
	
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
