
    package com.cx.bank.util;
    /**
     * 自定义一个账户透支异常
     * @author 20152135
     *
     */

    public class AccountOverDrawnException extends ArithmeticException{//账户透支异常继承算数异常
     public AccountOverDrawnException() {
    	 super();
     }
     public AccountOverDrawnException(String message) {
    	 super(message);
     }
   }
