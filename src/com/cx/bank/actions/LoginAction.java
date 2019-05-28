


   package com.cx.bank.actions;

   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;

   import org.apache.struts.action.Action;
   import org.apache.struts.action.ActionForm;
   import org.apache.struts.action.ActionForward;
   import org.apache.struts.action.ActionMapping;
   import org.apache.struts.actions.DispatchAction;

   import com.cx.bank.forms.LoginActionForm;
   import com.cx.bank.manager.ManagerImInterface;
   import com.cx.bank.manager.ManagerImpI;
import com.cx.bank.model.AdminBean;
import com.cx.bank.model.UserBean;
   
   /**
    * <DL><DT><b>功能：</b><DD>银行管理系统的LoginAction</DD></DL>
    * 银行管理系统3.0Struts版本
    * @version1.0 2018
    * @author 20152135
    * @param <blooean>
    *
    */

   public class LoginAction extends DispatchAction{
	   
	private  ManagerImInterface managerImpI;

	public void setManagerImpI(ManagerImInterface managerImpI) {
		this.managerImpI = managerImpI;
	}


	/*
	 * 银行登入系统5.0
	 * 登入方法
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		LoginActionForm login = (LoginActionForm)form;//创建ActionForm对象
		HttpSession session = request.getSession();//得到session
		String username = login.getUsername();//得到用户名
		String password = login.getPassword();//得到秘密
		String id = login.getId();
		UserBean user = new UserBean();//创建UserBean对象
		
		user.setUserName(username);//把用户名设置到UserBean中
		user.setpassword(password);//把密码设置到UserBean中
		
		AdminBean admin = new AdminBean();
		admin.setName(username);
		admin.setPassword(password);
		
		if(Integer.parseInt(id) == 1){
			
			boolean flag =managerImpI.admin_login(admin);
			if(flag){
				System.out.println("%%%%"+username);
				session.setAttribute("flag","ok");//往session中设置验证信息
				return mapping.findForward("success");//设置转向信息
			}
		
			else{
				return mapping.findForward("error");//设置转向信息
			}
		}
		
		else{
			
			boolean flag =managerImpI.user_login(user);
			if(flag){
				System.out.println("%%%%"+username);
				session.setAttribute("flag","ok");//往session中设置验证信息
				return mapping.findForward("user_success");//设置转向信息
			}
			else{
				return mapping.findForward("error");//设置转向信息
			}
			
		}
		
	}
	
	
	/*
	 * 银行登入系统5.0
	 * 注册方法
	 */
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		LoginActionForm register = (LoginActionForm)form;//创建ActionForm对象
		String username = register.getUsername();//得到用户名
		String password = register.getPassword();//得到密码
		UserBean user = new UserBean();//创建UserBean对象
		System.out.println("*****"+username);
		user.setUserName(username);//把用户名设置到UserBean中
		user.setpassword(password);//把密码设置到UserBean中
		user.setMoney(10);
		user.setFrozen(false);
		
		boolean flag =managerImpI.register(user);
		if(flag){
			return mapping.findForward("register_success");//设置转向信息
		}
		else{
			return mapping.findForward("register_error");//设置转向信息
		}
	}
	
		
}
