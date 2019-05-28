


   package com.cx.bank.actions;

   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;

   import org.apache.struts.action.ActionForm;
   import org.apache.struts.action.ActionForward;
   import org.apache.struts.action.ActionMapping;
   import org.apache.struts.actions.DispatchAction;

   /**
    * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��BaseAction</DD></DL>
    * ���й���ϵͳ3.0Struts�汾
    * @version1.0 2018
    * @author 20152135
    * @param boolean
    *
    */
   public class BaseAction extends DispatchAction {

	//@Override
	
	/*
	 * ��֤session�Ƿ�����֤��Ϣ
	 * @see org.apache.struts.actions.DispatchAction#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getSession().getAttribute("flag") == null) {
			return mapping.findForward("index");
		}
		
		return super.execute(mapping, form, request, response);
	}

}
