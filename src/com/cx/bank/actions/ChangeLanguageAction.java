


   package com.cx.bank.actions;

   import java.util.Locale;

   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;

   import org.apache.struts.Globals;
   import org.apache.struts.action.Action;
   import org.apache.struts.action.ActionForm;
   import org.apache.struts.action.ActionForward;
   import org.apache.struts.action.ActionMapping;

   /**
    * <DL><DT><b>功能：</b><DD>银行管理系统的国际化</DD></DL>
    * 银行管理系统3.0Struts版本
    * @version1.0 2018
    * @author 20152135
    * @param <blooean>
    *
    */
   
   public class ChangeLanguageAction extends Action {

	//@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String lang = request.getParameter("lang");
		
		Locale currentLocale = Locale.getDefault(); 
		if ("zh".equals(lang)) {
			currentLocale = new Locale("zh", "CN");
		}else if("en".equals(lang)) {
			currentLocale = new Locale("en", "US");
		}
		//request.getSession().setAttribute(Globals.LOCALE_KEY, currentLocale);
		
		this.setLocale(request, currentLocale);
		return mapping.findForward("index");
	}

}
