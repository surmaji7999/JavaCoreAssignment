package com.java.assignment5;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 5581839595690640568L;
    String firstName;
    Date dateOfBirth;
    Address address;
    Student(String firstName,String dateOfBirth,String city, String state,int pinCode,String country) throws ParseException{
        this.firstName=firstName;
        this.dateOfBirth= new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
       address= new Address(city,state,pinCode,country);
    }
    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + ", City=" + address.city +", State= "+address.state +", Pincode= "+address.pinCode+", Country= "+address.country +" ]";
              
    }
    

}
