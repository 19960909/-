


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
    * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��LoginAction</DD></DL>
    * ���й���ϵͳ3.0Struts�汾
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
	 * ���е���ϵͳ5.0
	 * ���뷽��
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		LoginActionForm login = (LoginActionForm)form;//����ActionForm����
		HttpSession session = request.getSession();//�õ�session
		String username = login.getUsername();//�õ��û���
		String password = login.getPassword();//�õ�����
		String id = login.getId();
		UserBean user = new UserBean();//����UserBean����
		
		user.setUserName(username);//���û������õ�UserBean��
		user.setpassword(password);//���������õ�UserBean��
		
		AdminBean admin = new AdminBean();
		admin.setName(username);
		admin.setPassword(password);
		
		if(Integer.parseInt(id) == 1){
			
			boolean flag =managerImpI.admin_login(admin);
			if(flag){
				System.out.println("%%%%"+username);
				session.setAttribute("flag","ok");//��session��������֤��Ϣ
				return mapping.findForward("success");//����ת����Ϣ
			}
		
			else{
				return mapping.findForward("error");//����ת����Ϣ
			}
		}
		
		else{
			
			boolean flag =managerImpI.user_login(user);
			if(flag){
				System.out.println("%%%%"+username);
				session.setAttribute("flag","ok");//��session��������֤��Ϣ
				return mapping.findForward("user_success");//����ת����Ϣ
			}
			else{
				return mapping.findForward("error");//����ת����Ϣ
			}
			
		}
		
	}
	
	
	/*
	 * ���е���ϵͳ5.0
	 * ע�᷽��
	 */
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		LoginActionForm register = (LoginActionForm)form;//����ActionForm����
		String username = register.getUsername();//�õ��û���
		String password = register.getPassword();//�õ�����
		UserBean user = new UserBean();//����UserBean����
		System.out.println("*****"+username);
		user.setUserName(username);//���û������õ�UserBean��
		user.setpassword(password);//���������õ�UserBean��
		user.setMoney(10);
		user.setFrozen(false);
		
		boolean flag =managerImpI.register(user);
		if(flag){
			return mapping.findForward("register_success");//����ת����Ϣ
		}
		else{
			return mapping.findForward("register_error");//����ת����Ϣ
		}
	}
	
		
}
