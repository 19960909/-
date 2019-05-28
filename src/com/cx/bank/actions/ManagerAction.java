

    package com.cx.bank.actions;

    import java.util.ArrayList;

    import java.util.List;

    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;

    import org.apache.struts.action.ActionForm;
    import org.apache.struts.action.ActionForward;
    import org.apache.struts.action.ActionMapping;
    import org.apache.struts.actions.DispatchAction;


    import com.cx.bank.forms.LoginActionForm;
    import com.cx.bank.forms.ManagerActionForm;
    import com.cx.bank.manager.ManagerImInterface;
    import com.cx.bank.manager.ManagerImpI;
    import com.cx.bank.model.MoneyBean;
import com.cx.bank.util.PageModel;

    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的ManagerAction</DD></DL>
     * 银行管理系统5.0Struts版本
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */
    public class ManagerAction extends BaseAction{
    	
    private  ManagerImInterface managerImpI;

	public void setManagerImpI(ManagerImInterface managerImpI) {
		this.managerImpI = managerImpI;
	}

	/**
	 * 如果没有传递任何标识参数（如command参数），则默认调用unspecified方法
	 */
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("ItemAction=>>unspecified()");
		ActionForward listActionForward = new ActionForward("/index.jsp", true);
		return listActionForward;
	}
    
	/*
	 * 银行登入系统5.0
	 * 查询余额方法
	 */
	public ActionForward Inquiry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		//System.out.println("@@@@@"+managerImpI.Inquiry());
		request.setAttribute("money1", String.valueOf(managerImpI.Inquiry()));//在request中设置信息
		return mapping.findForward("inquiry");//设置转向信息
	}
	
	/*
	 * 银行登入系统5.0
	 * 取款方法
	 */
	public ActionForward Withdrawals(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
		double money = Double.parseDouble(man.getWithdrawals_money());//得到取款金额
		request.setAttribute("money2", String.valueOf(managerImpI.Withdrawals(money)));//在request中设置信息
		return mapping.findForward("withdrawals");//设置转向信息
		
	}
	
	/*
	 * 银行登入系统5.0
	 * 存款方法
	 */
	public ActionForward Deposit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
		MoneyBean moneybean =MoneyBean.getinstance();//创建MoneyBean对象
		double money = Double.parseDouble(man.getDeposit_money());//得到存款金额
		
		boolean flag = managerImpI.Deposit(money);//调用业务层存款方法
		if(flag)
			request.setAttribute("money3",String.valueOf(moneybean.getMoney()));//在request中设置信息
			return mapping.findForward("deposit");//设置转向信息
		
		
	}
	
	/*
	 * 银行登入系统5.0
	 * 转账方法
	 */
	public ActionForward Transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
		MoneyBean moneybean =MoneyBean.getinstance();//创建MoneyBean对象
		double money = Double.parseDouble(man.getTransfer_money());//得到转账金额
		String name = man.getTransfer_name();//得到转账用户名
		
		boolean flag = managerImpI.transfer(name, money);//调用业务层转账方法
		if(flag)
			request.setAttribute("money4",String.valueOf(moneybean.getMoney()));//在request中设置信息
			return mapping.findForward("transfer");//设置转向信息
		
	}
	
	/*
	 * 银行登入系统5.0
	 * 退出系统方法
	 */
	public ActionForward ExitSystem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
  		managerImpI.ExitSystem();//调用退出系统方法	 
  		return mapping.findForward("exit");//设置转向信息
	}

	
	/*
	 * 银行登入系统5.0
	 * 查询用户交易记录方法
	 */
	public ActionForward findRecord(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
		PageModel pageModel = managerImpI.findRecord(man.getPageNo(), man.getPageSize());//调用业务层分页方法
		request.setAttribute("pagemodel", pageModel);//在request中设置信息
		return mapping.findForward("record1");//设置转向信息
		
	}
	
	/*
	 * 银行登入系统5.0
	 * 查询所有用户交易记录方法
	 */
	public ActionForward find_user_Record(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
		PageModel pageModel = managerImpI.find_user_Record(man.getPageNo(), man.getPageSize());//调用业务层分页方法
		request.setAttribute("pagemodel", pageModel);//在request中设置信息
		return mapping.findForward("record");//设置转向信息
		
	}
			
			/*
			 * 银行登入系统5.0
			 * //分页查询管理员修改记录方法
			 */
			public ActionForward find_user_admin_Record(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception{
				
				ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
				PageModel pageModel = managerImpI.find_user_admin_Record(man.getPageNo(), man.getPageSize());//调用业务层分页方法
				request.setAttribute("pagemodel", pageModel);//在request中设置信息
				return mapping.findForward("admin_record");//设置转向信息
				
			}
			
			/*
			 * 银行登入系统5.0
			 * 查询用户登入记录方法
			 */
			public ActionForward find_user_login_Record(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception{
				
				ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
				PageModel pageModel = managerImpI.find_user_login_Record(man.getPageNo(), man.getPageSize());//调用业务层分页方法
				request.setAttribute("pagemodel", pageModel);//在request中设置信息
				return mapping.findForward("user_login_record");//设置转向信息
				
			}		
			
	
	/*
	 * 银行登入系统5.0
	 * 查询用户注册记录方法
	 */
	public ActionForward find_user_register_Record(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
		PageModel pageModel = managerImpI.find_user_register_Record(man.getPageNo(), man.getPageSize());//调用业务层分页方法
		request.setAttribute("pagemodel", pageModel);//在request中设置信息
		return mapping.findForward("register_record");//设置转向信息
		
	}
	
	/*
	 * 银行登入系统5.0
	 * 管理员冻结账户方法
	 */
	
	public ActionForward frozen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
        
		System.out.println("@@@@@@@"+man.getId());
		 managerImpI.frozen(man.getId());//调用业务层分页方法
		
		PageModel pageModel = managerImpI.find_user_register_Record(man.getPageNo(), man.getPageSize());//调用业务层分页方法
		request.setAttribute("pagemodel", pageModel);//在request中设置信息
		return mapping.findForward("register_record");//设置转向信息
		
	}
	
	/*
	 * 银行登入系统5.0
	 * 管理员解封账户方法
	 */
	public ActionForward deblocking(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//创建ActionForm对象
        
		System.out.println("@@@@@@@"+man.getId());
		 managerImpI.deblocking(man.getId());//调用业务层分页方法
		
		PageModel pageModel = managerImpI.find_user_register_Record(man.getPageNo(), man.getPageSize());//调用业务层分页方法
		request.setAttribute("pagemodel", pageModel);//在request中设置信息
		return mapping.findForward("register_record");//设置转向信息
		
	}	
		
}
