
      package com.cx.bank.util;
      /**
       * �Զ���һ����Ч����쳣
       * @author 20152135
       *
       */

      public class InvalidDepositException extends ArithmeticException{//��Ч����쳣�̳������쳣
      public InvalidDepositException() {
    	  super();
      }
      public InvalidDepositException(String message) {
    	  super(message);
      }
     }
