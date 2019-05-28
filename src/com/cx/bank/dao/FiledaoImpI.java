


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
    * <DL><DT><b>功能：</b><DD>银行管理系统的持久层</DD></DL>
    * @version1.0 2018
    * @author 20152135
    * @param <blooean>
    *
    */


    public class FiledaoImpI extends HibernateDaoSupport implements  BankDaoInterface{
	
    	/*
    	 * 得到时间
    	 */
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String h = dateFormat.format(now);
	//System.out.println(h);
 
   MoneyBean moneybean = MoneyBean.getinstance();//创建单例模型
   UserBean user = null;
   AdminBean admin = null;
   MD5 md5 = new MD5();//创建加密对象
   
   /*
    * 用户注册方法
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
    * 用户登入方法
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
        		  add_login_Record(user.getUserName(),user.getpassword(),h,"登入");//把登入的记录存到在数据库中
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
     * 管理员登入方法
     * @see com.cx.bank.dao.BankDaoInterface#admin_login(java.lang.String, java.lang.String)
     */
    public boolean admin_login(String username,String password) {
    	
        System.out.println("####"+password);
        
      	  List query = this.getSession().createQuery("select s.id from AdminBean s where s.name=? and s.password=?").setString(0,username).setString(1,password).list();
      	   Iterator iter=query.iterator();
      	   if(iter.hasNext()){ 
      		 admin = (AdminBean)this.getHibernateTemplate().load(AdminBean.class,(Serializable) iter.next(),LockMode.UPGRADE);
      		  add_admin_login_Record(username,password,h,"登入");//把登入的记录存到在数据库中
      		   return true;
      	   }
      	   else{
      		   return false;
      	   }   	   
 }
    
  
    /*
     * 获取用户余额
     * @see com.cx.bank.dao.BankDaoInterface#Inquiry()
     */
    public double Inquiry() {
    	
    addRecord(user.getUserName(),"查询余额",moneybean.getMoney(),h);//把取款的记录存到在数据库中	
	return moneybean.getMoney(); 
}

   /*
    * 取款方法
    * @see com.cx.bank.dao.BankDaoInterface#Withdrawals(double)
    */
   public double Withdrawals(double Withdrawalsmoney) throws ErrorCodeException{
	
			if(Withdrawalsmoney>moneybean.getMoney()) {//当取款金额大于余额时输出您的余额不足
				System.out.println("您的余额不足");
				throw new ErrorCodeException("withdrawal.failed.your.balance.is.insuffcient");					
				}//捕获账户透支异常
				else {
				    double money0 = moneybean.getMoney()-Withdrawalsmoney;//得到取款后的余额
				    moneybean.setMoney(money0);//设置到moneybean中
					System.out.println(money0);
					 
						 System.out.println("@@@"+user.getUserName());
						 user.setMoney(money0);
				         this.getHibernateTemplate().update(user,LockMode.UPGRADE);
				         
				         addRecord(user.getUserName(),"取款",Withdrawalsmoney,h);//把取款的记录存到在数据库中
					 }
					 	
				
	return moneybean.getMoney();
	}


  /*
   * 存款方法
   * @see com.cx.bank.dao.BankDaoInterface#Deposit(double)
   */

    public boolean Deposit(double Depositmoney) throws ErrorCodeException{
	
			
				 if(Depositmoney>0){
					    double money0 = moneybean.getMoney()+Depositmoney;//得到存款后的余额
					    moneybean.setMoney(money0);
						System.out.println(money0);
						
							 System.out.println("@@@"+user.getUserName());
							 user.setMoney(money0);
					         this.getHibernateTemplate().update(user,LockMode.UPGRADE);
					         
					         addRecord(user.getUserName(),"存款",Depositmoney,h);	//把存款的记录存到在数据库中
					         return true;
						 }
				 else{
					 return false; 
				 }	
				}
	
    
   /*
    * 转账方法
    * @see com.cx.bank.dao.BankDaoInterface#transfer(java.lang.String, double)
    */
    public boolean transfer(String userName,double money)throws ErrorCodeException{
	
	if(user.getUserName().equals(userName) == true){//判断是否是自己
		
		 throw new ErrorCodeException("you.can.not.transfer.money.to.yourself");
		//return false;
	}
	else{			
		if(money>moneybean.getMoney()){
		throw new ErrorCodeException("your.balance.is.insuffcient");//捕获无效转账异常	
						            }
		else{
			 double money0 = moneybean.getMoney()-money;//得到转账后的余额
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
		     		 addRecord(user.getUserName(),"转给"+userName,money,h);//把存款的记录存到在数据库中
		     		  return true;
		     	   } 						   				  
			}
		return false;	
	}
	
}
		
