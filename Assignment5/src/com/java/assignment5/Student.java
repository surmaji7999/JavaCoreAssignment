package com.java.assignment5;

import java.io.Serializable;

public class Student implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 5581839595690640568L;
    String firstName;
    String dateOfBirth;
    Address address;
    Student(String firstName,String dateOfBirth,String city, String state,int pinCode,String country){
        this.firstName=firstName;
        this.dateOfBirth=dateOfBirth;
       address= new Address(city,state,pinCode,country);
    }
    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + ", City=" + address.city +", State= "+address.state +", Pincode= "+address.pinCode+", Country= "+address.country +" ]";
              
    }
    

}
