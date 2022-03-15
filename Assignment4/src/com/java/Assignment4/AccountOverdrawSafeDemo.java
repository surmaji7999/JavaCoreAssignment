package com.java.Assignment4;

public  class  AccountOverdrawSafeDemo implements Runnable{
    
    Account account=new Account();
    public void run() {
        synchronized (account) {
        String t = Thread.currentThread().getName();
   
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
    }
        
    

    public static void main(String[] args) {
        Account account=new Account();
        AccountOverdrawSafeDemo acds =new AccountOverdrawSafeDemo();
        Thread thread1 =new Thread(acds,"persion 1");
        Thread thread2 =new Thread(acds,"persion 2");
        System.out.println("Account blance"+account.getBalance());
        thread1.start();
        thread2.start();
    }

}
