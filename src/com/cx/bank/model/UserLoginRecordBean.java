


   package com.cx.bank.model;
   
   /**
    * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ģ�Ͳ�</DD></DL>
    * @version1.0 2018
    * @author 20152135
    *
    */

   public class UserLoginRecordBean {
	
	private int id;//��������
	
	private String name;//�����û���
	
	private String password;//�����û�����
	
	private String time;//����ʱ��
	
	private String type;//�����¼����

	private UserBean userbean;//�����������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

}
