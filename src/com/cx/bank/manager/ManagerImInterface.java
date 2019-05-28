


    package com.cx.bank.manager;

    import java.util.List;
    import com.cx.bank.model.AdminBean;
    import com.cx.bank.model.MoneyBean;
    import com.cx.bank.model.UserBean;
    import com.cx.bank.util.PageModel;

    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的业务层接口</DD></DL>
     * @version1.0 2018
     * @author 20152135
     *
     */

     public interface ManagerImInterface {
    	 
     public double Inquiry(); //创建抽象的余额查询方法
     
     public double Withdrawals(double Withdrawalsmoney) throws ArithmeticException;//创建抽象的取款方法并且不处理算数异常

     public boolean Deposit(double Depositmoney) throws ArithmeticException;//创建抽象的存款方法并且不处理算数异常

     public void ExitSystem();//创建抽象的退出方法

     public boolean register(UserBean user);//注册方法

     public boolean user_login(UserBean user);//登入方法

     public boolean admin_login(AdminBean admin);//登入方法

     public boolean transfer(String userName, double money);//转账方法

     public PageModel findRecord(int pageNo, int pageSize);//分页查询用户交易记录方法

     public PageModel find_user_Record(int pageNo, int pageSize);//分页查询所有用户交易记录方法
 
     public PageModel find_user_register_Record(int pageNo, int pageSize);//分页查询用户注册记录方法

     public void frozen(int id);//管理员冻结账户方法

     public void deblocking(int id);//管理员解封账户方法

     public PageModel find_user_login_Record(int pageNo, int pageSize);//分页查询用户登入记录方法

     public PageModel find_user_admin_Record(int pageNo, int pageSize);//分页查询管理员修改记录方法

     }
