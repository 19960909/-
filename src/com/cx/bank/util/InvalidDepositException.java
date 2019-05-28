
      package com.cx.bank.util;
      /**
       * 自定义一个无效存款异常
       * @author 20152135
       *
       */

      public class InvalidDepositException extends ArithmeticException{//无效存款异常继承算数异常
      public InvalidDepositException() {
    	  super();
      }
      public InvalidDepositException(String message) {
    	  super(message);
      }
     }
