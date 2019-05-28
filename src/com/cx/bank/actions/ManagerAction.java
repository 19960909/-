

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
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ManagerAction</DD></DL>
     * ���й���ϵͳ5.0Struts�汾
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
	 * ���û�д����κα�ʶ��������command����������Ĭ�ϵ���unspecified����
	 */
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("ItemAction=>>unspecified()");
		ActionForward listActionForward = new ActionForward("/index.jsp", true);
		return listActionForward;
	}
    
	/*
	 * ���е���ϵͳ5.0
	 * ��ѯ����
	 */
	public ActionForward Inquiry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		//System.out.println("@@@@@"+managerImpI.Inquiry());
		request.setAttribute("money1", String.valueOf(managerImpI.Inquiry()));//��request��������Ϣ
		return mapping.findForward("inquiry");//����ת����Ϣ
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * ȡ���
	 */
	public ActionForward Withdrawals(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
		double money = Double.parseDouble(man.getWithdrawals_money());//�õ�ȡ����
		request.setAttribute("money2", String.valueOf(managerImpI.Withdrawals(money)));//��request��������Ϣ
		return mapping.findForward("withdrawals");//����ת����Ϣ
		
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * ����
	 */
	public ActionForward Deposit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
		MoneyBean moneybean =MoneyBean.getinstance();//����MoneyBean����
		double money = Double.parseDouble(man.getDeposit_money());//�õ������
		
		boolean flag = managerImpI.Deposit(money);//����ҵ������
		if(flag)
			request.setAttribute("money3",String.valueOf(moneybean.getMoney()));//��request��������Ϣ
			return mapping.findForward("deposit");//����ת����Ϣ
		
		
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * ת�˷���
	 */
	public ActionForward Transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
		MoneyBean moneybean =MoneyBean.getinstance();//����MoneyBean����
		double money = Double.parseDouble(man.getTransfer_money());//�õ�ת�˽��
		String name = man.getTransfer_name();//�õ�ת���û���
		
		boolean flag = managerImpI.transfer(name, money);//����ҵ���ת�˷���
		if(flag)
			request.setAttribute("money4",String.valueOf(moneybean.getMoney()));//��request��������Ϣ
			return mapping.findForward("transfer");//����ת����Ϣ
		
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * �˳�ϵͳ����
	 */
	public ActionForward ExitSystem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
  		managerImpI.ExitSystem();//�����˳�ϵͳ����	 
  		return mapping.findForward("exit");//����ת����Ϣ
	}

	
	/*
	 * ���е���ϵͳ5.0
	 * ��ѯ�û����׼�¼����
	 */
	public ActionForward findRecord(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
		PageModel pageModel = managerImpI.findRecord(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
		request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
		return mapping.findForward("record1");//����ת����Ϣ
		
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * ��ѯ�����û����׼�¼����
	 */
	public ActionForward find_user_Record(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
		PageModel pageModel = managerImpI.find_user_Record(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
		request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
		return mapping.findForward("record");//����ת����Ϣ
		
	}
			
			/*
			 * ���е���ϵͳ5.0
			 * //��ҳ��ѯ����Ա�޸ļ�¼����
			 */
			public ActionForward find_user_admin_Record(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception{
				
				ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
				PageModel pageModel = managerImpI.find_user_admin_Record(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
				request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
				return mapping.findForward("admin_record");//����ת����Ϣ
				
			}
			
			/*
			 * ���е���ϵͳ5.0
			 * ��ѯ�û������¼����
			 */
			public ActionForward find_user_login_Record(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception{
				
				ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
				PageModel pageModel = managerImpI.find_user_login_Record(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
				request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
				return mapping.findForward("user_login_record");//����ת����Ϣ
				
			}		
			
	
	/*
	 * ���е���ϵͳ5.0
	 * ��ѯ�û�ע���¼����
	 */
	public ActionForward find_user_register_Record(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
		PageModel pageModel = managerImpI.find_user_register_Record(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
		request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
		return mapping.findForward("register_record");//����ת����Ϣ
		
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * ����Ա�����˻�����
	 */
	
	public ActionForward frozen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
        
		System.out.println("@@@@@@@"+man.getId());
		 managerImpI.frozen(man.getId());//����ҵ����ҳ����
		
		PageModel pageModel = managerImpI.find_user_register_Record(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
		request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
		return mapping.findForward("register_record");//����ת����Ϣ
		
	}
	
	/*
	 * ���е���ϵͳ5.0
	 * ����Ա����˻�����
	 */
	public ActionForward deblocking(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		ManagerActionForm man = (ManagerActionForm)form;//����ActionForm����
        
		System.out.println("@@@@@@@"+man.getId());
		 managerImpI.deblocking(man.getId());//����ҵ����ҳ����
		
		PageModel pageModel = managerImpI.find_user_register_Record(man.getPageNo(), man.getPageSize());//����ҵ����ҳ����
		request.setAttribute("pagemodel", pageModel);//��request��������Ϣ
		return mapping.findForward("register_record");//����ת����Ϣ
		
	}	
		
}
