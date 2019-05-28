

    package com.cx.bank.dao;

    import java.util.List;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.PageModel;
    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的持久层接口</DD></DL>
     * @version1.0 2018
     * @author 20152135
     *
     */

    public interface BankDaoInterface {
	public boolean register(UserBean user);//注册方法
	
	public boolean user_login(String username,String password);//登入方法
	
	public boolean admin_login(String username,String password);//登入方法
	
	public void Bank(double money);//余额储存方法
	
	public double Inquiry();//获取用户余额方法
	
	public void addRecord(String name,String type,double rmoney,String time);//存储记录方法
	
	public boolean transfer(String userName,double money);//转账方法
	
	public boolean  Deposit(double Depositmoney);//存款方法
	
	public double Withdrawals(double Withdrawalsmoney);//取款方法
	
	public PageModel findRecord(int pageNo, int pageSize);//分页方法
	
	public int getTotalRecords();//查询总记录方法
	
	public void add_login_Record(String name,String type,String password,String time);//添加用户登入记录方法
	
	public PageModel find_user_Record(int pageNo, int pageSize);//查询用户登入记录方法
	
	public int get_user_count();//查询总记录方法
	
	public void add_admin_login_Record(String name,String password,String time,String type);//添加管理员登入记录方法
	
	public PageModel find_user_register_Record(int pageNo, int pageSize);//查询用户注册记录方法
	public int get_user_register_count();//查询总记录方法
	
	public void frozen(int id);//管理员冻结账户方法
	
	public void deblocking(int id);//管理员解封账户方法
	
	public PageModel find_user_login_Record(int pageNo, int pageSize);//查询用户登入记录方法
	
	public int get_user_login_count();//查询总记录方法
	
	public void add_admin_Record(String admin_name,String type,String user_name,String user_password,double user_money,String time);//添管理员修改记录方法
	
	public PageModel find_user_admin_Record(int pageNo, int pageSize);//查询管理员修改记录方法
	
	public int get_user_admin_count();//查询总记录方法
	
    }
