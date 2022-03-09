package com.java.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeCalculation {

	public static void main(String[] args) {
	byte  status = 0, choice = 0;
	
	
	System.out.println("Welcome in shape calculation ");
	do {
	System.out.println("----------------------------------------");
	System.out.println("1.for circle");
	System.out.println("2.for ractangle");
	System.out.println("3.for triangle");
	System.out.println("4.for squere");
	System.out.println("5.for sphare");
	System.out.println("6.for cylinder");
	System.out.println("7.for exit");
	System.out.println("----------------------------------------");
	
	Scanner sc = new Scanner(System.in) ;
	try {
	choice=sc.nextByte();
	}
	catch(InputMismatchException ex) {
		System.out.println("Input must be integer type or double  "+ex);
		
		}
	
	
     switch(choice) {
     case 1:
    	Circle circle=new Circle();
    	circle.getInput();
    	circle.area();
    	circle.parimeter();
    	 break;
     case 2:
    	 Ractangle ractangle=new Ractangle();
    	 ractangle.getInput();
    	 ractangle.area();
    	ractangle.parimeter();
    
    	 break;
     case 3:
    	 Triangle triangle=new Triangle();
    	 triangle.getInput();
    	 triangle.area();
    	 triangle.parimeter();
    	 break;
     case 4:
    	 Squre squre=new Squre();
    	 squre.getInput();
    	 squre.area();
    	 squre.parimeter();
    	 break;
     case 5:
    	 Sphare sphare=new Sphare();
    	 sphare.getInput();
    	 sphare.area();
    	 sphare.volume();
    	 break;
     case 6:
    	 Cylinder cylinder=new Cylinder();
    	 cylinder.getInput();
    	 cylinder.area();
    	 cylinder.volume();
    	 break;
     case 7:
    	 System.exit(choice);
    	 break;
     default :
    	System.out.println("Invalid Choice");
    	break;
     
     }
     System.out.println();
     System.out.println("Are you want to continue press 1");
     try {
     status= sc.nextByte();
     }
     catch(InputMismatchException ex) {
			System.out.println("Input must be integer type or double  "+ex);
			
			}
  
	}while( status==1);

}
}
