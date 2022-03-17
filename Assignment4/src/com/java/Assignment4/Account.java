package com.java.Assignment4;

public class Account {
    private float balance=1000;
    
    
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    
    public void withdraw( float amount ) {
        if(balance>0) {
        balance=balance-amount;
      
        }
        else {
       System.out.println("unsufficent balance");
            
        }
    }

}
