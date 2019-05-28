


      package com.cx.bank.model;
      
      /**
       * <DL><DT><b>功能：</b><DD>银行管理系统的模型层</DD></DL>
       * @version1.0 2018
       * @author 20152135
       *
       */

      public class AdminRecordBean {

	   private int id;//定义主键
	   
	   private String adminname;//定义管理员名字

	   private String type;//定义记录类型
	   
	   private String username;//定义用户名
	   
	   private String userpassword;//定义用户密码
	   
	   private String usermoney;//定义用户密码
	   
	   private String time;//定义时间
	   
	   private AdminBean adminbean;//定义关联属性

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
