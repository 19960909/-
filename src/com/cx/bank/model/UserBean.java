

package com.cx.bank.model;

import java.util.Set;

/**
 * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ģ�Ͳ�</DD></DL>
 * @version1.0 2018
 * @author 20152135
 *
 */

     public class UserBean {
	 private int id;//��������
	 private String UserName;//�����û���
	 private String password;//�����û�����
	 private double money;//�������
	 private String time;//����ʱ��
	 private boolean frozen;//���嶳���ֶ�
	 private Set record;//ӳ������
	// private static UserBean instance;//���徲̬ȫ�ֱ���
	 
	//˽�еĹ��췽��
	// private UserBean() {
		 
	// }
	 
	 public int getId() {
			return id;
		}

	 public void setId(int id) {
			this.id = id;
		}
		
	  public Set getRecord() {
			return record;
		}

	  public void setRecord(Set record) {
			this.record = record;
		}	
	 
	  public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
		}
	 
	 //�õ��û�����
	 public String getpassword() {
		 return this.password;
	 }
	 
	 //�����û�����
	 public void setpassword(String password) {
		 this.password = password;
	 }
	 
	 //�õ��û����
	 public double getMoney() {
		 return this.money;
	 }
	 
	 //�����û����
	 public void setMoney(double money) {
		 this.money = money;
	 }
	 
	 public boolean getFrozen() {
			return frozen;
		}

	public void setFrozen(boolean frozen) {
			this.frozen = frozen;
		}
	
	 public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

	 
	//���徲̬�������õ�instance������ַ
	// public static UserBean getinstance() {
		 //if(instance == null) {
			// instance = new UserBean();
		// }
		 //return instance;
	// }
}

