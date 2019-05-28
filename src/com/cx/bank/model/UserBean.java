

package com.cx.bank.model;

import java.util.Set;

/**
 * <DL><DT><b>功能：</b><DD>银行管理系统的模型层</DD></DL>
 * @version1.0 2018
 * @author 20152135
 *
 */

     public class UserBean {
	 private int id;//定义主键
	 private String UserName;//定义用户名
	 private String password;//定义用户密码
	 private double money;//定义余额
	 private String time;//定义时间
	 private boolean frozen;//定义冻结字段
	 private Set record;//映射属性
	// private static UserBean instance;//定义静态全局变量
	 
	//私有的构造方法
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
	 
	 //得到用户密码
	 public String getpassword() {
		 return this.password;
	 }
	 
	 //设置用户密码
	 public void setpassword(String password) {
		 this.password = password;
	 }
	 
	 //得到用户余额
	 public double getMoney() {
		 return this.money;
	 }
	 
	 //设置用户余额
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

	 
	//定义静态方法，得到instance变量地址
	// public static UserBean getinstance() {
		 //if(instance == null) {
			// instance = new UserBean();
		// }
		 //return instance;
	// }
}