/*
 * 存储余额方法
 * @see com.cx.bank.dao.BankDaoInterface#Bank(double)
 */
public void Bank(double money){
	
		 System.out.println("@@@1111"+user.getUserName());
		 user.setMoney(money);
         this.getHibernateTemplate().update(user,LockMode.UPGRADE);
       
}

/*
 * 添加用户交易记录
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
 * 添加用户登入记录
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
 * 添加管理员登入记录
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
 * 分页查询用户交易记录
 * @see com.cx.bank.dao.BankDaoInterface#findRecord(int, int)
 */

public PageModel findRecord(int pageNo, int pageSize)
{
	PageModel pageModel = null;
	
		   Query query = this.getSession().createQuery("from RecordBean as r where r.userbean.id=?").setInteger(0, user.getId());
		   List list = query.setFirstResult((pageNo - 1) * pageSize)
	 				 .setMaxResults(pageSize)
	 				 .list();
			//创建pageModel对象把链表，页面大小，当前页面，记录总数放在对象中
			pageModel = new PageModel();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setList(list);
			pageModel.setTotalRecords(getTotalRecords());
			
	return pageModel;
	
}

/*
 * 查询用户交易总记录条数
 * @see com.cx.bank.dao.BankDaoInterface#getTotalRecords()
 */
  public int getTotalRecords() {
   
	
	Query query = this.getSession().createQuery("select count(*) from RecordBean as r where r.name=?").setString(0,user.getUserName());
	Long totalRecords = (Long)query.uniqueResult();
	System.out.println("***"+totalRecords.intValue());
	return totalRecords.intValue();
  }
  
  
  /*
   * 分页查询所有用户交易记录
   * @see com.cx.bank.dao.BankDaoInterface#find_user_Record(int, int)
   */

  public PageModel find_user_Record(int pageNo, int pageSize)
  {
  	PageModel pageModel = null;
  	
  		   Query query = this.getSession().createQuery("from RecordBean as r");
  		   List list = query.setFirstResult((pageNo - 1) * pageSize)
  	 				 .setMaxResults(pageSize)
  	 				 .list();
  			//创建pageModel对象把链表，页面大小，当前页面，记录总数放在对象中
  			pageModel = new PageModel();
  			pageModel.setPageNo(pageNo);
  			pageModel.setPageSize(pageSize);
  			pageModel.setList(list);
  			pageModel.setTotalRecords(get_user_count());
  			
  	return pageModel;
  	
  }

  /*
   * 查询总记录条数
   * @see com.cx.bank.dao.BankDaoInterface#get_user_count()
   */
    public int get_user_count() {
     
  	
  	Query query = this.getSession().createQuery("select count(*) from RecordBean as r");
  	Long totalRecords = (Long)query.uniqueResult();
  	System.out.println("***"+totalRecords.intValue());
  	return totalRecords.intValue();
    }
      
    /*
     * 分页查询管理员登入记录
     * @see com.cx.bank.dao.BankDaoInterface#find_user_admin_Record(int, int)
     */
    public PageModel find_user_admin_Record(int pageNo, int pageSize)
    {
    	PageModel pageModel = null;
    	
    	 Query query = this.getSession().createQuery("from AdminRecordBean as r where r.adminbean.id=?").setInteger(0, admin.getId());
    		   List list = query.setFirstResult((pageNo - 1) * pageSize)
    	 				 .setMaxResults(pageSize)
    	 				 .list();
    			//创建pageModel对象把链表，页面大小，当前页面，记录总数放在对象中
    			pageModel = new PageModel();
    			pageModel.setPageNo(pageNo);
    			pageModel.setPageSize(pageSize);
    			pageModel.setList(list);
    			pageModel.setTotalRecords(get_user_admin_count());
    			
    	return pageModel;
    	
    }

    /*
     * 查询总记录条数
     * @see com.cx.bank.dao.BankDaoInterface#get_user_admin_count()
     */
      public int get_user_admin_count() {
       
    	
    	Query query = this.getSession().createQuery("select count(*) from AdminRecordBean as r where r.adminname=?").setString(0, admin.getName());
    	Long totalRecords = (Long)query.uniqueResult();
    	System.out.println("***"+totalRecords.intValue());
    	return totalRecords.intValue();
      }
        
    
    
  
    /*
     * 分页查询用户注册记录
     * @see com.cx.bank.dao.BankDaoInterface#find_user_register_Record(int, int)
     */

    public PageModel find_user_register_Record(int pageNo, int pageSize)
    {
    	PageModel pageModel = null;
    	
    		   Query query = this.getSession().createQuery("from UserBean as r");
    		   List list = query.setFirstResult((pageNo - 1) * pageSize)
    	 				 .setMaxResults(pageSize)
    	 				 .list();
    			//创建pageModel对象把链表，页面大小，当前页面，记录总数放在对象中
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
     * 查询总记录条数
     * @see com.cx.bank.dao.BankDaoInterface#get_user_register_count()
     */
      public int get_user_register_count() {
       
    	Query query = this.getSession().createQuery("select count(*) from UserBean as r");
    	Long totalRecords = (Long)query.uniqueResult();
    	System.out.println("***"+totalRecords.intValue());
    	return totalRecords.intValue();
      }
  
  /*
   * 管理员冻结账户方法
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
   		  add_admin_Record(admin.getName(),"冻结",user.getUserName(),user.getpassword(),user.getMoney(),h);//把取款的记录存到在数据库中
   		  
		   }
  }
  
  /*
   * 管理员解封账户方法
   * @see com.cx.bank.dao.BankDaoInterface#deblocking(int)
   */
public void deblocking(int id){
	  
	  List query =  this.getSession().createQuery("select s.id from UserBean s where s.id=?").setInteger(0,id).list();
	   Iterator iter=query.iterator();
	   if(iter.hasNext()){ 
		  UserBean user = (UserBean)this.getHibernateTemplate().load(UserBean.class,(Serializable) iter.next(),LockMode.UPGRADE); 
		  user.setFrozen(false);
		  this.getHibernateTemplate().save(user);
		  add_admin_Record(admin.getName(),"解封",user.getUserName(),user.getpassword(),user.getMoney(),h);//把取款的记录存到在数据库中
   		  
		   }
  }


/*
 * 添加管理员修改记录方法
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
 * 分页查询用户登入记录
 * @see com.cx.bank.dao.BankDaoInterface#find_user_login_Record(int, int)
 */

public PageModel find_user_login_Record(int pageNo, int pageSize)
{
	PageModel pageModel = null;
	
		   Query query = this.getSession().createQuery("from UserLoginRecordBean as r");
		   List list = query.setFirstResult((pageNo - 1) * pageSize)
	 				 .setMaxResults(pageSize)
	 				 .list();
			//创建pageModel对象把链表，页面大小，当前页面，记录总数放在对象中
			pageModel = new PageModel();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setList(list);
			pageModel.setTotalRecords(get_user_login_count());
			
	return pageModel;
	
}

/*
 * 查询总记录条数
 * @see com.cx.bank.dao.BankDaoInterface#get_user_login_count()
 */
  public int get_user_login_count() {
   
	
	Query query = this.getSession().createQuery("select count(*) from UserLoginRecordBean as r");
	Long totalRecords = (Long)query.uniqueResult();
	System.out.println("***33333"+totalRecords.intValue());
	return totalRecords.intValue();
  } 
  
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		





