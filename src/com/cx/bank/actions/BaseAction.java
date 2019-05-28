


   package com.cx.bank.actions;

   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;

   import org.apache.struts.action.ActionForm;
   import org.apache.struts.action.ActionForward;
   import org.apache.struts.action.ActionMapping;
   import org.apache.struts.actions.DispatchAction;

   /**
    * <DL><DT><b>功能：</b><DD>银行管理系统的BaseAction</DD></DL>
    * 银行管理系统3.0Struts版本
    * @version1.0 2018
    * @author 20152135
    * @param boolean
    *
    */
   public class BaseAction extends DispatchAction {

	//@Override
	
	/*
	 * 验证session是否有验证信息
	 * @see org.apache.struts.actions.DispatchAction#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getSession().getAttribute("flag") == null) {
			return mapping.findForward("index");
		}
		
		return super.execute(mapping, form, request, response);
	}

}
