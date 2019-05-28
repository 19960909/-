


   package com.cx.bank.model;
   
   /**
    * <DL><DT><b>功能：</b><DD>银行管理系统的模型层</DD></DL>
    * @version1.0 2018
    * @author 20152135
    *
    */

   public class UserLoginRecordBean {
	
	private int id;//定义主键
	
	private String name;//定义用户名
	
	private String password;//定义用户密码
	
	private String time;//定义时间
	
	private String type;//定义记录类型

	private UserBean userbean;//定义关联属性

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
