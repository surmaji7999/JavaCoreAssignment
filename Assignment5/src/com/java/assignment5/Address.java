package com.java.assignment5;

import java.io.Serializable;

public class Address implements Serializable{
/**
     * 
     */
    private static final long serialVersionUID = 8687685156597403345L;
String city,state,country;
int pinCode;
Address(String city,String state,int pinCode,String country){
    super();
    this.city=city;
    this.state=state;
    this.pinCode=pinCode;
    this.country=country;
           
}

}
