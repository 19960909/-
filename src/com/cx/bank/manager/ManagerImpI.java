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
 * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ҵ���</DD></DL>
 * @version1.0 2018
 * @author 20152135
 * @param <blooean>
 *
 */

//ʵ�ֽӿ�
public class ManagerImpI extends HibernateDaoSupport implements ManagerImInterface{
private BankDaoInterface userDao ;
 
public void setUserDao(BankDaoInterface userDao) {
	this.userDao = userDao;
}
 
//ͨ������ģʽ����ľ�̬��������MoneyBean���Ͷ���moneybean
 MoneyBean moneybean = MoneyBean.getinstance();
//ͨ������ģʽ����ľ�̬�������� UserBean���Ͷ���user
 UserBean user = new UserBean();
 
 /*
  * �û�ע�᷽��
  * @see com.cx.bank.manager.ManagerImInterface#register(com.cx.bank.model.UserBean)
  */
 
 public boolean register(UserBean user) throws ErrorCodeException{
	 
	
		 boolean flag = userDao.register(user);//���ó־ò��ע�᷽��
		 
		 if(flag == false){
			 throw new ErrorCodeException("registration.failed.the.user.already.exists");
		 }
		 return flag;
	 
	 
 }
 
 /*
  * �û����뷽��
  * @see com.cx.bank.manager.ManagerImInterface#user_login(com.cx.bank.model.UserBean)
  */
 public boolean user_login(UserBean user) throws ErrorCodeException{
	 
	
		 boolean flag = userDao.user_login(user.getUserName(), user.getpassword()); //���ó־ò�ĵ��뷽��
		
		 if(flag == false){
			 throw new ErrorCodeException("user.login.error");
		 }
		 return flag; 
 }
 
 /*
  * ����Ա���뷽��
  * @see com.cx.bank.manager.ManagerImInterface#admin_login(com.cx.bank.model.AdminBean)
  */
 public boolean admin_login(AdminBean admin) throws ErrorCodeException{
	 
		
	 boolean flag = userDao.admin_login(admin.getName(), admin.getPassword()); //���ó־ò�ĵ��뷽��
	
	 if(flag == false){
		 throw new ErrorCodeException("user.login.error");
	 }
	 return flag; 
}
 
 
 /*
  * ��ѯ����
  * @see com.cx.bank.manager.ManagerImInterface#Inquiry()
  */
 
 public double Inquiry(){
	 
	  double money = userDao.Inquiry();//���ó־ò�Ĳ�ѯ����
	 moneybean.setMoney(money); 
	 return money;
 }
 

 /*
  * ȡ���
  * @see com.cx.bank.manager.ManagerImInterface#Withdrawals(double)
  */
 public double Withdrawals(double Withdrawalsmoney) throws ErrorCodeException {
	 
	 if(Withdrawalsmoney<=0){
		 throw new ErrorCodeException("your.withdrawal.amount.is.incorrect"); 
	 }
	 if(Withdrawalsmoney>moneybean.getMoney()){
		 System.out.println("ȡ��ʧ��");
		throw new ErrorCodeException("withdrawal.failed.your.balance.is.insuffcient");
	 }
	 else{
		 userDao.Withdrawals(Withdrawalsmoney);//���ó־ò��ȡ���
	 }
	 return moneybean.getMoney();
 
 }
 
 
 /*
  * ����
  * @see com.cx.bank.manager.ManagerImInterface#Deposit(double)
  */
 public boolean Deposit(double Depositmoney)throws ErrorCodeException{
	 if(Depositmoney<=0){
		 throw new ErrorCodeException("deposit.failed.your.deposit.amount.error");
	 }
	 boolean flag = userDao.Deposit(Depositmoney);//���ó־ò�Ĵ���
	 return flag;
 }
 
 /*
  * ��ѯ�û����׼�¼����
  * @see com.cx.bank.manager.ManagerImInterface#findRecord(int, int)
  */
 
 public PageModel findRecord(int pageNo, int pageSize){
	 
	 PageModel pagemodel = userDao.findRecord(pageNo, pageSize);//���ó־ò�Ĳ�ѯ��¼����
	 
	 return pagemodel;
 }
 
 /*
  *��ѯ�����û����׼�¼����
  * @see com.cx.bank.manager.ManagerImInterface#find_user_Record(int, int)
  */
 public PageModel find_user_Record(int pageNo, int pageSize){
	 
     PageModel pagemodel = userDao.find_user_Record(pageNo, pageSize);//���ó־ò�Ĳ�ѯ��¼����
	 
	 return pagemodel;
 }
 
 /*
  * //��ҳ��ѯ����Ա�޸ļ�¼����
  * @see com.cx.bank.manager.ManagerImInterface#find_user_admin_Record(int, int)
  */
public PageModel find_user_admin_Record(int pageNo, int pageSize){
	 
     PageModel pagemodel = userDao.find_user_admin_Record(pageNo, pageSize);//���ó־ò�Ĳ�ѯ��¼����
	 
	 return pagemodel;
 }
 
/*
 * ��ѯ�û�ע�᷽��
 * @see com.cx.bank.manager.ManagerImInterface#find_user_register_Record(int, int)
 */
 public PageModel find_user_register_Record(int pageNo, int pageSize){
	 
      PageModel pagemodel = userDao.find_user_register_Record(pageNo, pageSize);//���ó־ò�Ĳ�ѯ��¼����
	 
	 return pagemodel;
 }
 
 /*
  * ��ѯ�û����뷽��
  * @see com.cx.bank.manager.ManagerImInterface#find_user_login_Record(int, int)
  */
 public PageModel find_user_login_Record(int pageNo, int pageSize){
	 
     PageModel pagemodel = userDao.find_user_login_Record(pageNo, pageSize);//���ó־ò�Ĳ�ѯ��¼����
	 
	 return pagemodel;
}
 
 
 /*
  * ����Ա�����˻�����
  * @see com.cx.bank.manager.ManagerImInterface#frozen(int)
  */
 public void frozen(int id){
	 
	 userDao.frozen(id);
	 
 }
 
 /*
  * ����Ա����˻�����
  * @see com.cx.bank.manager.ManagerImInterface#deblocking(int)
  */
 public void deblocking(int id){
	 
	 userDao.deblocking(id);
 }
 
 /*
  * ת�˷���
  * @see com.cx.bank.manager.ManagerImInterface#transfer(java.lang.String, double)
  */
 public boolean transfer(String userName,double money)throws ErrorCodeException{
	 
	 if(money<=0){
		 throw new ErrorCodeException("your.transfer.amount.is.wrong");
	 }
	 if(money>moneybean.getMoney()){
		 throw new ErrorCodeException("your.balance.is.insuffcient");//������Чת���쳣
	 }
	 if(userName.equals(user.getUserName())){
		 throw new ErrorCodeException("you.can.not.transfer.money.to.yourself");
	 }
	 else{
		 
		 boolean flag = userDao.transfer(userName, money);//���ó־ò��ת�˷���
		 if(flag == false){
			 throw new ErrorCodeException("the.transfer.username.does.not.exist",userName); 
		 }
		 userDao.Bank(moneybean.getMoney());
		 return flag;
	 }
 }
 
 /**
  * �˳�ϵͳ����
  */
 public void ExitSystem() {
 	System.out.println("��ӭ�´�ʹ��");
 	userDao.Bank(moneybean.getMoney());//�˳��ͽ��������û��˻���
 	System.out.println(moneybean.getMoney());
 }
 	   
 }
  