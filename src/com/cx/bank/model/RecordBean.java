


    package com.cx.bank.model;

    import java.util.Date;
    
    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的RecordBean</DD></DL>
     * 银行管理系统3.0Struts版本
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */

    public class RecordBean {
    
	private int id;//定义记录id
	
    private String name;//定义用户名
	
	private String type;//定义记录类型
	
	private double rmoney;//定义记录金额
	
	private String time;//定义记录时间
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRmoney() {
		return rmoney;
	}

	public void setRmoney(double rmoney) {
		this.rmoney = rmoney;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString(){
		return  "第"+ id + "条记录:"     + "用户名:" + name +  "         交易类型:" +  type +"       交易金额:" +  rmoney  +  "     交易时间:" +time;                         
	}
	
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	
}
