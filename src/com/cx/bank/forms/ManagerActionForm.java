


    package com.cx.bank.forms;

    import org.apache.struts.action.ActionForm;
    
    /**
     * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ManagerActionForm</DD></DL>
     * ���й���ϵͳ3.0Struts�汾
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */
    
    public class ManagerActionForm extends ActionForm{

	private String withdrawals_money;//���ռ���ȡ����
	
    private String deposit_money;//���ռ��Ĵ����
	
	private String transfer_money;//���ռ���ת�˽��
	
	private String transfer_name;//���ռ���ת���û���
	
	//�ڼ�ҳ
	private int pageNo;
	
	//ÿҳ������
	private int pageSize;	
	
	private int id;

	private String password;
		
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getWithdrawals_money() {
		return withdrawals_money;
	}

	public void setWithdrawals_money(String withdrawals_money) {
		this.withdrawals_money = withdrawals_money;
	}

	public String getDeposit_money() {
		return deposit_money;
	}

	public void setDeposit_money(String deposit_money) {
		this.deposit_money = deposit_money;
	}

	public String getTransfer_money() {
		return transfer_money;
	}

	public void setTransfer_money(String transfer_money) {
		this.transfer_money = transfer_money;
	}

	public String getTransfer_name() {
		return transfer_name;
	}

	public void setTransfer_name(String transfer_name) {
		this.transfer_name = transfer_name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
