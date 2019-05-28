

    package com.cx.bank.dao;

    import java.util.List;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.PageModel;
    /**
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ�ĳ־ò�ӿ�</DD></DL>
     * @version1.0 2018
     * @author 20152135
     *
     */

    public interface BankDaoInterface {
	public boolean register(UserBean user);//ע�᷽��
	
	public boolean user_login(String username,String password);//���뷽��
	
	public boolean admin_login(String username,String password);//���뷽��
	
	public void Bank(double money);//���淽��
	
	public double Inquiry();//��ȡ�û�����
	
	public void addRecord(String name,String type,double rmoney,String time);//�洢��¼����
	
	public boolean transfer(String userName,double money);//ת�˷���
	
	public boolean  Deposit(double Depositmoney);//����
	
	public double Withdrawals(double Withdrawalsmoney);//ȡ���
	
	public PageModel findRecord(int pageNo, int pageSize);//��ҳ����
	
	public int getTotalRecords();//��ѯ�ܼ�¼����
	
	public void add_login_Record(String name,String type,String password,String time);//����û������¼����
	
	public PageModel find_user_Record(int pageNo, int pageSize);//��ѯ�û������¼����
	
	public int get_user_count();//��ѯ�ܼ�¼����
	
	public void add_admin_login_Record(String name,String password,String time,String type);//��ӹ���Ա�����¼����
	
	public PageModel find_user_register_Record(int pageNo, int pageSize);//��ѯ�û�ע���¼����
	public int get_user_register_count();//��ѯ�ܼ�¼����
	
	public void frozen(int id);//����Ա�����˻�����
	
	public void deblocking(int id);//����Ա����˻�����
	
	public PageModel find_user_login_Record(int pageNo, int pageSize);//��ѯ�û������¼����
	
	public int get_user_login_count();//��ѯ�ܼ�¼����
	
	public void add_admin_Record(String admin_name,String type,String user_name,String user_password,double user_money,String time);//�����Ա�޸ļ�¼����
	
	public PageModel find_user_admin_Record(int pageNo, int pageSize);//��ѯ����Ա�޸ļ�¼����
	
	public int get_user_admin_count();//��ѯ�ܼ�¼����
	
    }
