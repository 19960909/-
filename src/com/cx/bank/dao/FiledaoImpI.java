


    package com.cx.bank.dao;


    import java.io.Serializable;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.Iterator;
    import java.util.List;
    import org.hibernate.LockMode;
    import org.hibernate.Query;
    import org.hibernate.Session;
    import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
    import com.cx.bank.model.AdminBean;
    import com.cx.bank.model.AdminLoginRecordBean;
    import com.cx.bank.model.AdminRecordBean;
    import com.cx.bank.model.MoneyBean;
    import com.cx.bank.model.UserBean;
    import com.cx.bank.model.UserLoginRecordBean;
    import com.cx.bank.util.DB;
    import com.cx.bank.util.ErrorCodeException;
    import com.cx.bank.util.InvalidDepositException;
    import com.cx.bank.util.MD5;
    import com.cx.bank.util.PageModel;
    import com.cx.bank.model.RecordBean;

   /**
    * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ�ĳ־ò�</DD></DL>
    * @version1.0 2018
    * @author 20152135
    * @param <blooean>
    *
    */


    public class FiledaoImpI extends HibernateDaoSupport implements  BankDaoInterface{
	
    	/*
    	 * �õ�ʱ��
    	 */
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String h = dateFormat.format(now);
	//System.out.println(h);
 
   MoneyBean moneybean = MoneyBean.getinstance();//��������ģ��
   UserBean user = null;
   AdminBean admin = null;
   MD5 md5 = new MD5();//�������ܶ���
   
   /*
    * �û�ע�᷽��
    * @see com.cx.bank.dao.BankDaoInterface#register(com.cx.bank.model.UserBean)
    */
 
   public boolean register(UserBean user){
	   
	   String mdpassword = md5.encode(user.getpassword().getBytes()); 
	   System.out.println("####"+user.getUserName());
	  
	   List query = this.getSession().createQuery("select s.UserName from UserBean s where s.UserName=?").setParameter(0, user.getUserName()).list();
	   Iterator iter=query.iterator();
	   if(iter.hasNext()){
		   return false;
	   }
	   else{
		   user.setpassword(mdpassword);
		   user.setTime(h);
		   this.getHibernateTemplate().save(user);
		   return true;
		 }
		
     }

   /*
    * �û����뷽��
    * @see com.cx.bank.dao.BankDaoInterface#user_login(java.lang.String, java.lang.String)
    */
 
    public boolean user_login(String username,String password) throws ErrorCodeException{
	
       System.out.println("####"+password);
       String mypassword1 = md5.encode(password.getBytes());
       
     	  List query = this.getSession().createQuery("select s.id from UserBean s where s.UserName=? and s.password=?").setString(0,username).setString(1,mypassword1).list();
     	   Iterator iter=query.iterator();
     	   if(iter.hasNext()){ 
     		   user = (UserBean)this.getHibernateTemplate().load(UserBean.class,(Serializable) iter.next(),LockMode.UPGRADE);
     		   if(user.getFrozen() == false){
     			  System.out.println("&&&&"+user.getFrozen());
        		   moneybean.setMoney(user.getMoney());
        		  add_login_Record(user.getUserName(),user.getpassword(),h,"����");//�ѵ���ļ�¼�浽�����ݿ���
        		   return true;
     		   }
     		   else{
     			  throw new ErrorCodeException("your.account.has.been.frozen");  
     		   }
     	   }
     	   else{
     		   return false;
     	   }   	   
}
    /*
     * ����Ա���뷽��
     * @see com.cx.bank.dao.BankDaoInterface#admin_login(java.lang.String, java.lang.String)
     */
    public boolean admin_login(String username,String password) {
    	
        System.out.println("####"+password);
        
      	  List query = this.getSession().createQuery("select s.id from AdminBean s where s.name=? and s.password=?").setString(0,username).setString(1,password).list();
      	   Iterator iter=query.iterator();
      	   if(iter.hasNext()){ 
      		 admin = (AdminBean)this.getHibernateTemplate().load(AdminBean.class,(Serializable) iter.next(),LockMode.UPGRADE);
      		  add_admin_login_Record(username,password,h,"����");//�ѵ���ļ�¼�浽�����ݿ���
      		   return true;
      	   }
      	   else{
      		   return false;
      	   }   	   
 }
    
  
    /*
     * ��ȡ�û����
     * @see com.cx.bank.dao.BankDaoInterface#Inquiry()
     */
    public double Inquiry() {
    	
    addRecord(user.getUserName(),"��ѯ���",moneybean.getMoney(),h);//��ȡ��ļ�¼�浽�����ݿ���	
	return moneybean.getMoney(); 
}

   /*
    * ȡ���
    * @see com.cx.bank.dao.BankDaoInterface#Withdrawals(double)
    */
   public double Withdrawals(double Withdrawalsmoney) throws ErrorCodeException{
	
			if(Withdrawalsmoney>moneybean.getMoney()) {//��ȡ����������ʱ�����������
				System.out.println("��������");
				throw new ErrorCodeException("withdrawal.failed.your.balance.is.insuffcient");					
				}//�����˻�͸֧�쳣
				else {
				    double money0 = moneybean.getMoney()-Withdrawalsmoney;//�õ�ȡ�������
				    moneybean.setMoney(money0);//���õ�moneybean��
					System.out.println(money0);
					 
						 System.out.println("@@@"+user.getUserName());
						 user.setMoney(money0);
				         this.getHibernateTemplate().update(user,LockMode.UPGRADE);
				         
				         addRecord(user.getUserName(),"ȡ��",Withdrawalsmoney,h);//��ȡ��ļ�¼�浽�����ݿ���
					 }
					 	
				
	return moneybean.getMoney();
	}


  /*
   * ����
   * @see com.cx.bank.dao.BankDaoInterface#Deposit(double)
   */

    public boolean Deposit(double Depositmoney) throws ErrorCodeException{
	
			
				 if(Depositmoney>0){
					    double money0 = moneybean.getMoney()+Depositmoney;//�õ���������
					    moneybean.setMoney(money0);
						System.out.println(money0);
						
							 System.out.println("@@@"+user.getUserName());
							 user.setMoney(money0);
					         this.getHibernateTemplate().update(user,LockMode.UPGRADE);
					         
					         addRecord(user.getUserName(),"���",Depositmoney,h);	//�Ѵ��ļ�¼�浽�����ݿ���
					         return true;
						 }
				 else{
					 return false; 
				 }	
				}
	
    
   /*
    * ת�˷���
    * @see com.cx.bank.dao.BankDaoInterface#transfer(java.lang.String, double)
    */
    public boolean transfer(String userName,double money)throws ErrorCodeException{
	
	if(user.getUserName().equals(userName) == true){//�ж��Ƿ����Լ�
		
		 throw new ErrorCodeException("you.can.not.transfer.money.to.yourself");
		//return false;
	}
	else{			
		if(money>moneybean.getMoney()){
		throw new ErrorCodeException("your.balance.is.insuffcient");//������Чת���쳣	
						            }
		else{
			 double money0 = moneybean.getMoney()-money;//�õ�ת�˺�����
			 moneybean.setMoney(money0);
		     	   List query = this.getSession().createQuery("select s.id from UserBean s where s.UserName=? ").setString(0,userName).list();
		     	   Iterator iter=query.iterator();
		     	   if(iter.hasNext()){ 
		     		  UserBean userbean = (UserBean)this.getHibernateTemplate().load(UserBean.class,(Serializable) iter.next(),LockMode.UPGRADE);
		     		   System.out.println("&&&&4444"+user.getMoney());
		     		   userbean.setMoney(userbean.getMoney()+money);
		     		   userbean.setId(userbean.getId());
		     		   this.getHibernateTemplate().update(userbean,LockMode.UPGRADE); 
		     		  this.Bank(money0);
		     		 addRecord(user.getUserName(),"ת��"+userName,money,h);//�Ѵ��ļ�¼�浽�����ݿ���
		     		  return true;
		     	   } 						   				  
			}
		return false;	
	}
	
}
		
/*
 * �洢����
 * @see com.cx.bank.dao.BankDaoInterface#Bank(double)
 */
public void Bank(double money){
	
		 System.out.println("@@@1111"+user.getUserName());
		 user.setMoney(money);
         this.getHibernateTemplate().update(user,LockMode.UPGRADE);
       
}

/*
 * ����û����׼�¼
 * @see com.cx.bank.dao.BankDaoInterface#addRecord(java.lang.String, java.lang.String, double, java.lang.String)
 */
public void addRecord(String name,String type,double rmoney,String time){
	  
		 //System.out.println("@@@"+user.getUserName());
		 RecordBean record = new RecordBean();
		 record.setName(name);
		 record.setType(type);
		 record.setRmoney(rmoney);
		 record.setTime(time);
		 record.setUserbean(user);
         this.getHibernateTemplate().save(record);
      
}

/*
 * ����û������¼
 * @see com.cx.bank.dao.BankDaoInterface#add_login_Record(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */

public void add_login_Record(String name,String password,String time,String type){
	  
		 System.out.println("@@@"+user.getUserName());
		 UserLoginRecordBean record = new UserLoginRecordBean();
		 record.setName(name);
		 record.setPassword(password);
		 record.setTime(time);
		 record.setType(type);
		 record.setUserbean(user);
         this.getHibernateTemplate().save(record);
      
}

/*
 * ��ӹ���Ա�����¼
 * @see com.cx.bank.dao.BankDaoInterface#add_admin_login_Record(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
public void add_admin_login_Record(String name,String password,String time,String type){
	  
	 AdminLoginRecordBean record = new AdminLoginRecordBean();
	 record.setName(name);
	 record.setPassword(password);
	 record.setTime(time);
	 record.setType(type);
	 record.setAdminbean(admin);
    this.getHibernateTemplate().save(record);
 
}

/*
 * ��ҳ��ѯ�û����׼�¼
 * @see com.cx.bank.dao.BankDaoInterface#findRecord(int, int)
 */

public PageModel findRecord(int pageNo, int pageSize)
{
	PageModel pageModel = null;
	
		   Query query = this.getSession().createQuery("from RecordBean as r where r.userbean.id=?").setInteger(0, user.getId());
		   List list = query.setFirstResult((pageNo - 1) * pageSize)
	 				 .setMaxResults(pageSize)
	 				 .list();
			//����pageModel���������ҳ���С����ǰҳ�棬��¼�������ڶ�����
			pageModel = new PageModel();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setList(list);
			pageModel.setTotalRecords(getTotalRecords());
			
	return pageModel;
	
}

/*
 * ��ѯ�û������ܼ�¼����
 * @see com.cx.bank.dao.BankDaoInterface#getTotalRecords()
 */
  public int getTotalRecords() {
   
	
	Query query = this.getSession().createQuery("select count(*) from RecordBean as r where r.name=?").setString(0,user.getUserName());
	Long totalRecords = (Long)query.uniqueResult();
	System.out.println("***"+totalRecords.intValue());
	return totalRecords.intValue();
  }
  
  
  /*
   * ��ҳ��ѯ�����û����׼�¼
   * @see com.cx.bank.dao.BankDaoInterface#find_user_Record(int, int)
   */

  public PageModel find_user_Record(int pageNo, int pageSize)
  {
  	PageModel pageModel = null;
  	
  		   Query query = this.getSession().createQuery("from RecordBean as r");
  		   List list = query.setFirstResult((pageNo - 1) * pageSize)
  	 				 .setMaxResults(pageSize)
  	 				 .list();
  			//����pageModel���������ҳ���С����ǰҳ�棬��¼�������ڶ�����
  			pageModel = new PageModel();
  			pageModel.setPageNo(pageNo);
  			pageModel.setPageSize(pageSize);
  			pageModel.setList(list);
  			pageModel.setTotalRecords(get_user_count());
  			
  	return pageModel;
  	
  }

  /*
   * ��ѯ�ܼ�¼����
   * @see com.cx.bank.dao.BankDaoInterface#get_user_count()
   */
    public int get_user_count() {
     
  	
  	Query query = this.getSession().createQuery("select count(*) from RecordBean as r");
  	Long totalRecords = (Long)query.uniqueResult();
  	System.out.println("***"+totalRecords.intValue());
  	return totalRecords.intValue();
    }
      
    /*
     * ��ҳ��ѯ����Ա�����¼
     * @see com.cx.bank.dao.BankDaoInterface#find_user_admin_Record(int, int)
     */
    public PageModel find_user_admin_Record(int pageNo, int pageSize)
    {
    	PageModel pageModel = null;
    	
    	 Query query = this.getSession().createQuery("from AdminRecordBean as r where r.adminbean.id=?").setInteger(0, admin.getId());
    		   List list = query.setFirstResult((pageNo - 1) * pageSize)
    	 				 .setMaxResults(pageSize)
    	 				 .list();
    			//����pageModel���������ҳ���С����ǰҳ�棬��¼�������ڶ�����
    			pageModel = new PageModel();
    			pageModel.setPageNo(pageNo);
    			pageModel.setPageSize(pageSize);
    			pageModel.setList(list);
    			pageModel.setTotalRecords(get_user_admin_count());
    			
    	return pageModel;
    	
    }

    /*
     * ��ѯ�ܼ�¼����
     * @see com.cx.bank.dao.BankDaoInterface#get_user_admin_count()
     */
      public int get_user_admin_count() {
       
    	
    	Query query = this.getSession().createQuery("select count(*) from AdminRecordBean as r where r.adminname=?").setString(0, admin.getName());
    	Long totalRecords = (Long)query.uniqueResult();
    	System.out.println("***"+totalRecords.intValue());
    	return totalRecords.intValue();
      }
        
    
    
  
    /*
     * ��ҳ��ѯ�û�ע���¼
     * @see com.cx.bank.dao.BankDaoInterface#find_user_register_Record(int, int)
     */

    public PageModel find_user_register_Record(int pageNo, int pageSize)
    {
    	PageModel pageModel = null;
    	
    		   Query query = this.getSession().createQuery("from UserBean as r");
    		   List list = query.setFirstResult((pageNo - 1) * pageSize)
    	 				 .setMaxResults(pageSize)
    	 				 .list();
    			//����pageModel���������ҳ���С����ǰҳ�棬��¼�������ڶ�����
    			pageModel = new PageModel();
    			pageModel.setPageNo(pageNo);
    			pageModel.setPageSize(pageSize);
    			pageModel.setList(list);
    			pageModel.setTotalRecords(get_user_register_count());
    			
    			Iterator iter=list.iterator();
    			if(iter.hasNext()){
    				UserBean user = (UserBean) iter.next();
    				pageModel.setId(user.getId());
    			}
    			
    	return pageModel;
    	
    }

    /*
     * ��ѯ�ܼ�¼����
     * @see com.cx.bank.dao.BankDaoInterface#get_user_register_count()
     */
      public int get_user_register_count() {
       
    	Query query = this.getSession().createQuery("select count(*) from UserBean as r");
    	Long totalRecords = (Long)query.uniqueResult();
    	System.out.println("***"+totalRecords.intValue());
    	return totalRecords.intValue();
      }
  
  /*
   * ����Ա�����˻�����
   * @see com.cx.bank.dao.BankDaoInterface#frozen(int)
   */
  public void frozen(int id){
	  
	  List query =  this.getSession().createQuery("select s.id from UserBean s where s.id=?").setInteger(0,id).list();
	   Iterator iter=query.iterator();
	   if(iter.hasNext()){ 
		  UserBean user = (UserBean)this.getHibernateTemplate().load(UserBean.class,(Serializable) iter.next(),LockMode.UPGRADE); 
		  System.out.println("****"+user.getFrozen());
		  user.setFrozen(true);
		  this.getHibernateTemplate().save(user);
   		  add_admin_Record(admin.getName(),"����",user.getUserName(),user.getpassword(),user.getMoney(),h);//��ȡ��ļ�¼�浽�����ݿ���
   		  
		   }
  }
  
  /*
   * ����Ա����˻�����
   * @see com.cx.bank.dao.BankDaoInterface#deblocking(int)
   */
public void deblocking(int id){
	  
	  List query =  this.getSession().createQuery("select s.id from UserBean s where s.id=?").setInteger(0,id).list();
	   Iterator iter=query.iterator();
	   if(iter.hasNext()){ 
		  UserBean user = (UserBean)this.getHibernateTemplate().load(UserBean.class,(Serializable) iter.next(),LockMode.UPGRADE); 
		  user.setFrozen(false);
		  this.getHibernateTemplate().save(user);
		  add_admin_Record(admin.getName(),"���",user.getUserName(),user.getpassword(),user.getMoney(),h);//��ȡ��ļ�¼�浽�����ݿ���
   		  
		   }
  }


/*
 * ��ӹ���Ա�޸ļ�¼����
 * @see com.cx.bank.dao.BankDaoInterface#add_admin_Record(java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, java.lang.String)
 */
public void add_admin_Record(String admin_name,String type,String user_name,String user_password,double user_money,String time){
	
	AdminRecordBean record = new AdminRecordBean();
	record.setAdminname(admin_name);
	record.setType(type);
	record.setUsername(user_name);
	record.setUserpassword(user_password);
	record.setUsermoney(String.valueOf(user_money));
	record.setTime(time);
	record.setAdminbean(admin);
	this.getHibernateTemplate().save(record);
	
}
  
  
/*
 * ��ҳ��ѯ�û������¼
 * @see com.cx.bank.dao.BankDaoInterface#find_user_login_Record(int, int)
 */

public PageModel find_user_login_Record(int pageNo, int pageSize)
{
	PageModel pageModel = null;
	
		   Query query = this.getSession().createQuery("from UserLoginRecordBean as r");
		   List list = query.setFirstResult((pageNo - 1) * pageSize)
	 				 .setMaxResults(pageSize)
	 				 .list();
			//����pageModel���������ҳ���С����ǰҳ�棬��¼�������ڶ�����
			pageModel = new PageModel();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setList(list);
			pageModel.setTotalRecords(get_user_login_count());
			
	return pageModel;
	
}

/*
 * ��ѯ�ܼ�¼����
 * @see com.cx.bank.dao.BankDaoInterface#get_user_login_count()
 */
  public int get_user_login_count() {
   
	
	Query query = this.getSession().createQuery("select count(*) from UserLoginRecordBean as r");
	Long totalRecords = (Long)query.uniqueResult();
	System.out.println("***33333"+totalRecords.intValue());
	return totalRecords.intValue();
  } 
  
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		





