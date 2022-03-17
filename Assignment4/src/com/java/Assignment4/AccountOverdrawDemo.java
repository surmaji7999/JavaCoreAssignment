package com.java.Assignment4;


public class AccountOverdrawDemo implements Runnable{
    Account account=new Account();
   
    
    public void run() {
        String t = Thread.currentThread().getName();
        System.out.println("Account blance"+account.getBalance());
        account.withdraw(100);
        System.out.println(t+" withdra 100");
        System.out.println("Account blance "+account.getBalance());
        
        account.withdraw(300);
        System.out.println(t+" withdra 300");
        System.out.println("Account blance "+account.getBalance());
        
        account.withdraw(200);
        System.out.println(t+" withdra 200");
        System.out.println("Account blance "+account.getBalance());
            
        }
    

    public static void main(String[] args) {
        AccountOverdrawDemo object=new AccountOverdrawDemo();
        Thread thread1=new Thread(object,"persion 1");
        Thread thread2=new Thread(object,"persion 2");
        thread1.start();
        thread2.start();
    }

}
