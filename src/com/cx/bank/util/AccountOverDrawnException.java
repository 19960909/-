
    package com.cx.bank.util;
    /**
     * �Զ���һ���˻�͸֧�쳣
     * @author 20152135
     *
     */

    public class AccountOverDrawnException extends ArithmeticException{//�˻�͸֧�쳣�̳������쳣
     public AccountOverDrawnException() {
    	 super();
     }
     public AccountOverDrawnException(String message) {
    	 super(message);
     }
   }
