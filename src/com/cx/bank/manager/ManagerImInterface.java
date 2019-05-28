


    package com.cx.bank.manager;

    import java.util.List;
    import com.cx.bank.model.AdminBean;
    import com.cx.bank.model.MoneyBean;
    import com.cx.bank.model.UserBean;
    import com.cx.bank.util.PageModel;

    /**
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ҵ���ӿ�</DD></DL>
     * @version1.0 2018
     * @author 20152135
     *
     */

     public interface ManagerImInterface {
    	 
     public double Inquiry(); //�������������ѯ����
     
     public double Withdrawals(double Withdrawalsmoney) throws ArithmeticException;//���������ȡ������Ҳ����������쳣

     public boolean Deposit(double Depositmoney) throws ArithmeticException;//��������Ĵ������Ҳ����������쳣

     public void ExitSystem();//����������˳�����

     public boolean register(UserBean user);//ע�᷽��

     public boolean user_login(UserBean user);//���뷽��

     public boolean admin_login(AdminBean admin);//���뷽��

     public boolean transfer(String userName, double money);//ת�˷���

     public PageModel findRecord(int pageNo, int pageSize);//��ҳ��ѯ�û����׼�¼����

     public PageModel find_user_Record(int pageNo, int pageSize);//��ҳ��ѯ�����û����׼�¼����
 
     public PageModel find_user_register_Record(int pageNo, int pageSize);//��ҳ��ѯ�û�ע���¼����

     public void frozen(int id);//����Ա�����˻�����

     public void deblocking(int id);//����Ա����˻�����

     public PageModel find_user_login_Record(int pageNo, int pageSize);//��ҳ��ѯ�û������¼����

     public PageModel find_user_admin_Record(int pageNo, int pageSize);//��ҳ��ѯ����Ա�޸ļ�¼����

     }
