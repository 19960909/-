


    package com.cx.bank.forms;

    import org.apache.struts.action.ActionForm;
    
    /**
     * <DL><DT><b>功能：</b><DD>银行管理系统的ManagerActionForm</DD></DL>
     * 银行管理系统3.0Struts版本
     * @version1.0 2018
     * @author 20152135
     * @param <blooean>
     *
     */
    
    public class ManagerActionForm extends ActionForm{

	private String withdrawals_money;//表单收集的取款金额
	
    private String deposit_money;//表单收集的存款金额
	
	private String transfer_money;//表单收集的转账金额
	
	private String transfer_name;//表单收集的转账用户名
	
	//第几页
	private int pageNo;
	
	//每页多少条
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
