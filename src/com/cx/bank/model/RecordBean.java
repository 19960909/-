


    package com.cx.bank.model;

    import java.util.Date;
    
    /**
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��RecordBean</DD></DL>
     * ���й���ϵͳ3.0Struts�汾
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */

    public class RecordBean {
    
	private int id;//�����¼id
	
    private String name;//�����û���
	
	private String type;//�����¼����
	
	private double rmoney;//�����¼���
	
	private String time;//�����¼ʱ��
	
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
		return  "��"+ id + "����¼:"     + "�û���:" + name +  "         ��������:" +  type +"       ���׽��:" +  rmoney  +  "     ����ʱ��:" +time;                         
	}
	
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	
}
