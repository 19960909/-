


      package com.cx.bank.model;
      
      /**
       * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ģ�Ͳ�</DD></DL>
       * @version1.0 2018
       * @author 20152135
       *
       */

      public class AdminRecordBean {

	   private int id;//��������
	   
	   private String adminname;//�������Ա����

	   private String type;//�����¼����
	   
	   private String username;//�����û���
	   
	   private String userpassword;//�����û�����
	   
	   private String usermoney;//�����û�����
	   
	   private String time;//����ʱ��
	   
	   private AdminBean adminbean;//�����������

	   public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUserpassword() {
			return userpassword;
		}

		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
		}

		public String getUsermoney() {
			return usermoney;
		}

		public void setUsermoney(String usermoney) {
			this.usermoney = usermoney;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public AdminBean getAdminbean() {
			return adminbean;
		}
		 public String getAdminname() {
				return adminname;
			}

			public void setAdminname(String adminname) {
				this.adminname = adminname;
			}

			public void setAdminbean(AdminBean adminbean) {
				this.adminbean = adminbean;
			}

}
