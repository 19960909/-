


   package com.cx.bank.model;

   import java.util.Set;

   /**
    * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ģ�Ͳ�</DD></DL>
    * @version1.0 2018
    * @author 20152135
    *
    */
   
   public class AdminBean {
	
	private int id;//��������
	
	private String name;//�������Ա����
	
	private String password;//�������Ա����
	
	private Set adminrecord;//ӳ������
	
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
