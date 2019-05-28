package com.cx.bank.model;


/**
 * <DL><DT><b>功能：</b><DD>银行管理系统的模型层</DD></DL>
 * @version1.0 2018
 * @author 20152135
 *
 */

public class MoneyBean {
	
	private double money;//定义一个私有的余额属性
	private static MoneyBean instance;//定义静态的 MoneyBean类型全局变量instance

	//私有的构造方法
    private MoneyBean() {
    	
    }
    public double getMoney() {//得到余额
    	return this.money;
    }
    public void setMoney(double money) {
    	this.money = money;
    }
    
    
  //定义静态方法，得到instance的地址
    public static MoneyBean getinstance() { 
    	if(instance == null)
    			{
    			instance=new MoneyBean();
    			}
    			return instance;
    }

}
