package com.cx.bank.model;


/**
 * <DL><DT><b>���ܣ�</b><DD>���й���ϵͳ��ģ�Ͳ�</DD></DL>
 * @version1.0 2018
 * @author 20152135
 *
 */

public class MoneyBean {
	
	private double money;//����һ��˽�е��������
	private static MoneyBean instance;//���徲̬�� MoneyBean����ȫ�ֱ���instance

	//˽�еĹ��췽��
    private MoneyBean() {
    	
    }
    public double getMoney() {//�õ����
    	return this.money;
    }
    public void setMoney(double money) {
    	this.money = money;
    }
    
    
  //���徲̬�������õ�instance�ĵ�ַ
    public static MoneyBean getinstance() { 
    	if(instance == null)
    			{
    			instance=new MoneyBean();
    			}
    			return instance;
    }

}
