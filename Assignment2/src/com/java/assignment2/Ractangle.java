package com.java.assignment2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ractangle extends Shape {
	double length,width,area,parimeter;
@Override
public void getInput() {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length:");
		length=sc.nextDouble();
		System.out.println("Enter width:");
		width=sc.nextDouble();
	
	if(length<=0&&width<=0) {
		System.out.println("Please enter only positive values");
		getInput();
	}
	}
	catch(InputMismatchException ex) {
		System.out.println("Input must be integer type or double  "+ex);
		
		}
}
@Override
public void area() {
	area=width*length;
	System.out.println("Area of ractangle of width "+width+" and length "+length+" = "+area);
}
public void parimeter() {
	parimeter=2*(length+width);
	System.out.println("Parimeter of ractangle of width "+width+" and length "+length+" = "+parimeter);
}
 
}
