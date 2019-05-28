


   package com.cx.bank.model;

   import java.util.Set;

   /**
    * <DL><DT><b>功能：</b><DD>银行管理系统的模型层</DD></DL>
    * @version1.0 2018
    * @author 20152135
    *
    */
   
   public class AdminBean {
	
	private int id;//定义主键
	
	private String name;//定义管理员名字
	
	private String password;//定义管理员密码
	
	private Set adminrecord;//映射属性
	
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

	public Set getAdminrecord() {
		return adminrecord;
	}

	public void setAdminrecord(Set adminrecord) {
		this.adminrecord = adminrecord;
	}


    }
