package com.cx.bank.manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cx.bank.dao.BankDaoInterface;
import com.cx.bank.dao.FiledaoImpI;
import com.cx.bank.model.AdminBean;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.ErrorCodeException;
import com.cx.bank.util.InvalidDepositException;
import com.cx.bank.util.PageModel;

/**
 * <DL><DT><b>功能：</b><DD>银行管理系统的业务层</DD></DL>
 * @version1.0 2018
 * @author 20152135
 * @param <blooean>
 *
 */

//实现接口
public class ManagerImpI extends HibernateDaoSupport implements ManagerImInterface{
private BankDaoInterface userDao ;
 
public void setUserDao(BankDaoInterface userDao) {
	this.userDao = userDao;
}
 
//通过单例模式用类的静态绑定来创建MoneyBean类型对象moneybean
 MoneyBean moneybean = MoneyBean.getinstance();
//通过单例模式用类的静态绑定来创建 UserBean类型对象user
 UserBean user = new UserBean();
 
 /*
  * 用户注册方法
  * @see com.cx.bank.manager.ManagerImInterface#register(com.cx.bank.model.UserBean)
  */
 
 public boolean register(UserBean user) throws ErrorCodeException{
	 
	
		 boolean flag = userDao.register(user);//调用持久层的注册方法
		 
		 if(flag == false){
			 throw new ErrorCodeException("registration.failed.the.user.already.exists");
		 }
		 return flag;
	 
	 
 }
 
 /*
  * 用户登入方法
  * @see com.cx.bank.manager.ManagerImInterface#user_login(com.cx.bank.model.UserBean)
  */
 public boolean user_login(UserBean user) throws ErrorCodeException{
	 
	
		 boolean flag = userDao.user_login(user.getUserName(), user.getpassword()); //调用持久层的登入方法
		
		 if(flag == false){
			 throw new ErrorCodeException("user.login.error");
		 }
		 return flag; 
 }
 
 /*
  * 管理员登入方法
  * @see com.cx.bank.manager.ManagerImInterface#admin_login(com.cx.bank.model.AdminBean)
  */
 public boolean admin_login(AdminBean admin) throws ErrorCodeException{
	 
		
	 boolean flag = userDao.admin_login(admin.getName(), admin.getPassword()); //调用持久层的登入方法
	
	 if(flag == false){
		 throw new ErrorCodeException("user.login.error");
	 }
	 return flag; 
}
 
 
 /*
  * 查询余额方法
  * @see com.cx.bank.manager.ManagerImInterface#Inquiry()
  */
 
 public double Inquiry(){
	 
	  double money = userDao.Inquiry();//调用持久层的查询余额方法
	 moneybean.setMoney(money); 
	 return money;
 }
 

 /*
  * 取款方法
  * @see com.cx.bank.manager.ManagerImInterface#Withdrawals(double)
  */
 public double Withdrawals(double Withdrawalsmoney) throws ErrorCodeException {
	 
	 if(Withdrawalsmoney<=0){
		 throw new ErrorCodeException("your.withdrawal.amount.is.incorrect"); 
	 }
	 if(Withdrawalsmoney>moneybean.getMoney()){
		 System.out.println("取款失败");
		throw new ErrorCodeException("withdrawal.failed.your.balance.is.insuffcient");
	 }
	 else{
		 userDao.Withdrawals(Withdrawalsmoney);//调用持久层的取款方法
	 }
	 return moneybean.getMoney();
 
 }
 
 
 /*
  * 存款方法
  * @see com.cx.bank.manager.ManagerImInterface#Deposit(double)
  */
 public boolean Deposit(double Depositmoney)throws ErrorCodeException{
	 if(Depositmoney<=0){
		 throw new ErrorCodeException("deposit.failed.your.deposit.amount.error");
	 }
	 boolean flag = userDao.Deposit(Depositmoney);//调用持久层的存款方法
	 return flag;
 }
 
 /*
  * 查询用户交易记录方法
  * @see com.cx.bank.manager.ManagerImInterface#findRecord(int, int)
  */
 
 public PageModel findRecord(int pageNo, int pageSize){
	 
	 PageModel pagemodel = userDao.findRecord(pageNo, pageSize);//调用持久层的查询记录方法
	 
	 return pagemodel;
 }
 
 /*
  *查询所有用户交易记录方法
  * @see com.cx.bank.manager.ManagerImInterface#find_user_Record(int, int)
  */
 public PageModel find_user_Record(int pageNo, int pageSize){
	 
     PageModel pagemodel = userDao.find_user_Record(pageNo, pageSize);//调用持久层的查询记录方法
	 
	 return pagemodel;
 }
 
 /*
  * //分页查询管理员修改记录方法
  * @see com.cx.bank.manager.ManagerImInterface#find_user_admin_Record(int, int)
  */
public PageModel find_user_admin_Record(int pageNo, int pageSize){
	 
     PageModel pagemodel = userDao.find_user_admin_Record(pageNo, pageSize);//调用持久层的查询记录方法
	 
	 return pagemodel;
 }
 
/*
 * 查询用户注册方法
 * @see com.cx.bank.manager.ManagerImInterface#find_user_register_Record(int, int)
 */
 public PageModel find_user_register_Record(int pageNo, int pageSize){
	 
      PageModel pagemodel = userDao.find_user_register_Record(pageNo, pageSize);//调用持久层的查询记录方法
	 
	 return pagemodel;
 }
 
 /*
  * 查询用户登入方法
  * @see com.cx.bank.manager.ManagerImInterface#find_user_login_Record(int, int)
  */
 public PageModel find_user_login_Record(int pageNo, int pageSize){
	 
     PageModel pagemodel = userDao.find_user_login_Record(pageNo, pageSize);//调用持久层的查询记录方法
	 
	 return pagemodel;
}
 
 
 /*
  * 管理员冻结账户方法
  * @see com.cx.bank.manager.ManagerImInterface#frozen(int)
  */
 public void frozen(int id){
	 
	 userDao.frozen(id);
	 
 }
 
 /*
  * 管理员解封账户方法
  * @see com.cx.bank.manager.ManagerImInterface#deblocking(int)
  */
 public void deblocking(int id){
	 
	 userDao.deblocking(id);
 }
 
 /*
  * 转账方法
  * @see com.cx.bank.manager.ManagerImInterface#transfer(java.lang.String, double)
  */
 public boolean transfer(String userName,double money)throws ErrorCodeException{
	 
	 if(money<=0){
		 throw new ErrorCodeException("your.transfer.amount.is.wrong");
	 }
	 if(money>moneybean.getMoney()){
		 throw new ErrorCodeException("your.balance.is.insuffcient");//捕获无效转账异常
	 }
	 if(userName.equals(user.getUserName())){
		 throw new ErrorCodeException("you.can.not.transfer.money.to.yourself");
	 }
	 else{
		 
		 boolean flag = userDao.transfer(userName, money);//调用持久层的转账方法
		 if(flag == false){
			 throw new ErrorCodeException("the.transfer.username.does.not.exist",userName); 
		 }
		 userDao.Bank(moneybean.getMoney());
		 return flag;
	 }
 }
 
 /**
  * 退出系统方法
  */
 public void ExitSystem() {
 	System.out.println("欢迎下次使用");
 	userDao.Bank(moneybean.getMoney());//退出就将余额存入用户账户里
 	System.out.println(moneybean.getMoney());
 }
 	   
 }
  